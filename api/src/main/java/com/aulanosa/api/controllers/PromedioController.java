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

/**
 * Esta clase representa los promedios, es decir, contiene los endpoints para devolver jugadores con sus estadísticas
 */
@RestController
@CrossOrigin
public class PromedioController {
    @Autowired
    private PromedioService promedioService;

    /**
     * Este endpoint devuelve los máximos anotadores de la liga
     * @return Código de respuesta 200 junto con la lista de máximos anotadores. La lista está formada
     * por el nombre, apellido, posición del jugador y sus estadísticas
     */
    @GetMapping("api/stats/pts")
    ResponseEntity<?> getMaximosAnotadores(){
        return ResponseEntity.ok(promedioService.getMaximosAnotadores());
    }

    /**
     * Este endpoint devuelve los máximos asistentes de la liga
     * @return Código de respuesta 200 junto con la lista de los 10 máximos asistentes de la liga
     */
    @GetMapping("api/stats/ast")
    ResponseEntity<?> getMaximosAsistentes(){
        return ResponseEntity.ok(promedioService.getMaximosAsistentes());
    }
    /**
     * Este endpoint devuelve los máximos reboteadores de la liga
     * @return Código de respuesta 200 junto con la lista de los 10 máximos reboteadores de la liga
     */
    @GetMapping("api/stats/reb")
    ResponseEntity<?> getMaximosReboteadores(){return ResponseEntity.ok(promedioService.getMaximosReboteadores());}
    /**
     * Este endpoint devuelve los 10 jugadores con más pérdidas de la liga
     * @return Código de respuesta 200 junto con la lista de los 10 jugadores con más pérdidas
     */
    @GetMapping("api/stats/tov")
    ResponseEntity<?> getMaxPerdidas(){return ResponseEntity.ok(promedioService.getMaxPerdidas());}
    /**
     * Este endpoint devuelve los 10 jugadores con más robos de la liga
     * @return Código de respuesta 200 junto con la lista de los 10 jugadores con más robos
     */
    @GetMapping("api/stats/stl")
    ResponseEntity<?> getMaxRobos(){return ResponseEntity.ok(promedioService.getMaxRobos());}
    /**
     * Este endpoint devuelve los 10 jugadores con más tapones de la liga
     * @return Código de respuesta 200 junto con la lista de los 10 jugadores con más tapones
     */
    @GetMapping("api/stats/blk")
    ResponseEntity<?> getMaximosTaponadores(){return ResponseEntity.ok(promedioService.getMaximosTaponadores());}

    /**
     * Este endpoint devuelve los promedios de los jugadores que sigue un usuario
     * @param idUsuario identificador del usuario del que se quiere saber los jugadores que sigue
     * @return Código de respuesta 200 junto con la lista de los jugadores y sus promedios que son seguidos por ese usuario
     * @throws IdNotFoundException Excepción personalizada que se lanza cuando el identificador del usuario no se encuentra
     */
    @GetMapping("api/promedios/jugadores/seguidos/{idUsuario}")
    ResponseEntity<?> getPromedioJugadoresSeguidos(@PathVariable int idUsuario) throws IdNotFoundException {
        return new ResponseEntity<>(promedioService.getPromedioJugadoresSeguidos(idUsuario), HttpStatus.OK);
    }


}
