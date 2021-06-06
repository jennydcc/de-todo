package edu.integrador2.serviciosgenerales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.integrador2.serviciosgenerales.entity.Cliente;
import edu.integrador2.serviciosgenerales.entity.Servicio;
import edu.integrador2.serviciosgenerales.service.ClienteService;
import edu.integrador2.serviciosgenerales.service.EspecialidadService;
import edu.integrador2.serviciosgenerales.service.EspecialistaService;
import edu.integrador2.serviciosgenerales.service.ServicioService;

@Controller
public class ServicioController {
  @Autowired
  ClienteService entityService;

  @Autowired
  EspecialidadService especialidadService;
  @Autowired
  ServicioService servicioService;
  @Autowired
  EspecialistaService especialistaService;

  /**
   * Soliicitar servicio
   */
  // Vista
  @GetMapping(path = "/servicio/cancelar-solicitud/{id}")
  public String cancelarSolicitud(@PathVariable Long id, Servicio model, Model uiModel) {
    servicioService.eliminar(id);
    return "redirect:/cliente/servicios-solicitados";
  }

}
