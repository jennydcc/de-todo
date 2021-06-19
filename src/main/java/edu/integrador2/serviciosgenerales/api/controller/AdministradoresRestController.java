package edu.integrador2.serviciosgenerales.api.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.integrador2.serviciosgenerales.dto.AdministradorDto;
import edu.integrador2.serviciosgenerales.entity.Administrador;
import edu.integrador2.serviciosgenerales.service.AdministradorService;

@RestController
@RequestMapping("/api/v1/administradores")
public class AdministradoresRestController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    AdministradorService defaultService;

    @GetMapping()
    public List<AdministradorDto> list() {
        return defaultService.list();
    }

    @GetMapping(value = "/{id}")
    public Optional<AdministradorDto> get(@PathVariable Long id) {
        return defaultService.get(id);
    }

    @PostMapping()
    public AdministradorDto create(@RequestBody AdministradorDto dto) {
        Administrador entity = modelMapper.map(dto, Administrador.class);
        return defaultService.create(entity);
    }

    @PutMapping(value = "/{id}")
    public AdministradorDto update(@PathVariable Long id, @RequestBody AdministradorDto dto) {
        Administrador entity = modelMapper.map(dto, Administrador.class);
        return defaultService.update(id, entity);
    }

    @DeleteMapping(value = "/{id}")
    public boolean eliminar(@PathVariable Long id) {
        defaultService.delete(id);
        return true;
    }

}
