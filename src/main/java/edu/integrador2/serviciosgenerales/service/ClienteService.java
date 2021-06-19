package edu.integrador2.serviciosgenerales.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.entity.Cliente;
import edu.integrador2.serviciosgenerales.repository.ClienteRepository;

@Service
public class ClienteService implements UserDetailsService {
  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;
  @Autowired
  ClienteRepository defaultRepository;

  public ArrayList<Cliente> listarClientes() {
    return (ArrayList<Cliente>) defaultRepository.findAll();
  }

  public List<Cliente> list() {
    return (List<Cliente>) defaultRepository.findAll();
  }

  public Optional<Cliente> get(Long id) {
    return (Optional<Cliente>) defaultRepository.findById(id);
  }

  public Cliente create(Cliente obj) {
    // Encriptar contraseña
    final String encryptedPassword = bCryptPasswordEncoder.encode(obj.getContrasena());
    obj.setContrasena(encryptedPassword);
    return defaultRepository.save(obj);
  }

  public Cliente update(Long id, Cliente obj) {
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
    return defaultRepository.save(obj);
  }

  public void delete(Long id) {
    defaultRepository.deleteById(id);
  }

  public void eliminar(Long id) {
    defaultRepository.deleteById(id);
  }

  /**
   * 
   * @deprecated Usar create
   */
  public Cliente registrar(Cliente model) {
    // Encriptar contraseña
    final String encryptedPassword = bCryptPasswordEncoder.encode(model.getPassword());
    model.setContrasena(encryptedPassword);

    return defaultRepository.save(model);
  }

  /**
   * 
   * @deprecated Usar update
   */
  public Cliente guardarCliente(Cliente cliente) {
    return defaultRepository.save(cliente);
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
