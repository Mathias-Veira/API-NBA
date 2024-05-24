package com.aulanosa.api.controllers;

import com.aulanosa.api.error.IdNotFoundException;
import com.aulanosa.api.services.PromedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PromedioController {
    @Autowired
    private PromedioService promedioService;
    @GetMapping("api/stats/pts")
    ResponseEntity<?> getMaximosAnotadores(){
        return ResponseEntity.ok(promedioService.getMaximosAnotadores());
    }
    @GetMapping("api/stats/ast")
    ResponseEntity<?> getMaximosAsistentes(){
        return ResponseEntity.ok(promedioService.getMaximosAsistentes());
    }

    @GetMapping("api/stats/reb")
    ResponseEntity<?> getMaximosReboteadores(){return ResponseEntity.ok(promedioService.getMaximosReboteadores());}
    @GetMapping("api/stats/tov")
    ResponseEntity<?> getMaxPerdidas(){return ResponseEntity.ok(promedioService.getMaxPerdidas());}
    @GetMapping("api/stats/stl")
    ResponseEntity<?> getMaxRobos(){return ResponseEntity.ok(promedioService.getMaxRobos());}
    @GetMapping("api/stats/blk")
    ResponseEntity<?> getMaximosTaponadores(){return ResponseEntity.ok(promedioService.getMaximosTaponadores());}

    @GetMapping("api/promedios/jugadores/seguidos/{idUsuario}")
    ResponseEntity<?> getPromedioJugadoresSeguidos(@PathVariable int idUsuario) throws IdNotFoundException {
        return new ResponseEntity<>(promedioService.getPromedioJugadoresSeguidos(idUsuario), HttpStatus.OK);
    }


}
