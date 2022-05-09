package com.example.odontologos_clinica.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private int dni;
    private Date fechaIngreso;
    private Domicilio domicilio;
}
