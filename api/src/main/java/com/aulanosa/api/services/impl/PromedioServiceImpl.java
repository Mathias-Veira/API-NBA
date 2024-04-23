package com.aulanosa.api.services.impl;

import com.aulanosa.api.dtos.PromedioDTO;
import com.aulanosa.api.mappers.PromedioMapper;
import com.aulanosa.api.repositories.PromedioRepository;
import com.aulanosa.api.services.PromedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Lazy
@Component
public class PromedioServiceImpl implements PromedioService {
    @Autowired
    private PromedioRepository promedioRepository;
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
}
