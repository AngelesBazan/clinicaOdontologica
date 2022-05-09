package com.example.odontologos_clinica.service.auth;

import com.example.odontologos_clinica.model.auth.Usuario;
import com.example.odontologos_clinica.model.auth.UsuarioRole;
import com.example.odontologos_clinica.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password1 = passwordEncoder.encode("password1");


        userRepository.save(new Usuario("Usuario1", "user1", "user1@mail.com", password, UsuarioRole.USER));
        userRepository.save(new Usuario("Admin1", "admin1", "admin1@mail.com", password1, UsuarioRole.ADMIN));


    }
}
