package edu.integrador2.serviciosgenerales.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.integrador2.serviciosgenerales.entity.Especialista;
import edu.integrador2.serviciosgenerales.service.EspecialistaService;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/especialistas")
public class EspecialistaRestController {

  @Autowired
  EspecialistaService especialistaService;

  @GetMapping()
  public ArrayList<Especialista> listar() {
    return especialistaService.listar();
  }

  @GetMapping(value = "/{id}")
  public Optional<Especialista> obtener(@PathVariable Long id) {
    return especialistaService.obterner(id);
  }

  @PostMapping()
  public Especialista guardar(@RequestBody Especialista model) {
    return especialistaService.registrar(model);
  }

  @PutMapping(value = "/{id}")
  public Especialista actualizar(@PathVariable Long id, @RequestBody Especialista model) {
    return especialistaService.actualizar(id, model);
  }

  @DeleteMapping(value = "/{id}")
  public boolean eliminar(@PathVariable Long id) {
    especialistaService.eliminar(id);
    return true;
  }
}