package com.example.odontologos_clinica.service;

import com.example.odontologos_clinica.exceptions.ResourceNotFoundExcepcion;
import com.example.odontologos_clinica.model.Odontologo;
import com.example.odontologos_clinica.model.OdontologoDTO;

import java.util.Collection;
import java.util.Set;

public interface IOdontologoService {
    public Odontologo crearOdontologo(OdontologoDTO odontologoDTO);
    public OdontologoDTO leerOdontologo(Long id);
    public Odontologo modificarOdontologo(OdontologoDTO odontologoDTO)throws ResourceNotFoundExcepcion;
    public void eliminarOdontologo(Long id)throws ResourceNotFoundExcepcion;
    Set<OdontologoDTO> leerTodos();

}
