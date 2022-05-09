package com.example.odontologos_clinica.controller;


import com.example.odontologos_clinica.exceptions.BadRequestException;
import com.example.odontologos_clinica.exceptions.ResourceNotFoundExcepcion;
import com.example.odontologos_clinica.model.Turno;
import com.example.odontologos_clinica.model.TurnoDTO;
import com.example.odontologos_clinica.service.OdontologoService;
import com.example.odontologos_clinica.service.PacienteService;
import com.example.odontologos_clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {


    @Autowired
    private TurnoService turnoService;

    @PostMapping
    public ResponseEntity<Turno> crearTurno(@RequestBody TurnoDTO turnoDTO) throws BadRequestException {
        return ResponseEntity.ok(turnoService.crearTurno(turnoDTO));

    }

    @GetMapping("/{id}")
    public TurnoDTO buscarPorId(@PathVariable Long id){
        return turnoService.leerTurno(id);
    }

    @PutMapping()
    public ResponseEntity<Turno> modificarTurno(@RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundExcepcion{
       return ResponseEntity.ok(turnoService.modificarTurno(turnoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable Long id)throws ResourceNotFoundExcepcion {
        turnoService.eliminarTurno(id);

        return ResponseEntity.ok("Eliminado");
    }

    @GetMapping
    public ResponseEntity<Set<TurnoDTO>> listarTodos() {
        return ResponseEntity.ok(turnoService.leerTodos());
    }


}


