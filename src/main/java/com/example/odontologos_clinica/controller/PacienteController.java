package com.example.odontologos_clinica.controller;

import com.example.odontologos_clinica.exceptions.ResourceNotFoundExcepcion;
import com.example.odontologos_clinica.model.Paciente;
import com.example.odontologos_clinica.model.PacienteDTO;
import com.example.odontologos_clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(pacienteService.crearPaciente(pacienteDTO));
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPorId(@PathVariable Long id){
        return pacienteService.leerPaciente(id);
    }

    @PutMapping()
    public ResponseEntity<Paciente> modificarPaciente(@RequestBody PacienteDTO pacienteDTO)throws ResourceNotFoundExcepcion {
        return ResponseEntity.ok(pacienteService.modificarPaciente(pacienteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable Long id) throws ResourceNotFoundExcepcion{
       pacienteService.eliminarPaciente(id);
       return ResponseEntity.ok("Eliminado");
    }

    @GetMapping
    public ResponseEntity<Set<PacienteDTO>> listarTodos() {
        return ResponseEntity.ok(pacienteService.leerTodos());
    }

}


