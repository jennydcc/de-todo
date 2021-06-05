package edu.integrador2.serviciosgenerales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.integrador2.serviciosgenerales.entity.Cliente;
import edu.integrador2.serviciosgenerales.service.ClienteService;
import edu.integrador2.serviciosgenerales.service.EspecialidadService;
import edu.integrador2.serviciosgenerales.service.EspecialistaService;

@Controller
public class ClienteController {
  @Autowired
  ClienteService entityService;

  @Autowired
  EspecialidadService especialidadService;
  @Autowired
  EspecialistaService especialistaService;

  @GetMapping("/cliente/")
  public String homePage(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    return "cliente/servicios-solicitados";
  }

  @GetMapping("/cliente/login")
  public String loginCliente(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    return "cliente/login";
  }

  @GetMapping("/cliente/registrar")
  public String registrarCliente(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    return "cliente/registrar";
  }

  @PostMapping(path = "/cliente/registrar", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public String postRegistrarCliente(Cliente model, Model uiModel) {
    entityService.registrar(model);
    Template.addGlobalAttributes(uiModel);
    return "redirect:/cliente/login";
  }

  @GetMapping("/cliente/servicios-solicitados")
  public String serviciosSolicitados(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 0);
    return "cliente/servicios-solicitados";
  }

  @GetMapping("/cliente/solicitar-servicio")
  public String solicitarServicio(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 1);
    uiModel.addAttribute("especialidades", especialidadService.listar());
    uiModel.addAttribute("especialistas", especialistaService.listar());
    return "cliente/solicitar-servicio";
  }
}
