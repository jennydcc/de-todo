package edu.integrador2.serviciosgenerales.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.entity.Especialista;
import edu.integrador2.serviciosgenerales.repository.EspecialistaRepository;
import java.util.Optional;

@Service
public class EspecialistaService {

  @Autowired
  EspecialistaRepository especialistaRepository;

  public ArrayList<Especialista> listar() {
    return (ArrayList<Especialista>) especialistaRepository.findAll();
  }

  public Optional<Especialista> obterner(Long id) {
    return (Optional<Especialista>) especialistaRepository.findById(id);
  }

  public Especialista crear(Especialista model) {
    return especialistaRepository.save(model);
  }

  public Especialista actualizar(Long id, Especialista model) {
    return especialistaRepository.save(model);
  }

  public void eliminar(Long id) {
    especialistaRepository.deleteById(id);
  }
}
