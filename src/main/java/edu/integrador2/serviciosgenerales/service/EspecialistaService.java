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
  EspecialistaRepository especialistaRepository;


  public List<Especialista> list() {
    return (List<Especialista>) especialistaRepository.findAll();
  }

  public Optional<Especialista> get(Long id) {
    return (Optional<Especialista>) especialistaRepository.findById(id);
  }

  public Especialista create(Especialista obj) {
    return especialistaRepository.save(obj);
  }

  public Especialista update(Long id, Especialista obj) {
    return especialistaRepository.save(obj);
  }

  public void delete(Long id) {
    especialistaRepository.deleteById(id);
  }


  public ArrayList<Especialista> listar() {
    return (ArrayList<Especialista>) especialistaRepository.findAll();
  }


  public Optional<Especialista> obterner(Long id) {
    return (Optional<Especialista>) especialistaRepository.findById(id);
  }

  public Especialista registrar(Especialista model) {
    // Encriptar contraseña
    final String encryptedPassword = bCryptPasswordEncoder.encode(model.getPassword());
    model.setContrasena(encryptedPassword);

    return especialistaRepository.save(model);
  }

  public Especialista actualizar(Long id, Especialista model) {
    return especialistaRepository.save(model);
  }

  public void eliminar(Long id) {
    especialistaRepository.deleteById(id);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    final Optional<Especialista> optionalUser = especialistaRepository.findByCorreo(email);

    if (optionalUser.isPresent()) {
      return optionalUser.get();
    } else {
      throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email));
    }
  }
}
