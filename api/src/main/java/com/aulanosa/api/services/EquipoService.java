package com.aulanosa.api.services;


import com.aulanosa.api.dtos.EquipoDTO;

import java.util.List;

public interface EquipoService  {
    List<EquipoDTO> obtenerEquipos();
    void almacenarEquipo(List<EquipoDTO> equipos);
}
