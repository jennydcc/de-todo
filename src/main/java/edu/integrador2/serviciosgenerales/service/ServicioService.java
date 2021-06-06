package edu.integrador2.serviciosgenerales.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.entity.Servicio;
import edu.integrador2.serviciosgenerales.repository.ServicioRepository;

@Service
public class ServicioService {
  @Autowired
  ServicioRepository entityRepositoy;

  public ArrayList<Servicio> listar() {
    return (ArrayList<Servicio>) entityRepositoy.findAll();
  }

  public void eliminar(Long id) {
    entityRepositoy.deleteById(id);
  }

  public Servicio registrarSolicitud(Servicio model) {
    return entityRepositoy.save(model);
  }
}
