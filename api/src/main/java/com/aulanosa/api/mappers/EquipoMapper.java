package com.aulanosa.api.mappers;

import com.aulanosa.api.dtos.EquipoDTO;
import com.aulanosa.api.models.Equipo;

import java.util.ArrayList;
import java.util.List;

public class EquipoMapper {
    /**
     * Este método permite convertir de equipoDTO a equipo
     * @param equipoDTO objeto que se quiere convertir a modelo
     * @return objeto de la clase equipo
     */
    public static Equipo convertirAModelo(EquipoDTO equipoDTO){
        return new Equipo(equipoDTO.getIdEquipo(), equipoDTO.getNombreEquipo(), equipoDTO.getCiudadEquipo(), equipoDTO.getAbreviacionEquipo(), equipoDTO.getImagenEquipo(), equipoDTO.getConferenciaEquipo(), equipoDTO.getDivisionEquipo(), equipoDTO.getPuestoConferencia(), equipoDTO.getPuestoDivision(), equipoDTO.getnVictorias(), equipoDTO.getnDerrotas(), equipoDTO.getPorcentajeVictorias());
    }

    /**
     * Este método permite convertir de modelo a EquipoDTO
     * @param equipo objeto de la clase Equipo que se quiere convertir
     * @return objeto de la clase EquipoDTO
     */
    public static EquipoDTO convertirADTO(Equipo equipo){
        return new EquipoDTO(equipo.getIdEquipo(), equipo.getNombreEquipo(), equipo.getCiudadEquipo(), equipo.getAbreviacionEquipo(), equipo.getImagenEquipo(), equipo.getConferenciaEquipo(), equipo.getDivisionEquipo(), equipo.getPuestoConferencia(), equipo.getPuestoDivision(), equipo.getnVictorias(), equipo.getnDerrotas(), equipo.getPorcentajeVictorias());
    }

    /**
     * Este método permite convertir de lista de objetos Equipo a lista de objetos EquipoDTO
     * @param equipos lista de objetos Equipo
     * @return lista de objetos EquipoDTO
     */
    public static List<EquipoDTO> convertirLista(List<Equipo> equipos){
        List<EquipoDTO> equipoDTOS = new ArrayList<>();

        for (Equipo equipo: equipos) {
            equipoDTOS.add(convertirADTO(equipo));
        }

        return equipoDTOS;
    }
}
