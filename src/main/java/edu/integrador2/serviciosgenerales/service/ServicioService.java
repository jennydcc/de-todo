package edu.integrador2.serviciosgenerales.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
