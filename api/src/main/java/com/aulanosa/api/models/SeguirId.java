package com.aulanosa.api.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class SeguirId implements Serializable {
    private int idUsuario;
    private int idJugador;

    public SeguirId() {
    }

    public SeguirId(int idUsuario, int idJugador) {
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
