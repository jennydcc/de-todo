package edu.integrador2.serviciosgenerales.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.integrador2.serviciosgenerales.entity.Administrador;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, Long> {
  Optional<Administrador> findByCorreo(String correo);
}
