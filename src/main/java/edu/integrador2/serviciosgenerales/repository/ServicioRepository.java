package edu.integrador2.serviciosgenerales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.integrador2.serviciosgenerales.entity.Servicio;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Long> {


    @Query(value = " SELECT S.DETALLE, S.DIRECCION, 'SAN MIGUEL' AS DISTRITO, S.TELEFONO, 'PENDIENTE' AS ESTADO , C.NOMBRE , S.ID_SERVICIO, S.ID_CLIENTE, S.ID_ESPECIALISTA \n"
    + " FROM SERVICIO S \n" 
    + " JOIN CLIENTE C  \n"
    + " ON S.ID_CLIENTE = C.ID_CLIENTE \n"
    + " WHERE S.ID_ESPECIALISTA = :ID ", nativeQuery = true)
    List<Object[]> getListServicios(@Param("ID") String id_especialista);
}
