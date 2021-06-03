package edu.integrador2.serviciosgenerales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

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

  @GetMapping("/cliente/servicios-solicitados")
  public String serviciosSolicitados(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    return "cliente/servicios-solicitados";
  }

  @GetMapping("/cliente/solicitar-servicio")
  public String solicitarServicio(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    return "cliente/solicitar-servicio";
  }
}
