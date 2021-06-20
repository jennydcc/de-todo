package edu.integrador2.serviciosgenerales.service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.dto.ClienteDto;
import edu.integrador2.serviciosgenerales.entity.Cliente;
import edu.integrador2.serviciosgenerales.entity.Usuario;
import edu.integrador2.serviciosgenerales.repository.ClienteRepository;
import edu.integrador2.serviciosgenerales.security.SessionManager;

@Service
public class ClienteService implements UserDetailsService {
  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;
  @Autowired
  ClienteRepository defaultRepository;

  public List<Cliente> list() {
    return (List<Cliente>) defaultRepository.findAll();
  }

  public Optional<Cliente> get(Long id) {
    return (Optional<Cliente>) defaultRepository.findById(id);
  }

  public Optional<ClienteDto> getLoggedIn() {
    Usuario loggedUser = SessionManager.getUsuario();
    Optional<Cliente> OptionalObj = (Optional<Cliente>) defaultRepository.findById(loggedUser.getId());
    Optional<ClienteDto> optionalDto = Optional.ofNullable(null);
    // Entidad -> Dto
    if (OptionalObj.isPresent()) {
      ClienteDto dto = modelMapper.map(OptionalObj.get(), ClienteDto.class);
      dto.setContrasena("");
      optionalDto = Optional.of(dto);
    }
    return optionalDto;
  }

  public ClienteDto create(Cliente obj) {
    // Encriptar contraseña
    final String encryptedPassword = bCryptPasswordEncoder.encode(obj.getContrasena());
    obj.setContrasena(encryptedPassword);
    defaultRepository.save(obj);
    // Nunca retornamos la contaseña al cliente
    obj.setContrasena("");
    // Entidad -> Dto
    return modelMapper.map(obj, ClienteDto.class);
  }

  public ClienteDto update(Long id, Cliente obj) {
    // Obtener objeto actual
    Optional<Cliente> optional = get(id);
    if (optional.isPresent()) {
      Cliente currentRecord = optional.get();
      // Si se recibe una contraseña se encripta y se guarda / Sino se asigna su
      // propia contraseña
      if (obj.getContrasena() != "") {
        // Encriptar contraseña
        final String encryptedPassword = bCryptPasswordEncoder.encode(obj.getContrasena());
        obj.setContrasena(encryptedPassword);
      } else {
        obj.setContrasena(currentRecord.getContrasena());
      }
    }
    defaultRepository.save(obj);
    // Nunca retornamos la contaseña al cliente
    obj.setContrasena("");
    // Entidad -> Dto
    return modelMapper.map(obj, ClienteDto.class);
  }

  public void delete(Long id) {
    defaultRepository.deleteById(id);
  }

  public void eliminar(Long id) {
    defaultRepository.deleteById(id);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    final Optional<Cliente> optionalUser = defaultRepository.findByCorreoIgnoreCase(email);

    if (optionalUser.isPresent()) {
      return optionalUser.get();
    } else {
      throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email));
    }
  }
}
