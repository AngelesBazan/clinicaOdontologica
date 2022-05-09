package com.example.odontologos_clinica.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomicilioDTO {
    private Long id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

}
