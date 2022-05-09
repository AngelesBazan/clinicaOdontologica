package com.example.odontologos_clinica.controller.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController {


    @GetMapping("/error")
    public String error(){
        return "<h1> No tiene permiso para acceder a esta sección </h1>";
    }


}
