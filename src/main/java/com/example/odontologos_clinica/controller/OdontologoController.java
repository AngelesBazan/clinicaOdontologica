package com.example.odontologos_clinica.controller;

import com.example.odontologos_clinica.exceptions.ResourceNotFoundExcepcion;
import com.example.odontologos_clinica.model.Odontologo;
import com.example.odontologos_clinica.model.OdontologoDTO;
import com.example.odontologos_clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/odontologos")

public class OdontologoController {

    @Autowired
    OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Odontologo> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) {

        return ResponseEntity.ok(odontologoService.crearOdontologo(odontologoDTO));

    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarPorId(@PathVariable Long id){
        return odontologoService.leerOdontologo(id);
    }


    @PutMapping()
    public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws ResourceNotFoundExcepcion {
        return ResponseEntity.ok(odontologoService.modificarOdontologo(odontologoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable Long id)throws ResourceNotFoundExcepcion{
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok("Eliminado");
    }


    @GetMapping
    public ResponseEntity<Set<OdontologoDTO>> listarTodos() {
        return ResponseEntity.ok(odontologoService.leerTodos());
    }


}

