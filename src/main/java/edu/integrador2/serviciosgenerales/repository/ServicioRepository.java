package edu.integrador2.serviciosgenerales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.integrador2.serviciosgenerales.entity.Servicio;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Long> {


    @Query(value = " SELECT S.DETALLE, S.DIRECCION, S.ID_DISTRITO, S.TELEFONO, S.ESTADO , C.NOMBRE , S.ID_SERVICIO, S.ID_CLIENTE, S.ID_ESPECIALISTA, S.ID_ESPECIALIDAD,S.FECHA,S.TELEFONO \n"
    + " FROM SERVICIO S \n" 
    + " JOIN CLIENTE C  \n"
    + " ON S.ID_CLIENTE = C.ID_CLIENTE \n"
    + " WHERE S.ID_ESPECIALISTA = :ID ", nativeQuery = true)
    List<Servicio> getListServicios(@Param("ID") Long id_especialista);


    @Query(value = " SELECT S.DETALLE, S.DIRECCION, S.ID_DISTRITO, S.TELEFONO, S.ESTADO , C.NOMBRE , S.ID_SERVICIO, S.ID_CLIENTE, S.ID_ESPECIALISTA, S.ID_ESPECIALIDAD,S.FECHA,S.TELEFONO \n"
    + " FROM SERVICIO S \n" 
    + " JOIN CLIENTE C  \n"
    + " ON S.ID_CLIENTE = C.ID_CLIENTE \n"
    + " WHERE S.ID_CLIENTE = :ID ", nativeQuery = true)
    List<Servicio> getListServiciosC(@Param("ID") Long id_cliente);
}
