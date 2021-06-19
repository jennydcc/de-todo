package edu.integrador2.serviciosgenerales.service;

import java.text.MessageFormat;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.entity.Administrador;
import edu.integrador2.serviciosgenerales.entity.Cliente;
import edu.integrador2.serviciosgenerales.entity.Especialista;
import edu.integrador2.serviciosgenerales.repository.AdministradorRepository;
import edu.integrador2.serviciosgenerales.repository.ClienteRepository;
import edu.integrador2.serviciosgenerales.repository.EspecialistaRepository;

@Service
public class UsuarioService implements UserDetailsService {
  @Autowired
  private HttpServletRequest request;
  @Autowired
  ClienteRepository clienteRepository;
  @Autowired
  EspecialistaRepository especialistaRepository;
  @Autowired
  AdministradorRepository administradorRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    String requestUrl = request.getRequestURI();
    System.out.println(requestUrl);
    // Cliente
    final Optional<Cliente> optionalUser = clienteRepository.findByCorreoIgnoreCase(email);
    if (optionalUser.isPresent()) {
      return optionalUser.get();
    }

    // Especialista
    final Optional<Especialista> optionalUser2 = especialistaRepository.findByCorreoIgnoreCase(email);
    if (optionalUser2.isPresent()) {
      return optionalUser2.get();
    }
    // Administrador
    final Optional<Administrador> optionalUser3 = administradorRepository.findByCorreoIgnoreCase(email);
    if (optionalUser3.isPresent()) {
      return optionalUser3.get();
    }
    throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email));
  }
}
