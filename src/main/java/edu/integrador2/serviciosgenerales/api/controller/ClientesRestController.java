package edu.integrador2.serviciosgenerales.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.integrador2.serviciosgenerales.entity.Cliente;
import edu.integrador2.serviciosgenerales.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesRestController {
  @Autowired
  ClienteService clienteService;

  @GetMapping()
  public List<Cliente> list() {
    return clienteService.list();
  }

  @GetMapping(value = "/{id}")
  public Optional<Cliente> get(@PathVariable Long id) {
    return clienteService.get(id);
  }
  
  @PostMapping()
  public Cliente create(@RequestBody Cliente model) {
    return clienteService.create(model);
  }
  
  @PutMapping(value = "/{id}")
  public Cliente update(@PathVariable Long id, @RequestBody Cliente model) {
    return clienteService.update(id, model);
  }

  @DeleteMapping(value = "/{id}")
  public boolean eliminar(@PathVariable Long id) {
    clienteService.delete(id);
    return true;
  }


}
