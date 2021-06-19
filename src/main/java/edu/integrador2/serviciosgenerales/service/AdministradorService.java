package edu.integrador2.serviciosgenerales.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.entity.Administrador;
import edu.integrador2.serviciosgenerales.repository.AdministradorRepository;

@Service
public class AdministradorService {
    @Autowired
    AdministradorRepository entityRepository; 
    
    /**
     * @deprecated Usar list
     */
    public ArrayList<Administrador> listar() {
        return (ArrayList<Administrador>) entityRepository.findAll();
    }

    public List<Administrador> list() {
        return (List<Administrador>) entityRepository.findAll();
    }

    public Optional<Administrador> get(Long id) {
        return (Optional<Administrador>) entityRepository.findById(id);
    }

    public Administrador create(Administrador obj) {
        return entityRepository.save(obj);
    }

    public Administrador update(Long id, Administrador obj) {
        return entityRepository.save(obj);
    }

    public void delete(Long id) {
        entityRepository.deleteById(id);
    }

}
