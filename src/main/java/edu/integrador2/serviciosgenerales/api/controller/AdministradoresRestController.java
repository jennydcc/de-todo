package edu.integrador2.serviciosgenerales.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.integrador2.serviciosgenerales.entity.Administrador;
import edu.integrador2.serviciosgenerales.service.AdministradorService;

@RestController
@RequestMapping("/api/v1/administradores")
public class AdministradoresRestController {
    @Autowired
    AdministradorService defaultService;    

    @GetMapping()
    public List<Administrador> list() {
        return defaultService.list();
    }

    @GetMapping(value = "/{id}")
    public Optional<Administrador> get(@PathVariable Long id) {
        return defaultService.get(id);
    }

    @PostMapping()
    public Administrador create(@RequestBody Administrador model) {
        return defaultService.create(model);
    }

    @PutMapping(value = "/{id}")
    public Administrador update(@PathVariable Long id, @RequestBody Administrador model) {
        return defaultService.update(id, model);
    }

    @DeleteMapping(value = "/{id}")
    public boolean eliminar(@PathVariable Long id) {
        defaultService.delete(id);
        return true;
    }


}
