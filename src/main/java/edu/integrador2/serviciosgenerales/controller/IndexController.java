package edu.integrador2.serviciosgenerales.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.integrador2.serviciosgenerales.entity.Cliente;
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

  @PostMapping(path = "/registrar-cliente", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public String postRegistrarCliente(Cliente cliente, Model uiModel) {
    clienteService.guardarCliente(cliente);
    Template.addGlobalAttributes(uiModel);
    return "cliente/registrar";
  }

}
