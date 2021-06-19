package edu.integrador2.serviciosgenerales.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.dto.AdministradorDto;
import edu.integrador2.serviciosgenerales.entity.Administrador;
import edu.integrador2.serviciosgenerales.repository.AdministradorRepository;

@Service
public class AdministradorService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    AdministradorRepository defaultRepository;

    public List<AdministradorDto> list() {
        List<Administrador> list = (List<Administrador>) defaultRepository.findAll();
        List<AdministradorDto> result = new ArrayList<>();
        if (!list.isEmpty()) {
            for (Administrador rec : list) {
                rec.setContrasena("");
                AdministradorDto dto = modelMapper.map(rec, AdministradorDto.class);
                result.add(dto);
            }
        }
        return result;
    }

    public Optional<AdministradorDto> get(Long id) {
        Optional<Administrador> OptionalObj = defaultRepository.findById(id);
        Optional<AdministradorDto> optionalDto = Optional.of(null);
        // Entidad -> Dto
        if (OptionalObj.isPresent()) {
            AdministradorDto dto = modelMapper.map(OptionalObj.get(), AdministradorDto.class);
            optionalDto = Optional.of(dto);
        }
        return optionalDto;
    }

    public AdministradorDto create(Administrador obj) {
        // Encriptar contraseña
        final String encryptedPassword = bCryptPasswordEncoder.encode(obj.getContrasena());
        obj.setContrasena(encryptedPassword);
        defaultRepository.save(obj);
        // Nunca retornamos la contaseña al cliente
        obj.setContrasena("");
        // Entidad -> Dto
        return modelMapper.map(obj, AdministradorDto.class);
    }

    public AdministradorDto update(Long id, Administrador obj) {
        // Obtener objeto actual
        Optional<Administrador> optional = defaultRepository.findById(id);
        if (optional.isPresent()) {
            Administrador currentRecord = optional.get();
            // Si se recibe una contraseña se encripta y se guarda / Sino se asigna su
            // propia contraseña
            if (obj.getContrasena() != "") {
                // Encriptar contraseña
                final String encryptedPassword = bCryptPasswordEncoder.encode(obj.getContrasena());
                obj.setContrasena(encryptedPassword);
            } else {
                obj.setContrasena(currentRecord.getContrasena());
            }
        }
        defaultRepository.save(obj);
        // Nunca retornamos la contaseña al cliente
        obj.setContrasena("");
        // Entidad -> Dto
        return modelMapper.map(obj, AdministradorDto.class);
    }

    public void delete(Long id) {
        defaultRepository.deleteById(id);
    }

}
