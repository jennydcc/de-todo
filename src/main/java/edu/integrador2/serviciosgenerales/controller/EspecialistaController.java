package edu.integrador2.serviciosgenerales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.integrador2.serviciosgenerales.entity.Especialista;
import edu.integrador2.serviciosgenerales.service.ClienteService;
import edu.integrador2.serviciosgenerales.service.EspecialistaService;

@Controller
public class EspecialistaController {

  @Autowired
  ClienteService clienteService;
  @Autowired
  EspecialistaService especialistaService;

  @GetMapping("/login-especialista")
  public String loginEspecialista() {
    return "login-especialista";
  }

  @GetMapping("/registrar-especialista")
  public String registrarEspecialista() {
    return "registrar-especialista";
  }

  @PostMapping(path = "/registrar-especialista", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public String registrarEspecialista(Especialista model) {
    especialistaService.registrar(model);
    return "redirect:login-especialista";
  }
}
