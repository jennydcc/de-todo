package edu.integrador2.serviciosgenerales.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.integrador2.serviciosgenerales.dto.EspecialistaDto;
import edu.integrador2.serviciosgenerales.entity.Especialista;
import edu.integrador2.serviciosgenerales.service.EspecialistaService;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/especialistas")
public class EspecialistasRestController {
  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  EspecialistaService defaultService;

  @GetMapping()
  public List<Especialista> list() {
    return defaultService.list();
  }

  @GetMapping(value = "/logged-in")
  public Optional<EspecialistaDto> getLoggedIn() {
    return defaultService.getLoggedIn();
  }

  @GetMapping(value = "/espe_act/{id}"  )
  public List<Especialista> getEspecialistaByActividad(@PathVariable Long id) {
    Especialista e = new Especialista();
    e.setId(1L);
    e.setNombre("prueba"); 
    Especialista e1 = new Especialista();
    e1.setId(2L);
    e1.setNombre("prueba2");
    List<Especialista> es= new ArrayList<>(); 
    es.add(e);
    es.add(e1);
   // return defaultService.getLoggedIn();
   System.out.println(id);
   return es;
  }


  @GetMapping(value = "/{id}")
  public Optional<Especialista> get(@PathVariable Long id) {
    return defaultService.get(id);
  }

  @PostMapping()
  public EspecialistaDto create(@RequestBody Especialista dto) {
    Especialista entity = modelMapper.map(dto, Especialista.class);
    return defaultService.create(entity);
  }

  @PutMapping(value = "/{id}")
  public EspecialistaDto update(@PathVariable Long id, @RequestBody EspecialistaDto dto) {
    Especialista entity = modelMapper.map(dto, Especialista.class);
    return defaultService.update(id, entity);
  }

  @DeleteMapping(value = "/{id}")
  public boolean eliminar(@PathVariable Long id) {
    defaultService.delete(id);
    return true;
  }

}
