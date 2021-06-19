package edu.integrador2.serviciosgenerales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonSerialize
public class Distrito {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_distrito", unique = true, nullable = false)
  private Long id;
  private String nombre;
}
