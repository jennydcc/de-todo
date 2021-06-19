package edu.integrador2.serviciosgenerales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cliente")
public class Cliente extends Usuario {
  private String tipoUsuario = "CLIENTE";
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_cliente", unique = true, nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_distrito")
  Distrito distrito;

  private String apellidoPaterno;
  private String apellidoMaterno;
  private String telefono;
  private String direccion;
  private String departamento;
  private String provincia;
  private String sexo;
  private String tipoDocumento;
  private String numeroDocumento;
  private Boolean aceptaAcuerdo;

}
