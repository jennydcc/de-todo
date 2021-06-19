package edu.integrador2.serviciosgenerales.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NotificationController {

  @GetMapping("/especialista/servicios-requeridos/atender")
  public String atender() {
    
    return "Correo ha sido enviado";
  }



 /* @GetMapping("/login")
  public String login() {
    return "login";
  }*/

}
