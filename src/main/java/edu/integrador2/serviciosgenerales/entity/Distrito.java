package edu.integrador2.serviciosgenerales.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
  @OneToMany(mappedBy = "distrito")
  private Set<Servicio> servicios = new HashSet<>();
}
