package com.aulanosa.api.services;

import com.aulanosa.api.dtos.JugadorDTO;

import java.util.List;

public interface JugadorService {
    void almacenarJugadores();
    List<JugadorDTO> obtenerJugadoresTemporada();
    JugadorDTO getJugadorById(int idJugador);
}
