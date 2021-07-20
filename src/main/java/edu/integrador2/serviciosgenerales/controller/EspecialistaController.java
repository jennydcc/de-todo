package edu.integrador2.serviciosgenerales.controller;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.integrador2.serviciosgenerales.dto.ActividadDto;
import edu.integrador2.serviciosgenerales.dto.EnvioCorreoDto;
import edu.integrador2.serviciosgenerales.dto.EspecialistaDto;
import edu.integrador2.serviciosgenerales.entity.Actividad;
import edu.integrador2.serviciosgenerales.entity.Especialista;
import edu.integrador2.serviciosgenerales.entity.Usuario;
import edu.integrador2.serviciosgenerales.security.SessionManager;
import edu.integrador2.serviciosgenerales.service.ActividadService;
import edu.integrador2.serviciosgenerales.service.ClienteService;
import edu.integrador2.serviciosgenerales.service.DistritoService;
import edu.integrador2.serviciosgenerales.service.EspecialistaService;
import edu.integrador2.serviciosgenerales.service.NotificationService;
import edu.integrador2.serviciosgenerales.service.ServicioService;
import edu.integrador2.serviciosgenerales.service.EspecialidadService;

@Controller
public class EspecialistaController {

  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  ClienteService clienteService;
  @Autowired
  EspecialistaService defaultService;
  @Autowired
  EspecialidadService especialidadService;
  @Autowired
  EspecialistaService especialistaService;
  @Autowired
  DistritoService distritoService;
  @Autowired
  ActividadService actividadService;
  @Autowired
  ServicioService servicioService;
  @Autowired
  NotificationService notificationService;

  @GetMapping("/especialista/")
  public String serviciosrequeridos(Model uiModel) throws Exception {
    // Template.addGlobalAttributes(uiModel);
    return solicitarServicio(uiModel);
  }

  @GetMapping("/especialista/login")
  public String loginEspecialista(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    return "especialista/login";
  }

  @GetMapping("/especialista/registrar")
  public String registrarEspecialista(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    uiModel.addAttribute("distrito", distritoService.listar());
    return "especialista/registrar";
  }

  @PostMapping(path = "/especialista/registrar", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public String registrarEspecialista(EspecialistaDto dto, Model uiModel) {
    Especialista entity = modelMapper.map(dto, Especialista.class);
    EspecialistaDto result = defaultService.create(entity);
    Template.addGlobalAttributes(uiModel);
    return "redirect:/especialista/registrarservicio?id=" + result.getId();
  }

  @PostMapping(path = "/especialista/registrarservicio")
  public String registrarServicio(ActividadDto dto, Model uiModel) throws IOException {
    Actividad entity = modelMapper.map(dto, Actividad.class);
    actividadService.registrar(entity);
    Template.addGlobalAttributes(uiModel);

    /*
     * System.out.println(model); System.out.println(model.getIdespecialista());
     * System.out.println(model.getIdEspecialidad());
     * System.out.println(model.getVideoActividad());
     */
    // System.out.println(model.getVideoActividad().getBytes());
    // System.out.println(model.getPrecio());
    return "redirect:/especialista/login";
  }

  @PostMapping(path = "/especialista/prueba")
  public String prueba(@RequestParam("file") MultipartFile file, Model uiModel) throws IOException {

    System.out.println("Entro");
    System.out.println(file.getBytes());
    Template.addGlobalAttributes(uiModel);
    return "/especialista/registrarservicio?id=3";
  }

  @GetMapping("/especialista/servicios-requeridos")
  public String solicitarServicio(Model uiModel) throws Exception {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 0);
    //System.out.println(servicioService.listar());
    Usuario usuario = SessionManager.getUsuario();
    System.out.println(usuario.getId());
    uiModel.addAttribute("serviciosSolicitados", servicioService.listarEspcialista(usuario.getId()));
    return "especialista/servicios-requeridos";
  }


  @PostMapping("/especialista/servicios-requeridos")
  public String atenderServicio(EnvioCorreoDto dto, Model uiModel) throws Exception{
    Template.addGlobalAttributes(uiModel);
    System.out.println("Envio correo segun valor");
    System.out.println(dto);
    if (dto.getBtnEnvio().equalsIgnoreCase("0")) {
      notificationService.sendNotificationA(dto);
      if(dto.getEstado().equalsIgnoreCase("SOLICITADO")){
        dto.setEstado("EN_PROCESO");
        servicioService.update(dto);
      }
      
    } else if(dto.getBtnEnvio().equalsIgnoreCase("1")) {
      notificationService.sendNotificationR(dto);
      if(dto.getEstado().equalsIgnoreCase("SOLICITADO")){
        dto.setEstado("RECHAZADO");
        servicioService.update(dto);
      }
    }
     else {
    if(dto.getEstado().equalsIgnoreCase("EN_PROCESO")){
      dto.setEstado("TERMINADO");
      servicioService.update(dto);
    }
  }
    uiModel.addAttribute("serviciosSolicitados", servicioService.listar());
    return solicitarServicio(uiModel);
  
  }


  @GetMapping("/especialista/registrarservicio")
  public String registrarServicio(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    uiModel.addAttribute("especialidades", especialidadService.list());
    uiModel.addAttribute("especialistas", especialistaService.listar());
    return "especialista/registrarservicio";
  }



    @GetMapping("/especialista/reportes")
  public String reportesespecialista(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 1);
    uiModel.addAttribute("distrito", distritoService.listar());
    ///uiModel.addAttribute("serviciosSolicitados", servicioService.listar());
    Usuario usuario = SessionManager.getUsuario();
    System.out.println(usuario.getId());
    uiModel.addAttribute("serviciosSolicitados", servicioService.listarEspcialista(usuario.getId()));
    return "especialista/reportes";
  }

  @GetMapping("/especialista/comentarios")
  public String especialistacomentarios(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 2);
    return "especialista/comentarios";
  }
  

  @GetMapping("/especialista/modificar")
  public String modificarespecialista(Model uiModel) {
    Template.addGlobalAttributes(uiModel);
    Template.addPageIndex(uiModel, 3);
    return "especialista/modificar";
  }




  

}
