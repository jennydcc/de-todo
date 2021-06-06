package edu.integrador2.serviciosgenerales.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.integrador2.serviciosgenerales.entity.Servicio;
import edu.integrador2.serviciosgenerales.service.ServicioService;

@RestController
@RequestMapping("/api/v1/servicios")
public class ServicioRestController {
  @Autowired
  ServicioService entityService;

  @GetMapping()
  public ArrayList<Servicio> listar() {
    return entityService.listar();
  }
}
