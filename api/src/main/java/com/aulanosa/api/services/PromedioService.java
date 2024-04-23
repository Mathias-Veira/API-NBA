package com.aulanosa.api.services;

import com.aulanosa.api.dtos.PromedioDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PromedioService {
    List<PromedioDTO> getMaximosAnotadores();
    List<PromedioDTO> getMaximosAsistentes();
    List<PromedioDTO> getMaximosReboteadores();
    List<PromedioDTO> getMaxPerdidas();
    List<PromedioDTO> getMaxRobos();
    List<PromedioDTO> getMaximosTaponadores();



}
