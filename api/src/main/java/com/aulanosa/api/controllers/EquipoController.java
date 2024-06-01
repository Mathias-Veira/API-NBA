package com.aulanosa.api.controllers;

import com.aulanosa.api.error.IdNotFoundException;
import com.aulanosa.api.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * Esta clase representa el controlador con los endpoints necesarios para almacenar
 * y devolver equipos
 */
@RestController
@CrossOrigin
public class EquipoController {
    @Autowired
    private EquipoService equipoService;

    /**
     * Este endpoint devuelve todos los equipos
     * @return Código de respuesta 200 junto con la lista de todos los equipos
     */
    @GetMapping("api/teams")
    ResponseEntity<?> getAllTeams(){
        return ResponseEntity.ok(equipoService.getAllTeams());
    }

    /**
     * Devuelve la clasificación general de la liga
     * @return Código de respuesta 200 junto con la clasificación general de la liga
     */
    @GetMapping("api/ranking")
    ResponseEntity<?> getLeagueRanking(){
        return ResponseEntity.ok(equipoService.getLeagueRanking());
    }

    /**
     * Devuelve la clasificación por conferencia
     * @param conference Conferencia por la que queremos saber la clasificación
     * @return Código de respuesta 200 junto con la lista de la clasificación
     */
    @GetMapping("api/ranking/{conference}")
    ResponseEntity<?> getConferenceRanking(@PathVariable String conference){
        return ResponseEntity.ok(equipoService.getConferenceRanking(conference));
    }

    /**
     * Devuelve la clasificación por división
     * @param division División por la que queremos saber la clasificación
     * @return Código de respuesta 200 junto con la lista de clasificación
     */
    @GetMapping("api/ranking/division/{division}")
    ResponseEntity<?> getDivisionRanking(@PathVariable String division){
        return ResponseEntity.ok(equipoService.getDivisionRanking(division));
    }

    /**
     * Devuelve el equipo según el identificador del jugador
     * @param idJugador identificador del jugador del que queramos saber su equipo
     * @return Código de respuesta 200 junto con el equipo en el que juega el jugador que se pasa
     */
    @GetMapping("api/team/{idJugador}")
    ResponseEntity<?> getTeamById(@PathVariable int idJugador){
        return new ResponseEntity<>(equipoService.getTeamById(idJugador), HttpStatus.OK);
    }

    /**
     * Devuelve los equipos que apoya un usuario
     * @param idUsuario identificador del usuario del que queramos saber los equipos que apoya
     * @return Código de respuesta 200 junto con los equipos que apoya ese usuario
     * @throws IdNotFoundException Excepción personalizada que se lanza cuando el identificador del usuario no existe
     */
    @GetMapping("api/equipos/apoyados/{idUsuario}")
    ResponseEntity<?> getEquiposApoyados(@PathVariable int idUsuario) throws IdNotFoundException {
        return new ResponseEntity<>(equipoService.getEquiposApoyados(idUsuario), HttpStatus.OK);
    }
}
