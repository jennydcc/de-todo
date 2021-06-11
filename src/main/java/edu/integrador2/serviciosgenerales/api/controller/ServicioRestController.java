package edu.integrador2.serviciosgenerales.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.integrador2.serviciosgenerales.dto.ServicioDto;
import edu.integrador2.serviciosgenerales.service.ServicioService;

@RestController
@RequestMapping("/api/v1/servicios")
public class ServicioRestController {
  @Autowired
  ServicioService entityService;

  @GetMapping()
  public List<ServicioDto> listar() {
    return entityService.listar();
  }
}
