package com.aulanosa.api.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;


@Embeddable
public class ApoyarId implements Serializable {
    private int idUsuario;
    private int idEquipo;
    public ApoyarId() {}

    public ApoyarId(int idUsuario, int idEquipo) {
        this.idUsuario = idUsuario;
        this.idEquipo = idEquipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
}

