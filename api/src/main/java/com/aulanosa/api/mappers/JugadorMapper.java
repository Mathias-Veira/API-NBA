package com.aulanosa.api.mappers;

import com.aulanosa.api.dtos.JugadorDTO;
import com.aulanosa.api.models.Jugador;

import java.util.ArrayList;
import java.util.List;

public class JugadorMapper {
    /**
     * Este método permite convertir de JugadorDTO a Jugador
     * @param jugadorDTO objeto que se quiere convertir a modelo
     * @return objeto de la clase Jugador
     */
    public static Jugador convertirAModelo(JugadorDTO jugadorDTO){
        return new Jugador(jugadorDTO.getIdJugador(),jugadorDTO.getIdEquipo(), jugadorDTO.getNombreJugador(),jugadorDTO.getApellidoJugador(), jugadorDTO.getPosicionJugador(), jugadorDTO.getAlturaJugador(), jugadorDTO.getPesoJugador(), jugadorDTO.getNumeroCamiseta(), jugadorDTO.getUniversidad(), jugadorDTO.getProcedenciaJugador(), jugadorDTO.getAnioDraft(), jugadorDTO.getRondaDraft(), jugadorDTO.getNumeroDraft());
    }

    /**
     * Este método permite convertir de modelo a JugadorDTO
     * @param jugador objeto de la clase Jugador que se quiere convertir
     * @return objeto de la clase JugadorDTO
     */
    public static JugadorDTO convertirADTO(Jugador jugador){
        return new JugadorDTO(jugador.getIdJugador(), jugador.getIdEquipo(), jugador.getNombreJugador(), jugador.getApellidoJugador(), jugador.getPosicionJugador(), jugador.getAlturaJugador(), jugador.getPesoJugador(), jugador.getNumeroCamiseta(), jugador.getUniversidad(), jugador.getProcedenciaJugador(), jugador.getAnioDraft(), jugador.getRondaDraft(), jugador.getNumeroDraft());
    }

    /**
     * Este método permite convertir de lista de objetos Jugador a lista de objetos JugadorDTO
     * @param Jugadores lista de objetos Jugador
     * @return lista de objetos JugadorDTO
     */
    public static List<JugadorDTO> convertirLista(List<Jugador> Jugadores){
        List<JugadorDTO> JugadorDTOS = new ArrayList<>();

        for (Jugador Jugador: Jugadores) {
            JugadorDTOS.add(convertirADTO(Jugador));
        }

        return JugadorDTOS;
    }
}
