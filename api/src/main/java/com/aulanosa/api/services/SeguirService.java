package com.aulanosa.api.services;

import com.aulanosa.api.dtos.JugadorDTO;
import com.aulanosa.api.dtos.SeguirDTO;
import com.aulanosa.api.error.IdNotFoundException;

import java.util.List;

public interface SeguirService {
    SeguirDTO seguirJugador(SeguirDTO seguirDTO) throws IdNotFoundException;
    List<JugadorDTO> obtenerJugadoresSeguidos(int idUsuario) throws IdNotFoundException;
}
