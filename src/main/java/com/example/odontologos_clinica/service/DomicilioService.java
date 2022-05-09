package com.example.odontologos_clinica.service;

import com.example.odontologos_clinica.model.Domicilio;
import com.example.odontologos_clinica.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DomicilioService {
    private final DomicilioRepository domicilioRepository;

    @Autowired
    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public Domicilio guardar(Domicilio d){
        domicilioRepository.save(d);
        return d;
    }
    public Optional<Domicilio> buscar(Long id){
        return Optional.of(domicilioRepository.getOne(Long.valueOf(id)));
    }
    public List<Domicilio> buscarTodos(){
        return domicilioRepository.findAll();
    }
    public void eliminar(Long id){
        domicilioRepository.deleteById(Long.valueOf(id));
    }
}
