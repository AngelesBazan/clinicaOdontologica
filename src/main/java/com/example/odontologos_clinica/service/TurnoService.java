package com.example.odontologos_clinica.service;

import com.example.odontologos_clinica.exceptions.BadRequestException;
import com.example.odontologos_clinica.exceptions.ResourceNotFoundExcepcion;
import com.example.odontologos_clinica.model.*;
import com.example.odontologos_clinica.repository.OdontologoRepository;
import com.example.odontologos_clinica.repository.PacienteRepository;
import com.example.odontologos_clinica.repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private Turno guardarTurno(TurnoDTO turnoDTO) {
        Paciente paciente = pacienteRepository.findById(turnoDTO.getPaciente().getId()).get();
        Odontologo odontologo = odontologoRepository.findById(turnoDTO.getOdontologo().getId()).get();
        turnoDTO.setPaciente(paciente);
        turnoDTO.setOdontologo(odontologo);
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        return turnoRepository.save(turno);
    }

    @Override
    public Turno crearTurno(TurnoDTO turnoDTO) throws BadRequestException{
        Paciente paciente = turnoDTO.getPaciente();
        Optional <Paciente> paciente1 = pacienteRepository.findById(paciente.getId());
        Odontologo odontologo = turnoDTO.getOdontologo();
        Optional<Odontologo> odontologo1 = odontologoRepository.findById(odontologo.getId());

        if(!paciente1.isPresent() || !odontologo1.isPresent()){
            throw new BadRequestException("El id del odontologo o del paciente es null");
        }
        return guardarTurno(turnoDTO);

    }


    @Override
    public TurnoDTO leerTurno(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()) {
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public Turno modificarTurno(TurnoDTO turnoDTO)throws ResourceNotFoundExcepcion {
        if (leerTurno(turnoDTO.getId()) == null)
            throw new ResourceNotFoundExcepcion("No existe el turno con el id: "+ turnoDTO.getId());
        return guardarTurno(turnoDTO);
    }

    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundExcepcion {
        if(leerTurno(id) == null)
            throw new ResourceNotFoundExcepcion("No existe el turno con el id: "+id);
        turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDTO> leerTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();

        for(Turno turno : turnos) {
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;
    }


}

