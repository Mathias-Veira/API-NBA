package com.aulanosa.api.dtos;

public class SeguirDTO {
    private int idUsuario;
    private int idJugador;

    public SeguirDTO() {
    }

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
