package com.aulanosa.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "APOYAR")
public class Apoyar implements Serializable {
    @EmbeddedId
    private ApoyarId apoyarId;
    private int idUsuario;
    private int idEquipo;

    public Apoyar() {
    }

    public Apoyar(int idUsuario, int idEquipo) {
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
