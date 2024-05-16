package com.aulanosa.api.services;

import com.aulanosa.api.dtos.EstadisticaDTO;

import java.util.List;

public interface EstadisticaService {
    void insertarEstadisticas();
    List<EstadisticaDTO> getEstadisticas();

}
