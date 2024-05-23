package com.aulanosa.api.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "SEGUIR")
public class Seguir implements Serializable {
    @EmbeddedId
    private SeguirId seguirId;

    public Seguir() {
    }

    public Seguir(SeguirId seguirId) {
        this.seguirId = seguirId;
    }

    public SeguirId getSeguirId() {
        return seguirId;
    }

    public void setSeguirId(SeguirId seguirId) {
        this.seguirId = seguirId;
    }
}
