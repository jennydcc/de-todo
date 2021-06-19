package edu.integrador2.serviciosgenerales.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdministradorDto {
  private Long id;
  private String nombre;
  private String correo;
  private String contrasena;
  private boolean habilitado;
}
