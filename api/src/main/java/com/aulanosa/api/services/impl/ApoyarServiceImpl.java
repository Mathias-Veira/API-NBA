package com.aulanosa.api.services.impl;

import com.aulanosa.api.dtos.ApoyarDTO;
import com.aulanosa.api.mappers.ApoyarMapper;
import com.aulanosa.api.repositories.ApoyarRepository;
import com.aulanosa.api.services.ApoyarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.awt.dnd.InvalidDnDOperationException;

@Service
@Lazy
public class ApoyarServiceImpl implements ApoyarService {
    @Autowired
    private ApoyarRepository apoyarRepository;

    @Override
    public ApoyarDTO apoyarEquipo(ApoyarDTO apoyarDTO) {
        //throw new InvalidDnDOperationException();
        return ApoyarMapper.convertirADTO(apoyarRepository.save(ApoyarMapper.convertirAModelo(apoyarDTO)));
    }
}
