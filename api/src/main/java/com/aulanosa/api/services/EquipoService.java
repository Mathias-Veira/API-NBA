package com.aulanosa.api.services;


import com.aulanosa.api.dtos.EquipoDTO;

import java.util.List;

public interface EquipoService  {
    void almacenarEquipos();
    void updateEquipos();
    List<EquipoDTO> getTeams();
}
