package edu.integrador2.serviciosgenerales.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.entity.Especialidad;
import edu.integrador2.serviciosgenerales.repository.EspecialidadRepository;

@Service
public class EspecialidadService {
  @Autowired
  EspecialidadRepository entityRepository;

  /**
   * @deprecated Usar list
   */
  public ArrayList<Especialidad> listar() {
    return (ArrayList<Especialidad>) entityRepository.findAll();
  }

  public List<Especialidad> list() {
    return (List<Especialidad>) entityRepository.findAll();
  }

  public Optional<Especialidad> get(Long id) {
    return (Optional<Especialidad>) entityRepository.findById(id);
  }

  public Especialidad create(Especialidad obj) {
    return entityRepository.save(obj);
  }

  public Especialidad update(Long id, Especialidad obj) {
    return entityRepository.save(obj);
  }

  public void delete(Long id) {
    entityRepository.deleteById(id);
  }
}
