package com.example.odontologos_clinica.service;

import com.example.odontologos_clinica.exceptions.ResourceNotFoundExcepcion;
import com.example.odontologos_clinica.model.*;
import com.example.odontologos_clinica.repository.DomicilioRepository;
import com.example.odontologos_clinica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    private Paciente guardarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente crearPaciente(PacienteDTO pacienteDTO) {
        return guardarPaciente(pacienteDTO);
    }

    @Override
    public PacienteDTO leerPaciente(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()) {
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    @Override
    public Paciente modificarPaciente(PacienteDTO pacienteDTO)throws ResourceNotFoundExcepcion {
        if (leerPaciente(pacienteDTO.getId()) == null)
            throw new ResourceNotFoundExcepcion("No existe el paciente con el id: "+ pacienteDTO.getId());
        return guardarPaciente(pacienteDTO);
    }

    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundExcepcion{
        if(leerPaciente(id) == null)
            throw new ResourceNotFoundExcepcion("No existe el paciente con el id: "+id);
        pacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDTO> leerTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();

        for(Paciente paciente : pacientes) {
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;
    }

}

