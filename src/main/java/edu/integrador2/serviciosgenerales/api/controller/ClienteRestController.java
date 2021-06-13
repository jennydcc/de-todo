package edu.integrador2.serviciosgenerales.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.integrador2.serviciosgenerales.entity.Cliente;
import edu.integrador2.serviciosgenerales.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteRestController {
  @Autowired
  ClienteService clienteService;

  @GetMapping()
  public ArrayList<Cliente> listar() {
    return clienteService.listarClientes();
  }

  @PostMapping()
  public Cliente guardar(@RequestBody Cliente cliente) {
    return clienteService.guardarCliente(cliente);
  }


 

}
