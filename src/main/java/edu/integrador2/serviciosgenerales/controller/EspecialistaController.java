package edu.integrador2.serviciosgenerales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.integrador2.serviciosgenerales.entity.Especialista;
import edu.integrador2.serviciosgenerales.entity.Usuario;
import edu.integrador2.serviciosgenerales.security.SessionManager;
import edu.integrador2.serviciosgenerales.service.ClienteService;
import edu.integrador2.serviciosgenerales.service.EspecialistaService;

@Controller
public class EspecialistaController {

  @Autowired
  ClienteService clienteService;
  @Autowired
  EspecialistaService especialistaService;

  @GetMapping("/especialista/login")
  public String loginEspecialista() {
    return "especialista/login";
  }

  @GetMapping("/especialista/registrar")
  public String registrarEspecialista() {
    return "especialista/registrar";
  }

  @PostMapping(path = "/registrar-especialista", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public String registrarEspecialista(Especialista model) {
    especialistaService.registrar(model);
    return "redirect:login-especialista";
  }

  @GetMapping("/especialista/servicios-requeridos")
  public String solicitarServicio(Model uiModel) throws Exception {
    Usuario usuario = SessionManager.getUsuario();
    uiModel.addAttribute("usuario", usuario);
    return "especialista/servicios-requeridos";
  }
}
