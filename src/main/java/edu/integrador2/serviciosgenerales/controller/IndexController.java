package edu.integrador2.serviciosgenerales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.integrador2.serviciosgenerales.entity.Cliente;
import edu.integrador2.serviciosgenerales.entity.Usuario;
import edu.integrador2.serviciosgenerales.security.SessionManager;
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
    Usuario usuario = SessionManager.getUsuario();
    uiModel.addAttribute("usuario", usuario);
    return "home";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/login-cliente")
  public String loginCliente() {
    return "login-cliente";
  }

  @GetMapping("/registrar-cliente")
  public String registrarCliente() {
    return "registrar-cliente";
  }

  @GetMapping("/lista-administradores")
  public String listarAdministradores(Model uiModel) {
    uiModel.addAttribute("mensaje", "Hola !!!!");
    return "lista-administradores";
  }

  @PostMapping(path = "/registrar-cliente", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public String postRegistrarCliente(Cliente cliente, Model uiModel) {
    clienteService.guardarCliente(cliente);
    uiModel.addAttribute("mensaje", "Usurio registrado");
    return "registrar-cliente";
  }

  @GetMapping("/home")
  public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
      @RequestParam(name = "age", required = false, defaultValue = "25") String age, Model model) {
    model.addAttribute("name", name);
    model.addAttribute("age", age);
    return "index";
  }
}
