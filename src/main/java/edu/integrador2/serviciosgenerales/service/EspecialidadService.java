package edu.integrador2.serviciosgenerales.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.entity.Especialidad;
import edu.integrador2.serviciosgenerales.repository.EspecialidadRepository;

@Service
public class EspecialidadService {
  @Autowired
  EspecialidadRepository repository;

  public ArrayList<Especialidad> listar() {
    return (ArrayList<Especialidad>) repository.findAll();
  }

}
