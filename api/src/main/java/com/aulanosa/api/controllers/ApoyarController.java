package com.aulanosa.api.controllers;

import com.aulanosa.api.dtos.ApoyarDTO;
import com.aulanosa.api.error.IdNotFoundException;
import com.aulanosa.api.error.IncompleteDataException;
import com.aulanosa.api.error.UserExistsException;
import com.aulanosa.api.services.ApoyarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ApoyarController {
    @Autowired
    private ApoyarService apoyarService;

    /**
     * Endpoint que permite registrar la información correspondiente a un usuario y el equipo al que apoya
     * @param apoyarDTO id del usuario e id del equipo que apoya
     * @return Se retorna código de respuesta 200 si no hubo ningún error
     */
    @PostMapping("/api/apoyar")
    ResponseEntity<?> registrarUsuario(@RequestBody ApoyarDTO apoyarDTO) throws IdNotFoundException {
        return new ResponseEntity<>(apoyarService.apoyarEquipo(apoyarDTO), HttpStatus.OK);
    }
}
