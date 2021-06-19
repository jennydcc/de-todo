package edu.integrador2.serviciosgenerales.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.integrador2.serviciosgenerales.dto.ClienteDto;
import edu.integrador2.serviciosgenerales.dto.ServicioDto;
import edu.integrador2.serviciosgenerales.entity.Cliente;
import edu.integrador2.serviciosgenerales.entity.Servicio;
import edu.integrador2.serviciosgenerales.service.ClienteService;
import edu.integrador2.serviciosgenerales.service.DistritoService;
import edu.integrador2.serviciosgenerales.service.EspecialidadService;
import edu.integrador2.serviciosgenerales.service.EspecialistaService;
import edu.integrador2.serviciosgenerales.service.ServicioService;

@Controller
public class ClienteController {
  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  ClienteService defaultService;
  @Autowired
  EspecialidadService especialidadService;
  @Autowired
  ServicioService servicioService;
  @Autowired
  EspecialistaService especialistaService;
  @Autowired
  DistritoService distritoService;

  @GetMapping("/cliente/")
  public String homePage(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    return "cliente/servicios-solicitados";
  }

  @GetMapping("/cliente/login")
  public String loginCliente(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    return "cliente/login";
  }

  @GetMapping("/cliente/registrar")
  public String registrarCliente(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    uiModel.addAttribute("distrito", distritoService.listar());
    return "cliente/registrar";
  }

  @PostMapping(path = "/cliente/registrar", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public String postRegistrarCliente(ClienteDto dto, Model uiModel) {
    Cliente entity = modelMapper.map(dto, Cliente.class);
    defaultService.create(entity);
    Template.addGlobalAttributes(uiModel);
    return "redirect:/cliente/login";
  }

  @GetMapping("/cliente/servicios-solicitados")
  public String serviciosSolicitados(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 0);
    uiModel.addAttribute("serviciosSolicitados", servicioService.listar());
    return "cliente/servicios-solicitados";
  }

  /**
   * Modificar datos del cliente
   */

  /**
   * Soliicitar servicio
   */
  // Vista
  @GetMapping("/cliente/solicitar-servicio")
  public String solicitarServicio(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 1);
    uiModel.addAttribute("especialidad", especialidadService.list());
    uiModel.addAttribute("especialistas", especialistaService.listar());
    return "cliente/solicitar-servicio";
  }

  @PostMapping(path = "/cliente/solicitar-servicio", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public String registrarEspecialista(ServicioDto dto, Model uiModel) {
    Servicio entity = modelMapper.map(dto, Servicio.class);
    servicioService.registrarSolicitud(entity);
    Template.addGlobalAttributes(uiModel);
    return "redirect:/cliente/servicios-solicitados";
  }

  @GetMapping("/cliente/reportes")
  public String reportesclientes(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 2);
    return "cliente/reportes";
  }

  @GetMapping("/cliente/modificar")
  public String modificarclientes(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 3);
    return "cliente/modificar";
  }

}
