package com.aulanosa.api.controllers;

import com.aulanosa.api.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JugadorController {
    @Autowired
    private JugadorService jugadorService;
}
