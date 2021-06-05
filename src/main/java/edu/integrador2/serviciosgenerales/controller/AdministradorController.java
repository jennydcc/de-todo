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
}
