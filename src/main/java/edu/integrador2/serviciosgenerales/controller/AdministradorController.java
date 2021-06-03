package edu.integrador2.serviciosgenerales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministradorController {

  @GetMapping("/main-admin")
  public String mainAdmin(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    return "main-admin";
  }

  @GetMapping("/administrador/login")
  public String loginAdministrador(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    return "administrador/login";
  }
}
