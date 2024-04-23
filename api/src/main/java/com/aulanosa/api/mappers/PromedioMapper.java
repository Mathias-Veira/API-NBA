package com.aulanosa.api.mappers;

import com.aulanosa.api.dtos.PromedioDTO;
import com.aulanosa.api.models.Promedio;

import java.util.ArrayList;
import java.util.List;

public class PromedioMapper {
    /**
     * Este método permite convertir de Promedio a Promedio
     * @param promedio objeto que se quiere convertir a modelo
     * @return objeto de la clase Promedio
     */
    public static Promedio convertirAModelo(Promedio promedio){
        return new Promedio(promedio.getIdJugador(),promedio.getIdEstadistica(),promedio.getPuntosPorPartido(),promedio.getAsistenciasPorPartido(),promedio.getPerdidasPorPartido(),promedio.getFaltasPorPartido(),promedio.getTirosIntentados(),promedio.getTirosConvertidos(),promedio.getTirosLibresIntentados(),promedio.getTirosLibresConvertidos(), promedio.getTriplesIntentados(), promedio.getTriplesConvertidos(), promedio.getRebotesPorPartido(), promedio.getRebotesOfensivosPorPartido(), promedio.getRebotesDefensivosPorPartido(), promedio.getRobosPorPartido(), promedio.getTaponesPorPartido(), promedio.getPorcentajeTirosDeCampo(), promedio.getPorcentajeTriples(), promedio.getPorcentajeTirosLibres(), promedio.getMinutosJugados(), promedio.getPartidosJugados(),promedio.getNombreJugador(),promedio.getApellidoJugador(), promedio.getPosicionJugador());
    }

    /**
     * Este método permite convertir de modelo a Promedio
     * @param promedio objeto de la clase Promedio que se quiere convertir
     * @return objeto de la clase Promedio
     */
    public static PromedioDTO convertirADTO(Promedio promedio){
        return new PromedioDTO(promedio.getIdJugador(),promedio.getIdEstadistica(),promedio.getPuntosPorPartido(),promedio.getAsistenciasPorPartido(),promedio.getPerdidasPorPartido(),promedio.getFaltasPorPartido(),promedio.getTirosIntentados(),promedio.getTirosConvertidos(),promedio.getTirosLibresIntentados(),promedio.getTirosLibresConvertidos(), promedio.getTriplesIntentados(), promedio.getTriplesConvertidos(), promedio.getRebotesPorPartido(), promedio.getRebotesOfensivosPorPartido(), promedio.getRebotesDefensivosPorPartido(), promedio.getRobosPorPartido(), promedio.getTaponesPorPartido(), promedio.getPorcentajeTirosDeCampo(), promedio.getPorcentajeTriples(), promedio.getPorcentajeTirosLibres(), promedio.getMinutosJugados(), promedio.getPartidosJugados(),promedio.getNombreJugador(),promedio.getApellidoJugador(), promedio.getPosicionJugador());
    }

    /**
     * Este método permite convertir de lista de objetos Promedio a lista de objetos Promedio
     * @param promedios lista de objetos Promedio
     * @return lista de objetos Promedio
     */
    public static List<PromedioDTO> convertirLista(List<Promedio> promedios){
        List<PromedioDTO> promediosDTO = new ArrayList<>();

        for (Promedio promedio: promedios) {
            promediosDTO.add(convertirADTO(promedio));
        }

        return promediosDTO;
    }
}
