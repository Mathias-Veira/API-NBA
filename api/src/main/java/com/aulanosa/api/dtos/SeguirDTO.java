package com.aulanosa.api.dtos;
/**
 * Esta clase representa los datos de la tabla que relaciona los usuarios con los jugadores
 */
public class SeguirDTO {
    private int idUsuario;
    private int idJugador;

    /**
     * Constructor vacío
     */
    public SeguirDTO() {
    }

    /**
     * Constructor completo
     * @param idUsuario identificador del usuario
     * @param idJugador identificador del jugador
     */
    public SeguirDTO(int idUsuario, int idJugador) {
        this.idUsuario = idUsuario;
        this.idJugador = idJugador;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }
}
