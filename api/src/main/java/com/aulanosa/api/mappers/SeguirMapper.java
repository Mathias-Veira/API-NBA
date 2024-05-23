package com.aulanosa.api.mappers;

import com.aulanosa.api.dtos.SeguirDTO;
import com.aulanosa.api.models.Seguir;
import com.aulanosa.api.models.SeguirId;

public class SeguirMapper {
    /**
     * Este método permite convertir de SeguirDTO a seguir
     * @param seguirDTO objeto que se quiere convertir a modelo
     * @return objeto de la clase seguir
     */
    public static Seguir convertirAModelo(SeguirDTO seguirDTO){
        return new Seguir(new SeguirId(seguirDTO.getIdUsuario(), seguirDTO.getIdJugador()));
    }

    /**
     * Este método permite convertir de modelo a SeguirDTO
     * @param seguir objeto de la clase Seguir que se quiere convertir
     * @return objeto de la clase SeguirDTO
     */
    public static SeguirDTO convertirADTO(Seguir seguir){
        return new SeguirDTO(seguir.getSeguirId().getIdUsuario(),seguir.getSeguirId().getIdJugador());
    }
}
