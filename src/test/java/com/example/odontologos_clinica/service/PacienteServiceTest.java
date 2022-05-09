package com.example.odontologos_clinica.service;

import com.example.odontologos_clinica.exceptions.ResourceNotFoundExcepcion;
import com.example.odontologos_clinica.model.Domicilio;
import com.example.odontologos_clinica.model.PacienteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PacienteServiceTest {
    @Autowired
    private IPacienteService pacienteService;
    private Domicilio domicilio;
    private PacienteDTO pacienteDTO;

    @BeforeEach
    public void prepararPaciente() {
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Calle Falsa");
        domicilio.setNumero(1234);
        domicilio.setLocalidad("Springfield");
        domicilio.setProvincia("Arizona");

        pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("José");
        pacienteDTO.setApellido("González");
        pacienteDTO.setDni(23612312);
        pacienteDTO.setFechaIngreso(new Date(122, 2, 1));
        pacienteDTO.setDomicilio(domicilio);
    }


    @Test
    public void testCrearPaciente(){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Patricia");
        pacienteDTO.setApellido("Flores");
        pacienteDTO.setDni(36523241);
        pacienteDTO.setFechaIngreso(new Date(122,2,1));
        pacienteDTO.setDomicilio(new Domicilio("callefalsa",12343,"caba","caba"));

        pacienteService.crearPaciente(pacienteDTO);

        PacienteDTO pacienteJuan = pacienteService.leerPaciente(1L);

        assertTrue(pacienteJuan != null);

    }
    @Test
    public void testLeerUnPaciente(){
        pacienteService.crearPaciente(pacienteDTO);
        PacienteDTO paciente = pacienteService.leerPaciente(1L);
        assertNotNull(paciente != null);
    }

    @Test
    public void testLeerTodos() {
        pacienteService.crearPaciente(pacienteDTO);
        assertTrue(pacienteService.leerTodos().size() != 0);
    }

    @Test
    public void testEliminarPaciente() throws ResourceNotFoundExcepcion {
        pacienteService.crearPaciente(pacienteDTO);
        PacienteDTO paciente =  pacienteService.leerPaciente(1L);
        assertTrue(paciente != null);
        pacienteService.eliminarPaciente(paciente.getId());
        assertTrue(pacienteService.leerPaciente(1L) == null );
    }

}