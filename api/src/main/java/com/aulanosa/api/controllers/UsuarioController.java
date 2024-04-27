package com.aulanosa.api.controllers;

import com.aulanosa.api.dtos.AccesoDTO;
import com.aulanosa.api.dtos.UsuarioDTO;
import com.aulanosa.api.error.IdNotFoundException;
import com.aulanosa.api.error.IncompleteDataException;
import com.aulanosa.api.error.LoginException;
import com.aulanosa.api.mappers.AccesoMapper;
import com.aulanosa.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    /**
     * Endpoint que permite validar si la entrada indicada es correcta para la realización de un inicio de sesión
     * @param acceso Información para realizar el acceso de sesión
     * @return Se devuelve la información correspondiente al usuario si el inicio es correcto
     */
    @PostMapping("/api/login")
    ResponseEntity<?> iniciarSesion(@RequestBody AccesoDTO acceso) throws IncompleteDataException, LoginException, IdNotFoundException {
            return ResponseEntity.ok(usuarioService.comprobarAcceso(acceso));
    }
    /**
     * Endpoint que permite registrar la información correspondiente a un usuario
     * @param usuarioDTO Información del usuario a registrar
     * @return Se devuelve la información posterior al registro
     */
    @PostMapping("/api/usuarios")
    ResponseEntity<?> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws IncompleteDataException {
        return ResponseEntity.ok(usuarioService.crearUsuario(usuarioDTO));
    }

}
