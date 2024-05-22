package com.aulanosa.api.mappers;

import com.aulanosa.api.dtos.ApoyarDTO;
import com.aulanosa.api.models.Apoyar;
import com.aulanosa.api.models.ApoyarId;

public class ApoyarMapper {
    /**
     * Este método permite convertir de ApoyarDTO a apoyar
     * @param apoyarDTO objeto que se quiere convertir a modelo
     * @return objeto de la clase apoyar
     */
    public static Apoyar convertirAModelo(ApoyarDTO apoyarDTO){
        return new Apoyar(new ApoyarId(apoyarDTO.getIdUsuario(), apoyarDTO.getIdEquipo()));
    }

    /**
     * Este método permite convertir de modelo a ApoyarDTO
     * @param apoyar objeto de la clase Apoyar que se quiere convertir
     * @return objeto de la clase ApoyarDTO
     */
    public static ApoyarDTO convertirADTO(Apoyar apoyar){
        return new ApoyarDTO(apoyar.getApoyarId().getIdUsuario(),apoyar.getApoyarId().getIdEquipo());
    }
}
