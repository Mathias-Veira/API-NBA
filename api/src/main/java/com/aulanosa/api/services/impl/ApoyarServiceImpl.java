package com.aulanosa.api.services.impl;

import com.aulanosa.api.dtos.ApoyarDTO;
import com.aulanosa.api.mappers.ApoyarMapper;
import com.aulanosa.api.models.Apoyar;
import com.aulanosa.api.models.ApoyarId;
import com.aulanosa.api.repositories.ApoyarRepository;
import com.aulanosa.api.services.ApoyarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


@Service
@Lazy
public class ApoyarServiceImpl implements ApoyarService {
    @Autowired
    private ApoyarRepository apoyarRepository;

    @Override
    public ApoyarDTO apoyarEquipo(ApoyarDTO apoyarDTO) {
        ApoyarId apoyarId = new ApoyarId(apoyarDTO.getUsuarioDTO().getIdUsuario(),apoyarDTO.getEquipoDTO().getIdEquipo());
        Apoyar apoyar = ApoyarMapper.convertirAModelo(apoyarDTO);
        apoyar.setApoyarId(apoyarId);
        return ApoyarMapper.convertirADTO(apoyarRepository.save(apoyar));
    }
}
