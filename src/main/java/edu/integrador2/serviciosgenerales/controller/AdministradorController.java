package edu.integrador2.serviciosgenerales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.integrador2.serviciosgenerales.entity.Servicio;
import edu.integrador2.serviciosgenerales.service.ClienteService;
import edu.integrador2.serviciosgenerales.service.EspecialistaService;

@Controller
public class AdministradorController {

  @Autowired
  ClienteService clienteService;
  @Autowired
  EspecialistaService especialistaService;

  @GetMapping("/administrador/")
  public String inicio(Model uiModel) throws Exception {
    //Template.addGlobalAttributes(uiModel);
    return adminHome(uiModel);
  }

  @GetMapping("/administrador/login")
  public String loginAdministrador(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    return "administrador/login";
  }

  /* vista reportes, mantenimiento-controller */

  @GetMapping("/administrador/inicio")
  public String adminHome(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 0);
    uiModel.addAttribute("clientes", clienteService.listarClientes());
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

  @GetMapping("/administrador/reportes")
  public String reportesAdmin(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 3);
    // uiModel.addAttribute("reportesAdmin", clienteService.listarClientes());
    return "administrador/reportes";
  }

  /* Eliminar registros de mantenimiento */

  @GetMapping(path = "/cliente/cancelar-cliente/{id}")
  public String cancelarcliente(@PathVariable Long id, Servicio model, Model uiModel) {
    clienteService.eliminar(id);
    return "redirect:/administrador/inicio";
  }

}
