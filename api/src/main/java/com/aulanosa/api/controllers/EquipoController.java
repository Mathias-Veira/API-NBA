package com.aulanosa.api.controllers;

import com.aulanosa.api.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EquipoController {
    @Autowired
    private EquipoService equipoService;
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
}
