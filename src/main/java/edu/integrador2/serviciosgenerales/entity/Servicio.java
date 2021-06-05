package edu.integrador2.serviciosgenerales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Servicio {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_servicio", unique = true, nullable = false)
  private Long id;
  private Long idEspecialidad;
  private Long idEspecialista;
  private Long idCliente;
  private String detalle;
  private String fecha;
  private String telefono;
  private String direccion;
}
