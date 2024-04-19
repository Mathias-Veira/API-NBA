package com.aulanosa.api.mappers;

import com.aulanosa.api.dtos.EquipoDTO;
import com.aulanosa.api.dtos.EstadisticaDTO;
import com.aulanosa.api.models.Equipo;
import com.aulanosa.api.models.Estadistica;

import java.util.ArrayList;
import java.util.List;

public class EstadisticaMapper {
    /**
     * Este método permite convertir de EstadisticaDTO a Estadistica
     * @param estadisticaDTO objeto que se quiere convertir a modelo
     * @return objeto de la clase Estadistica
     */
    public static Estadistica convertirAModelo(EstadisticaDTO estadisticaDTO){
        return new Estadistica(estadisticaDTO.getIdEstadistica(),estadisticaDTO.getIdJugador(),estadisticaDTO.getPuntosPorPartido(),estadisticaDTO.getAsistenciasPorPartido(),estadisticaDTO.getPerdidasPorPartido(),estadisticaDTO.getFaltasPorPartido(),estadisticaDTO.getTirosIntentados(),estadisticaDTO.getTirosConvertidos(),estadisticaDTO.getTirosLibresIntentados(),estadisticaDTO.getTirosLibresConvertidos(), estadisticaDTO.getTriplesIntentados(), estadisticaDTO.getTriplesConvertidos(), estadisticaDTO.getRebotesPorPartido(), estadisticaDTO.getRebotesOfensivosPorPartido(), estadisticaDTO.getRebotesDefensivosPorPartido(), estadisticaDTO.getRobosPorPartido(), estadisticaDTO.getTaponesPorPartido(), estadisticaDTO.getPorcentajeTirosDeCampo(), estadisticaDTO.getPorcentajeTriples(), estadisticaDTO.getPorcentajeTirosLibres(), estadisticaDTO.getMinutosJugados(), estadisticaDTO.getPartidosJugados());
    }

    /**
     * Este método permite convertir de modelo a EstadisticaDTO
     * @param estadistica objeto de la clase Estadistica que se quiere convertir
     * @return objeto de la clase EstadisticaDTO
     */
    public static EstadisticaDTO convertirADTO(Estadistica estadistica){
        return new EstadisticaDTO(estadistica.getIdEstadistica(),estadistica.getIdJugador(),estadistica.getPuntosPorPartido(),estadistica.getAsistenciasPorPartido(),estadistica.getPerdidasPorPartido(),estadistica.getFaltasPorPartido(),estadistica.getTirosIntentados(),estadistica.getTirosConvertidos(),estadistica.getTirosLibresIntentados(),estadistica.getTirosLibresConvertidos(), estadistica.getTriplesIntentados(), estadistica.getTriplesConvertidos(), estadistica.getRebotesPorPartido(), estadistica.getRebotesOfensivosPorPartido(), estadistica.getRebotesDefensivosPorPartido(), estadistica.getRobosPorPartido(), estadistica.getTaponesPorPartido(), estadistica.getPorcentajeTirosDeCampo(), estadistica.getPorcentajeTriples(), estadistica.getPorcentajeTirosLibres(), estadistica.getMinutosJugados(), estadistica.getPartidosJugados());
    }

    /**
     * Este método permite convertir de lista de objetos Estadistica a lista de objetos EstadisticaDTO
     * @param estadisticas lista de objetos Estadistica
     * @return lista de objetos EstadisticaDTO
     */
    public static List<EstadisticaDTO> convertirLista(List<Estadistica> estadisticas){
        List<EstadisticaDTO> estadisticaDTOS = new ArrayList<>();

        for (Estadistica estadistica: estadisticas) {
            estadisticaDTOS.add(convertirADTO(estadistica));
        }

        return estadisticaDTOS;
    }
}
