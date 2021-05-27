package edu.integrador2.serviciosgenerales.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.entity.Cliente;
import edu.integrador2.serviciosgenerales.repository.ClienteRepository;

@Service
public class ClienteService {
  @Autowired
  ClienteRepository clienteRepository;

  public ArrayList<Cliente> listarClientes() {
    return (ArrayList<Cliente>) clienteRepository.findAll();
  }

  public Cliente guardarCliente(Cliente cliente) {
    return clienteRepository.save(cliente);
  }
}