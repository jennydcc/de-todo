package edu.integrador2.serviciosgenerales.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.entity.Distrito;
import edu.integrador2.serviciosgenerales.repository.DistritoRepository;

@Service
public class DistritoService {
  @Autowired
  DistritoRepository repository;

  public ArrayList<Distrito> listar() {
    return (ArrayList<Distrito>) repository.findAll();
  }

}
