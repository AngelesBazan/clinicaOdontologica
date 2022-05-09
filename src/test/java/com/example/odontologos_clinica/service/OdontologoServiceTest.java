package com.example.odontologos_clinica.service;

import com.example.odontologos_clinica.exceptions.ResourceNotFoundExcepcion;
import com.example.odontologos_clinica.model.OdontologoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    private IOdontologoService odontologoService;
    private OdontologoDTO odontologoDTO;


    @Test
    public void testCrearUnOdontologo() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Juan");
        odontologoDTO.setApellido("Perez");
        odontologoDTO.setMatricula(111111);

        odontologoService.crearOdontologo(odontologoDTO);
        OdontologoDTO odontologo = odontologoService.leerOdontologo(1L);
        assertTrue(odontologo != null);
    }

    @Test
    public void testLeerUnOdontologo(){
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Juan");
        odontologoDTO.setApellido("Perez");
        odontologoDTO.setMatricula(111111);

        odontologoService.crearOdontologo(odontologoDTO);
        OdontologoDTO odontologo = odontologoService.leerOdontologo(1L);
        assertNotNull(odontologo.getId() != null);

    }

    @Test
    public void testLeerTodos() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Juan");
        odontologoDTO.setApellido("Perez");
        odontologoDTO.setMatricula(111111);

        odontologoService.crearOdontologo(odontologoDTO);
        assertTrue(odontologoService.leerTodos().size() != 0);
    }

    @Test
    public void testEliminarOdontologo() throws ResourceNotFoundExcepcion {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Juan");
        odontologoDTO.setApellido("Perez");
        odontologoDTO.setMatricula(111111);

        odontologoService.crearOdontologo(odontologoDTO);
        OdontologoDTO odontologo =  odontologoService.leerOdontologo(1L);
        assertTrue(odontologo != null);
        odontologoService.eliminarOdontologo(odontologo.getId());
        assertTrue(odontologoService.leerOdontologo(1L) == null );
    }

}