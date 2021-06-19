package edu.integrador2.serviciosgenerales.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EspecialistaDto {
  private Long id;
  private Long idDistrito;
  private String nombre;
  private String correo;
  private String contrasena;
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
