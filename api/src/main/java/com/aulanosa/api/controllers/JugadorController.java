package com.aulanosa.api.controllers;

import com.aulanosa.api.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta clase representa el controlador de los jugadores
 */
@RestController
@CrossOrigin
public class JugadorController {
    @Autowired
    private JugadorService jugadorService;

    /**
     * Este endpoint devuelve todos los jugadores
     * @return Código de respuesta 200 junto con todos los jugadores de esta temporada
     */
    @GetMapping("api/players")
    ResponseEntity<?> getPlayers(){
        return ResponseEntity.ok(jugadorService.obtenerJugadoresTemporada());
    }
}
