package com.aulanosa.api.mappers;

import com.aulanosa.api.dtos.EquipoDTO;
import com.aulanosa.api.dtos.SeguirDTO;
import com.aulanosa.api.models.Equipo;
import com.aulanosa.api.models.Seguir;
import com.aulanosa.api.models.SeguirId;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Este método permite convertir de lista de objetos Seguir a lista de objetos SeguirDTO
     * @param seguidos lista de objetos Seguir
     * @return lista de objetos SeguirDTO
     */
    public static List<SeguirDTO> convertirLista(List<Seguir> seguidos){
        List<SeguirDTO> seguidosDTO = new ArrayList<>();

        for (Seguir seguir: seguidos) {
            seguidosDTO.add(convertirADTO(seguir));
        }
        return seguidosDTO;
    }
}
