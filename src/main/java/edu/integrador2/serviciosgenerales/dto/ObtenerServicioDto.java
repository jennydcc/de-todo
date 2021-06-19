package edu.integrador2.serviciosgenerales.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ObtenerServicioDto {
  private Long id;
  private Long idCliente;
  private Long idEspecialista;
  private Long idServicio;
  private String clienteNombre;
  private String detalle;
  private String telefono;
  private String direccion;
  private String distrito;
  private String estado;
}
