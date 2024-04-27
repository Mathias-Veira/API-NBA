package com.aulanosa.api.services;


import com.aulanosa.api.dtos.AccesoDTO;
import com.aulanosa.api.dtos.UsuarioDTO;
import com.aulanosa.api.error.IdNotFoundException;
import com.aulanosa.api.error.IncompleteDataException;
import com.aulanosa.api.error.LoginException;

public interface UsuarioService{
    /**
     * Se define un método que permite comprobar el acceso de sesión de un usuario
     * @param accesoDTO Información para el acceso de sesión
     * @return Información del usuario si se cumple el acceso
     */
    UsuarioDTO comprobarAcceso(AccesoDTO accesoDTO) throws IncompleteDataException, LoginException, IdNotFoundException;

    /**
     * Se define un método que permite registrar un usuario a partir de la información indicada
     * @param usuarioDTO Información del usuario a registrar
     * @return Se devuelve la información correspondiente al usuario posteriormente al registro
     */
    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) throws IncompleteDataException;
}
