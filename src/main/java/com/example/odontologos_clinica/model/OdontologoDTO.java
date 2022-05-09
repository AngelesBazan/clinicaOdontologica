package com.example.odontologos_clinica.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class OdontologoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;

}
