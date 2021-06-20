package edu.integrador2.serviciosgenerales.api.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.integrador2.serviciosgenerales.dto.ClienteDto;
import edu.integrador2.serviciosgenerales.entity.Cliente;
import edu.integrador2.serviciosgenerales.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesRestController {
  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  ClienteService defaultService;

  @GetMapping()
  public List<Cliente> list() {
    return defaultService.list();
  }

  @GetMapping(value = "/logged-in")
  public Optional<ClienteDto> getLoggedIn() {
    return defaultService.getLoggedIn();
  }

  @GetMapping(value = "/{id}")
  public Optional<Cliente> get(@PathVariable Long id) {
    return defaultService.get(id);
  }

  @PostMapping()
  public ClienteDto create(@RequestBody ClienteDto dto) {
    Cliente entity = modelMapper.map(dto, Cliente.class);
    return defaultService.create(entity);
  }

  @PutMapping(value = "/{id}")
  public ClienteDto update(@PathVariable Long id, @RequestBody ClienteDto dto) {
    Cliente entity = modelMapper.map(dto, Cliente.class);
    return defaultService.update(id, entity);
  }

  @DeleteMapping(value = "/{id}")
  public boolean eliminar(@PathVariable Long id) {
    defaultService.delete(id);
    return true;
  }

}
