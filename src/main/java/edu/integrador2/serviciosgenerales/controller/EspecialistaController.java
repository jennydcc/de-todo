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
  EspecialistaService entityService;

  @GetMapping("/especialista/")
  public String homePage(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    return "especialista/servicios-requeridos";
  }

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

  @PostMapping(path = "/especialista/registrar", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public String registrarEspecialista(Especialista model, Model uiModel) {
    entityService.registrar(model);
    Template.addGlobalAttributes(uiModel);
    return "redirect:/especialista/login";
  }

  @GetMapping("/especialista/servicios-requeridos")
  public String solicitarServicio(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 0);
    return "especialista/servicios-requeridos";
  }
  @GetMapping("/especialista/registrarservicio")
  public String registrarServicio(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 1);
    return "especialista/registrarservicio";
  }

  @GetMapping("/especialista/comentarios")
  public String especislistacomentarios(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 2);
    return "especialista/comentarios";
  }
}
