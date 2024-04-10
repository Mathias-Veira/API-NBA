package com.aulanosa.api.controllers;

import com.aulanosa.api.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EquipoController {
    @Autowired
    private EquipoService equipoService;
    @GetMapping("/api/equipos")
    ResponseEntity<?> obtenerEquipos(){
        return ResponseEntity.ok(equipoService.obtenerEquipos());
    }
}
