package edu.integrador2.serviciosgenerales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

  @GetMapping("/especialista/login")
  public String loginEspecialista(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    return "especialista/login";
  }

  @GetMapping("/especialista/registrar")
  public String registrarEspecialista(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    return "especialista/registrar";
  }

  @PostMapping(path = "/registrar-especialista", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public String registrarEspecialista(Especialista model, Model uiModel) {
    especialistaService.registrar(model);
    Template.addGlobalAttributes(uiModel);
    return "redirect:login-especialista";
  }

  @GetMapping("/especialista/servicios-requeridos")
  public String solicitarServicio(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    return "especialista/servicios-requeridos";
  }
}
