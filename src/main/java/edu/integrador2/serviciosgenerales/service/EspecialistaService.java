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

import edu.integrador2.serviciosgenerales.entity.Especialista;
import edu.integrador2.serviciosgenerales.repository.EspecialistaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EspecialistaService implements UserDetailsService {
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  EspecialistaRepository defaultRepository;

  public List<Especialista> list() {
    return (List<Especialista>) defaultRepository.findAll();
  }

  public Optional<Especialista> get(Long id) {
    return (Optional<Especialista>) defaultRepository.findById(id);
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

  /**
   * 
   * @deprecated Usar create
   */
  public Especialista registrar(Especialista model) {
    // Encriptar contraseña
    final String encryptedPassword = bCryptPasswordEncoder.encode(model.getPassword());
    model.setContrasena(encryptedPassword);

    return defaultRepository.save(model);
  }

  /**
   * 
   * @deprecated Usar update
   */
  public Especialista actualizar(Long id, Especialista model) {
    return defaultRepository.save(model);
  }

  public Especialista create(Especialista obj) {
    // Encriptar contraseña
    final String encryptedPassword = bCryptPasswordEncoder.encode(obj.getContrasena());
    obj.setContrasena(encryptedPassword);
    return defaultRepository.save(obj);
  }

  public Especialista update(Long id, Especialista obj) {
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
    return defaultRepository.save(obj);
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
