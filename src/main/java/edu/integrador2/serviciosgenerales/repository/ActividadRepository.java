package edu.integrador2.serviciosgenerales.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.integrador2.serviciosgenerales.entity.Actividad;

@Repository
public interface ActividadRepository extends CrudRepository<Actividad, Long> {

}
