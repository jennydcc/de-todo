package edu.integrador2.serviciosgenerales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.integrador2.serviciosgenerales.entity.Servicio;
import edu.integrador2.serviciosgenerales.service.AdministradorService;
import edu.integrador2.serviciosgenerales.service.ClienteService;
import edu.integrador2.serviciosgenerales.service.EspecialistaService;

@Controller
public class AdministradorController {

  @Autowired
  ClienteService clienteService;
  @Autowired
  EspecialistaService especialistaService;
  @Autowired
  AdministradorService administradorService;

  @GetMapping("/administrador/")
  public String inicio(Model uiModel) throws Exception {
    return home(uiModel);
  }

  @GetMapping("/administrador/login")
  public String loginAdministrador(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    return "administrador/login";
  }

  @GetMapping("/administrador/inicio")
  public String home(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 0);
    return "administrador/inicio";
  }

  @GetMapping("/administrador/mantenimiento-especialista")
  public String adminEspecialista(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 1);
    // uiModel.addAttribute("adminEspecialista", clienteService.listarClientes());
    return "administrador/mantenimiento-especialista";
  }

  @GetMapping("/administrador/mantenimiento-administrador")
  public String adminAdministrador(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 2);
    // uiModel.addAttribute("adminAdministrador", clienteService.listarClientes());
    return "administrador/mantenimiento-administrador";
  }

  @GetMapping("/administrador/especialidades")
  public String especialidades(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 3);
    return "administrador/especialidades";
  }

  @GetMapping("/administrador/administradores")
  public String administradores(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 4);
    return "administrador/administradores";
  }

  @GetMapping("/administrador/especialistas")
  public String especialistas(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 5);
    return "administrador/especialistas";
  }

  @GetMapping("/administrador/reportes")
  public String reportesAdmin(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 6);
    uiModel.addAttribute("clientes", clienteService.list());
    uiModel.addAttribute("especialistas", especialistaService.list());
    uiModel.addAttribute("administradores", administradorService.list());
    return "administrador/reportes";
  }

  /* Eliminar registros de mantenimiento */

  @GetMapping(path = "/cliente/cancelar-cliente/{id}")
  public String cancelarcliente(@PathVariable Long id, Servicio model, Model uiModel) {
    clienteService.eliminar(id);
    return "redirect:/administrador/inicio";
  }

}
