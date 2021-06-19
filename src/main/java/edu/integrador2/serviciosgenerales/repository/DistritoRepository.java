package edu.integrador2.serviciosgenerales.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.integrador2.serviciosgenerales.entity.Distrito;

@Repository
public interface DistritoRepository extends CrudRepository<Distrito, Long> {

}
