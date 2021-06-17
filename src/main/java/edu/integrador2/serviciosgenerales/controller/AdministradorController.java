package edu.integrador2.serviciosgenerales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministradorController {

  @GetMapping("/administrador/")
  public String inicio(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    return "administrador/inicio";
  }

  @GetMapping("/administrador/login")
  public String loginAdministrador(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    return "administrador/login";
  }

  /* vista reportes, mantenimiento-controller */

  @GetMapping("/administrador/reportes")
  public String reportesadmin(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 1);
    return "administrador/reportes";
  }

  @GetMapping("/administrador/especialidades")
  public String especialidades(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 2);
    return "administrador/especialidades";
  }

  @GetMapping("/administrador/inicio")
  public String mantadmin(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 0);
    return "administrador/inicio";
  }

}
