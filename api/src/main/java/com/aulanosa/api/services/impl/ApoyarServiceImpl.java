package com.aulanosa.api.services.impl;

import com.aulanosa.api.dtos.ApoyarDTO;
import com.aulanosa.api.error.IdNotFoundException;
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

    /**
     * Este método permite registrar el equipo que un usuario apoya
     * @param apoyarDTO Objeto ApoyarDTO con la información del identificador del equipo e identificador de usuario
     * @return objeto ApoyarDTO
     * @throws IdNotFoundException Excepción personalizada que se lanza si el identificador del usuario o el identificador del equipo no existe
     */
    @Override
    public ApoyarDTO apoyarEquipo(ApoyarDTO apoyarDTO) throws IdNotFoundException {
        ApoyarId apoyarId = new ApoyarId(apoyarDTO.getIdUsuario(),apoyarDTO.getIdEquipo());
        Apoyar apoyar = ApoyarMapper.convertirAModelo(apoyarDTO);
        apoyar.setApoyarId(apoyarId);
        try {
            return ApoyarMapper.convertirADTO(apoyarRepository.save(apoyar));
        }catch (RuntimeException e){
            throw new IdNotFoundException("Uno de los id no existe");
        }
    }
}
