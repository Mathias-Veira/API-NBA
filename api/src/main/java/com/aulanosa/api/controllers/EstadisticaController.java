package com.aulanosa.api.controllers;

import com.aulanosa.api.services.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta clase representa el controlador de las estadísticas
 */
@RestController
@CrossOrigin
public class EstadisticaController {
    @Autowired
    private EstadisticaService estadisticaService;

    /**
     * Este endpoint devuelve todas las estadísticas
     * @return Código de respuesta junto con todas las estadísticas
     */
    @GetMapping("api/stats")
    ResponseEntity<?> getEstadisticas(){
        return ResponseEntity.ok(estadisticaService.getEstadisticas());
    }
}
