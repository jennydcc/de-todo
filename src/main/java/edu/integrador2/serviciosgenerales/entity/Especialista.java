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
@Table(name = "especialista2")
public class Especialista {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idESPECIALISTA", unique = true, nullable = false)
  private Long id;
  private String nombre;
  private String edad;
  private String sexo;

}
