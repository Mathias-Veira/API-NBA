package com.aulanosa.api.services.impl;

import com.aulanosa.api.dtos.JugadorDTO;
import com.aulanosa.api.dtos.PromedioDTO;
import com.aulanosa.api.error.IdNotFoundException;
import com.aulanosa.api.mappers.PromedioMapper;
import com.aulanosa.api.repositories.PromedioRepository;
import com.aulanosa.api.services.PromedioService;
import com.aulanosa.api.services.SeguirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Lazy
@Component
public class PromedioServiceImpl implements PromedioService {
    @Autowired
    private PromedioRepository promedioRepository;
    @Autowired
    private SeguirService seguirService;
    @Override
    public List<PromedioDTO> getMaximosAnotadores() {
        return PromedioMapper.convertirLista(promedioRepository.getMaximosAnotadores());
    }

    @Override
    public List<PromedioDTO> getMaximosAsistentes() {
        return PromedioMapper.convertirLista(promedioRepository.getMaximosAsistentes());
    }

    @Override
    public List<PromedioDTO> getMaximosReboteadores() {
        return PromedioMapper.convertirLista(promedioRepository.getMaximosReboteadores());
    }

    @Override
    public List<PromedioDTO> getMaxPerdidas() {
       return PromedioMapper.convertirLista(promedioRepository.getMaxPerdidas());
    }

    @Override
    public List<PromedioDTO> getMaxRobos() {
        return PromedioMapper.convertirLista(promedioRepository.getMaxRobos());
    }

    @Override
    public List<PromedioDTO> getMaximosTaponadores() {
        return PromedioMapper.convertirLista(promedioRepository.getMaximosTaponadores());
    }

    @Override
    public List<PromedioDTO> getPromedioJugadoresSeguidos(int idUsuario) throws IdNotFoundException {
        List<PromedioDTO> promedios = new ArrayList<>();
        List<JugadorDTO> jugadores;
        try {
            jugadores = seguirService.obtenerJugadoresSeguidos(idUsuario);
            for (JugadorDTO jugadorDTO: jugadores) {
                promedios = PromedioMapper.convertirLista(promedioRepository.getPromedioJugadoresSeguidos(jugadorDTO.getIdJugador()));
            }
            return promedios;
        }catch (RuntimeException e){
            throw new IdNotFoundException("El id no existe");
        }
    }
}
