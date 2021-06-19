package edu.integrador2.serviciosgenerales.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.dto.ObtenerServicioDto;
import edu.integrador2.serviciosgenerales.dto.ServicioDto;
import edu.integrador2.serviciosgenerales.entity.Servicio;
import edu.integrador2.serviciosgenerales.repository.ServicioRepository;

@Service
public class ServicioService {
  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  ServicioRepository entityRepositoy;

  public List<ServicioDto> listar() {
    List<Servicio> list = (List<Servicio>) entityRepositoy.findAll();
    List<ServicioDto> result = new ArrayList<>();
    if (!list.isEmpty()) {
      for (Servicio rec : list) {
        ServicioDto dto = modelMapper.map(rec, ServicioDto.class);
        result.add(dto);
      }
    }
    return result;
  }

  public void eliminar(Long id) {
    entityRepositoy.deleteById(id);
  }

  public Servicio registrarSolicitud(Servicio model) {
    return entityRepositoy.save(model);
  }


  public List<ObtenerServicioDto> obtenerListaServicio(String id_especialista){
    List<ObtenerServicioDto> result = new ArrayList<>();
    result = entityRepositoy.getListServicios(id_especialista).stream()
    .map(x -> { 
      ObtenerServicioDto obj =new ObtenerServicioDto();
      obj.setDetalle(String.valueOf(x[0]));
      obj.setDireccion(String.valueOf(x[1]));
      obj.setDistrito(String.valueOf(x[2]));
      obj.setTelefono(String.valueOf(x[3]));
      obj.setEstado(String.valueOf(x[4]));
      obj.setClienteNombre(String.valueOf(x[5]));
      obj.setIdServicio(Long.parseLong(String.valueOf(x[6])));
      obj.setIdCliente(Long.parseLong(String.valueOf(x[7])));
      obj.setIdEspecialista(Long.parseLong(String.valueOf(x[8])));


      return obj;

    }).collect(Collectors.toList());

    return result;
    

    
  }
}
