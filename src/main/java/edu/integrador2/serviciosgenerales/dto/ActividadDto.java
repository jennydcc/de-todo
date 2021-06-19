package edu.integrador2.serviciosgenerales.dto;

import org.springframework.web.multipart.MultipartFile;

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
  private MultipartFile videoActividad;
  private String precio;
}
