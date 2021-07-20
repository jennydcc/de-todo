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
@Table(name = "servicio")
public class Servicio {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_servicio", unique = true, nullable = false)
  private Long id;
  
  @ManyToOne
  @JoinColumn(name = "id_especialidad")
  Especialidad especialidad;

  @ManyToOne
  @JoinColumn(name = "id_cliente")
  Cliente cliente;

  @ManyToOne
  @JoinColumn(name = "id_especialista")
  Especialista especialista;

  @ManyToOne
  @JoinColumn(name = "id_distrito")
  Distrito distrito;
  
  private String detalle;
  private String fecha;
  private String telefono;
  private String direccion;
  private String estado="SOLICITADO";
  
}
