package edu.integrador2.serviciosgenerales.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ActividadDto {
  private Long id;
  private Long idespecialista;
  private Long idEspecialidad;
  private String descripcionActividad;
  private String precio;
}
