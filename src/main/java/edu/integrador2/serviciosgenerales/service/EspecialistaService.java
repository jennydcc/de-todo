package edu.integrador2.serviciosgenerales.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.dto.EspecialistaDto;
import edu.integrador2.serviciosgenerales.entity.Especialista;
import edu.integrador2.serviciosgenerales.entity.Usuario;
import edu.integrador2.serviciosgenerales.repository.EspecialistaRepository;
import edu.integrador2.serviciosgenerales.security.SessionManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EspecialistaService implements UserDetailsService {
  @Autowired
  private ModelMapper modelMapper;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  EspecialistaRepository defaultRepository;

  public List<Especialista> list() {
    return (List<Especialista>) defaultRepository.findAll();
  }

  public Optional<Especialista> get(Long id) {
    return (Optional<Especialista>) defaultRepository.findById(id);
  }

  public Optional<EspecialistaDto> getLoggedIn() {
    Usuario loggedUser = SessionManager.getUsuario();
    Optional<Especialista> OptionalObj = (Optional<Especialista>) defaultRepository.findById(loggedUser.getId());
    Optional<EspecialistaDto> optionalDto = Optional.ofNullable(null);
    // Entidad -> Dto
    if (OptionalObj.isPresent()) {
      EspecialistaDto dto = modelMapper.map(OptionalObj.get(), EspecialistaDto.class);
      dto.setContrasena("");
      optionalDto = Optional.of(dto);
    }
    return optionalDto;
  }

  public void delete(Long id) {
    defaultRepository.deleteById(id);
  }

  public ArrayList<Especialista> listar() {
    return (ArrayList<Especialista>) defaultRepository.findAll();
  }

  public Optional<Especialista> obterner(Long id) {
    return (Optional<Especialista>) defaultRepository.findById(id);
  }

  public EspecialistaDto create(Especialista obj) {
    // Encriptar contraseña
    final String encryptedPassword = bCryptPasswordEncoder.encode(obj.getContrasena());
    obj.setContrasena(encryptedPassword);
    defaultRepository.save(obj);
    // Nunca retornamos la contaseña al cliente
    obj.setContrasena("");
    // Entidad -> Dto
    return modelMapper.map(obj, EspecialistaDto.class);
  }

  public EspecialistaDto update(Long id, Especialista obj) {
    // Obtener objeto actual
    Optional<Especialista> optional = get(id);
    if (optional.isPresent()) {
      Especialista currentRecord = optional.get();
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
    return modelMapper.map(obj, EspecialistaDto.class);
  }

  public void eliminar(Long id) {
    defaultRepository.deleteById(id);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    final Optional<Especialista> optionalUser = defaultRepository.findByCorreoIgnoreCase(email);

    if (optionalUser.isPresent()) {
      return optionalUser.get();
    } else {
      throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email));
    }
  }
}
