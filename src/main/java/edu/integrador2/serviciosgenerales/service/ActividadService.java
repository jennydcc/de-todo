package edu.integrador2.serviciosgenerales.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.entity.Actividad;
import edu.integrador2.serviciosgenerales.repository.ActividadRepository;

@Service
public class ActividadService {
  @Autowired
  ActividadRepository repository;

  public ArrayList<Actividad> listar() {
    return (ArrayList<Actividad>) repository.findAll();
  }

  public Actividad registrar(Actividad actividad) {
    return repository.save(actividad);
  }

}
