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

import edu.integrador2.serviciosgenerales.entity.Especialidad;
import edu.integrador2.serviciosgenerales.service.EspecialidadService;

@RestController
@RequestMapping("/api/v1/especialidades")
public class EspecialidadesRestController {
  @Autowired
  EspecialidadService defaultService;

  @GetMapping()
  public List<Especialidad> list() {
    return defaultService.list();
  }

  @GetMapping(value = "/{id}")
  public Optional<Especialidad> get(@PathVariable Long id) {
    return defaultService.get(id);
  }

  @PostMapping()
  public Especialidad create(@RequestBody Especialidad model) {
    return defaultService.create(model);
  }

  @PutMapping(value = "/{id}")
  public Especialidad update(@PathVariable Long id, @RequestBody Especialidad model) {
    return defaultService.update(id, model);
  }

  @DeleteMapping(value = "/{id}")
  public boolean eliminar(@PathVariable Long id) {
    defaultService.delete(id);
    return true;
  }
}
