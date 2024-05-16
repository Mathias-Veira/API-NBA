package com.aulanosa.api.controllers;

import com.aulanosa.api.services.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EstadisticaController {
    @Autowired
    private EstadisticaService estadisticaService;

    @GetMapping("api/stats")
    ResponseEntity<?> getEstadisticas(){
        return ResponseEntity.ok(estadisticaService.getEstadisticas());
    }
}
