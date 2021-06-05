package edu.integrador2.serviciosgenerales.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.integrador2.serviciosgenerales.entity.Especialidad;

@Repository
public interface EspecialidadRepository extends CrudRepository<Especialidad, Long> {

}
