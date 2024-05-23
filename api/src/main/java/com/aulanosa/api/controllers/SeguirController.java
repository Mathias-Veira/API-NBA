package com.aulanosa.api.controllers;

import com.aulanosa.api.dtos.SeguirDTO;
import com.aulanosa.api.error.IdNotFoundException;
import com.aulanosa.api.services.SeguirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SeguirController {
    @Autowired
    private SeguirService seguirService;
    /**
     * Endpoint que permite registrar la información correspondiente a un usuario y el jugador al que sigue
     * @param seguirDTO id del usuario e id del jugador que sigue
     * @return Se retorna código de respuesta 200 si no hubo ningún error
     */
    @PostMapping("/api/seguir")
    ResponseEntity<?> seguirJugador (@RequestBody SeguirDTO seguirDTO) throws IdNotFoundException {
        return new ResponseEntity<>(seguirService.seguirJugador(seguirDTO), HttpStatus.OK);
    }
}
