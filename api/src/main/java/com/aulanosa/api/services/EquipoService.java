package com.aulanosa.api.services;


import com.aulanosa.api.dtos.EquipoDTO;
import com.aulanosa.api.dtos.PromedioDTO;
import com.aulanosa.api.error.IdNotFoundException;

import java.util.List;

public interface EquipoService  {
    void almacenarEquipos();
    void updateEquipos();
    List<EquipoDTO> getAllTeams();
    List<EquipoDTO> getLeagueRanking();
    List<EquipoDTO> getConferenceRanking(String conference);

    List<EquipoDTO> getDivisionRanking(String division);
    EquipoDTO getTeamById(int idJugador);
    List<EquipoDTO> getEquiposApoyados(int idUsuario) throws IdNotFoundException;
}
