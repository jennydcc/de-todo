package edu.integrador2.serviciosgenerales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cliente2")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idCLIENTE", unique = true, nullable = false)
  private Long id;

  private String idUsuario;
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String tipoDocumento;
  private String numeroDocumento;
  private String correo;
  private String sexo;
  private String fechaNacimiento;
  private String direccion;
  private String departamento;
  private String provincia;
  private String distrito;
  private String celular;
  private String contrasena;
  private String estado;
  private Long idProvincia;

}
