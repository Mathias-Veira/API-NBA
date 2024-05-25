package com.aulanosa.api.controllers;

import com.aulanosa.api.error.IdNotFoundException;
import com.aulanosa.api.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EquipoController {
    @Autowired
    private EquipoService equipoService;

    @GetMapping("api/teams")
    ResponseEntity<?> getAllTeams(){
        return ResponseEntity.ok(equipoService.getAllTeams());
    }
    @GetMapping("api/ranking")
    ResponseEntity<?> getLeagueRanking(){
        return ResponseEntity.ok(equipoService.getLeagueRanking());
    }

    @GetMapping("api/ranking/{conference}")
    ResponseEntity<?> getConferenceRanking(@PathVariable String conference){
        return ResponseEntity.ok(equipoService.getConferenceRanking(conference));
    }

    @GetMapping("api/ranking/division/{division}")
    ResponseEntity<?> getDivisionRanking(@PathVariable String division){
        return ResponseEntity.ok(equipoService.getDivisionRanking(division));
    }

    @GetMapping("api/team/{idJugador}")
    ResponseEntity<?> getTeamById(@PathVariable int idJugador){
        return new ResponseEntity<>(equipoService.getTeamById(idJugador), HttpStatus.OK);
    }

    @GetMapping("api/equipos/apoyados/{idUsuario}")
    ResponseEntity<?> getEquiposApoyados(@PathVariable int idUsuario) throws IdNotFoundException {
        return new ResponseEntity<>(equipoService.getEquiposApoyados(idUsuario), HttpStatus.OK);
    }
}
