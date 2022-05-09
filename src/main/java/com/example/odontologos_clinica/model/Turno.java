package com.example.odontologos_clinica.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table (name = "turnos")
@Getter
@Setter
public class Turno {
    @Id
    @SequenceGenerator(name = "turno_sequence",sequenceName = "turno_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "paciente_id",referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Paciente paciente;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "odontologo_id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Odontologo odontologo;
    private Date fecha;
    private Time hora;


    public Turno() {
    }

    public Turno(Long id, Paciente paciente, Odontologo odontologo, Date fecha, Time hora) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Turno(Paciente paciente, Odontologo odontologo, Date fecha, Time hora) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                ", date=" + fecha +
                ", hora=" + hora +
                '}';
    }
}

