package edu.integrador2.serviciosgenerales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import edu.integrador2.serviciosgenerales.service.ClienteService;
import edu.integrador2.serviciosgenerales.service.EspecialistaService;

@Controller
public class IndexController {

  @Autowired
  ClienteService clienteService;
  @Autowired
  EspecialistaService especialistaService;

  @GetMapping("/")
  public String index(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    return "home";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

}
