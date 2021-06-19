package edu.integrador2.serviciosgenerales.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.integrador2.serviciosgenerales.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
 Optional<Cliente> findByCorreo(String correo);
}
