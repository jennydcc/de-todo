package edu.integrador2.serviciosgenerales.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.dto.EnvioCorreoDto;
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
    //System.out.println(list);
    List<ServicioDto> result = new ArrayList<>();
    if (!list.isEmpty()) {
      for (Servicio rec : list) {
        ServicioDto dto = modelMapper.map(rec, ServicioDto.class);
        dto.setCorreo(rec.getCliente().getCorreo());
        result.add(dto);
      }
    }
    System.out.println("prueba");
    System.out.println(list.get(0).getCliente().getCorreo());

    return result;
  }

  public List<ServicioDto> listarEspcialista(Long id) {
    List<Servicio> list = (List<Servicio>) entityRepositoy.getListServicios(id);
    //System.out.println(list);
    List<ServicioDto> result = new ArrayList<>();
    if (!list.isEmpty()) {
      for (Servicio rec : list) {
        ServicioDto dto = modelMapper.map(rec, ServicioDto.class);
        dto.setCorreo(rec.getCliente().getCorreo());
        result.add(dto);
      }
    }

    return result;
  }

  public List<ServicioDto> listarCliente(Long id) {
    List<Servicio> list = (List<Servicio>) entityRepositoy.getListServiciosC(id);
    //System.out.println(list);
    List<ServicioDto> result = new ArrayList<>();
    if (!list.isEmpty()) {
      for (Servicio rec : list) {
        ServicioDto dto = modelMapper.map(rec, ServicioDto.class);
        dto.setCorreo(rec.getCliente().getCorreo());
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


  public void  update(EnvioCorreoDto obj) {
    // Obtener objeto actual
    Optional<Servicio> optional = entityRepositoy.findById(Long.parseLong(obj.getIdservicio()));
    if (optional.isPresent()) {
        Servicio currentRecord = optional.get();
        currentRecord.setEstado(obj.getEstado());
        entityRepositoy.save(currentRecord);
    }
    // Entidad -> Dto
   // return modelMapper.map(obj, ServicioDto.class);
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
