package com.aulanosa.api.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

/**
 * Esta clase representa los datos de la tabla que relaciona los usuarios con los equipos
 */
@Embeddable
public class ApoyarId implements Serializable {
    private int idUsuario;
    private int idEquipo;

    /**
     * Constructor vacío
     */
    public ApoyarId() {}

    /**
     * Constructor completo
     * @param idUsuario identificador de usuario
     * @param idEquipo identificador de equipo
     */
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

