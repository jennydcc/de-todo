package edu.integrador2.serviciosgenerales.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServicioDto {
  private Long id;
  private Long idEspecialidad;
  private Long idCliente;
  private Long idEspecialista;
  private String especialidadNombre;
  private String clienteNombre;
  private String especialistaNombre;
  private String detalle;
  private String fecha;
  private String telefono;
  private String direccion;
}
