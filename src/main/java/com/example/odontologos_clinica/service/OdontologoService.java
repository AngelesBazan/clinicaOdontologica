package com.example.odontologos_clinica.service;

import com.example.odontologos_clinica.exceptions.ResourceNotFoundExcepcion;
import com.example.odontologos_clinica.model.Odontologo;
import com.example.odontologos_clinica.model.OdontologoDTO;
import com.example.odontologos_clinica.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    OdontologoRepository odontologoRepository;
    @Autowired
    ObjectMapper mapper;

    private Odontologo guardarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo crearOdontologo(OdontologoDTO odontologoDTO) {
        return guardarOdontologo(odontologoDTO);
    }

    @Override
    public OdontologoDTO leerOdontologo(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    public Odontologo modificarOdontologo(OdontologoDTO odontologoDTO) throws ResourceNotFoundExcepcion{
        if (leerOdontologo(odontologoDTO.getId()) == null)
            throw new ResourceNotFoundExcepcion("No existe el odontologo con el id: "+ odontologoDTO.getId());

        return guardarOdontologo(odontologoDTO);
    }

    @Override
    public void eliminarOdontologo(Long id)throws ResourceNotFoundExcepcion{
        if(leerOdontologo(id) == null)
            throw new ResourceNotFoundExcepcion("No existe el odontologo con el id: "+id);

        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> leerTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();

        for(Odontologo odontologo : odontologos) {
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }

}

