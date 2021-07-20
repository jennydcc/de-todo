package edu.integrador2.serviciosgenerales.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EnvioCorreoDto {
  private String btnEnvio;
  private String idservicio;
  private String estado;
  private String correo;
 
}
