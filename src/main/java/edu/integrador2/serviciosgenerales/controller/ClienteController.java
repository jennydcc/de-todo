package edu.integrador2.serviciosgenerales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.integrador2.serviciosgenerales.entity.Usuario;
import edu.integrador2.serviciosgenerales.security.SessionManager;

@Controller
public class ClienteController {

  @GetMapping("/cliente/login")
  public String loginCliente() {
    return "cliente/login";
  }

  @GetMapping("/cliente/registrar")
  public String registrarCliente() {
    return "cliente/registrar";
  }

  @GetMapping("/cliente/servicios-solicitados")
  public String serviciosSolicitados(Model uiModel) throws Exception {
    Usuario usuario = SessionManager.getUsuario();
    uiModel.addAttribute("usuario", usuario);
    return "cliente/servicios-solicitados";
  }

  @GetMapping("/cliente/solicitar-servicio")
  public String solicitarServicio(Model uiModel) throws Exception {
    Usuario usuario = SessionManager.getUsuario();
    uiModel.addAttribute("usuario", usuario);
    return "cliente/solicitar-servicio";
  }
}
