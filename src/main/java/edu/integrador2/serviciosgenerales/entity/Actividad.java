package edu.integrador2.serviciosgenerales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

/**
 * Especialista implementa UserDetails para el proceso de autenticación
 */
@Entity
@Getter
@Setter
@Table(name = "esp_act")
public class Actividad  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_actividad", unique = true, nullable = false)
  private Long id;
  private String idespecialista;
  private String idEspecialidad;
  private String descripcionActividad;
  private String videoActividad;
  private String precio;
}
