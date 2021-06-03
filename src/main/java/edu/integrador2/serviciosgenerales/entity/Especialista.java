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
@Table(name = "especialista2")
public class Especialista extends Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_especialista", unique = true, nullable = false)
  private Long id;
  private String apellidoPaterno;
  private String apellidoMaterno;
}
