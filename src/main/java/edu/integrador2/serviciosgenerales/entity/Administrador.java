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
@Table(name = "administrador")
public class Administrador extends Usuario {
  private String tipoUsuario = "ADMINISTRADOR";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_administrador", unique = true, nullable = false)
  private Long id;
  private String nombre;
  private String correo;
  private Boolean habilitado = true;
  private String contrasena;


}
