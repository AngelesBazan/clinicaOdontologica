package com.example.odontologos_clinica.service;

import com.example.odontologos_clinica.exceptions.BadRequestException;
import com.example.odontologos_clinica.exceptions.ResourceNotFoundExcepcion;
import com.example.odontologos_clinica.model.OdontologoDTO;
import com.example.odontologos_clinica.model.Turno;
import com.example.odontologos_clinica.model.TurnoDTO;

import java.util.Collection;
import java.util.Set;

public interface ITurnoService {
    public Turno crearTurno(TurnoDTO turnoDTO)throws BadRequestException;
    public TurnoDTO leerTurno(Long id);
    public Turno modificarTurno(TurnoDTO turnoDTO)throws ResourceNotFoundExcepcion;
    public void eliminarTurno(Long id)throws ResourceNotFoundExcepcion;
    Set<TurnoDTO> leerTodos();
}

