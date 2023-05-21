package com.sip.ams.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sip.ams.entities.AuthenticationBean;
@CrossOrigin(origins = "*")
@RestController
public class BasicAuthRestController {
    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        //On doit faire ici la vérification au niveau de la base de données avec la classe User
        return new AuthenticationBean("You are authenticated");
    }
}