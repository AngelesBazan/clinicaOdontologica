package com.example.odontologos_clinica.service;



import com.example.odontologos_clinica.exceptions.ResourceNotFoundExcepcion;
import com.example.odontologos_clinica.model.Paciente;
import com.example.odontologos_clinica.model.PacienteDTO;

import java.util.Collection;
import java.util.Set;

public interface IPacienteService {
    public Paciente crearPaciente(PacienteDTO pacienteDTO);
    public PacienteDTO leerPaciente(Long id);
    public Paciente modificarPaciente(PacienteDTO pacienteDTO)throws ResourceNotFoundExcepcion;
    public void eliminarPaciente(Long id)throws ResourceNotFoundExcepcion;
    Set<PacienteDTO> leerTodos();
}
