package com.example.odontologos_clinica.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "domicilios")
@Getter
@Setter

public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;
    public Domicilio() {
    }

    public Domicilio(Long id, String calle, int numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
    public Domicilio( String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}

