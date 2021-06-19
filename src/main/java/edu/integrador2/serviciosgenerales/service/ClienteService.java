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
  ClienteRepository entityrepository;

  public ArrayList<Cliente> listarClientes() {
    return (ArrayList<Cliente>) entityrepository.findAll();
  }

  public List<Cliente> list() {
    return (List<Cliente>) entityrepository.findAll();
  }

  public Optional<Cliente> get(Long id) {
    return (Optional<Cliente>) entityrepository.findById(id);
  }

  public Cliente create(Cliente obj) {
    return entityrepository.save(obj);
  }
  public Cliente update(Long id, Cliente obj) {
    return entityrepository.save(obj);
  }
  
  public void delete(Long id) {
    entityrepository.deleteById(id);
  }


  public void eliminar(Long id) {
    entityrepository.deleteById(id);
  }

  public Cliente registrar(Cliente model) {
    // Encriptar contraseña
    final String encryptedPassword = bCryptPasswordEncoder.encode(model.getPassword());
    model.setContrasena(encryptedPassword);

    return entityrepository.save(model);
  }

  public Cliente guardarCliente(Cliente cliente) {
    return entityrepository.save(cliente);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    final Optional<Cliente> optionalUser = entityrepository.findByCorreo(email);

    if (optionalUser.isPresent()) {
      return optionalUser.get();
    } else {
      throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email));
    }
  }
}
