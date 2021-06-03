package edu.integrador2.serviciosgenerales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.integrador2.serviciosgenerales.entity.Usuario;
import edu.integrador2.serviciosgenerales.security.SessionManager;

@Controller
public class AdministradorController {

  @GetMapping("/main-admin")
  public String mainAdmin(Model uiModel) throws Exception {
    Usuario usuario = SessionManager.getUsuario();
    uiModel.addAttribute("usuario", usuario);
    return "main-admin";
  }
  @GetMapping("/administrador/login")
  public String loginAdministrador(Model uiModel) throws Exception {
    Usuario usuario = SessionManager.getUsuario();
    uiModel.addAttribute("usuario", usuario);
    return "administrador/login";
  }
}
