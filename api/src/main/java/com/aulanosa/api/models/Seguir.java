package com.aulanosa.api.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
/**
 * Esta clase representa los datos de la tabla que relaciona los usuarios con los jugadores
 */
@Entity
@Table(name = "SEGUIR")
public class Seguir implements Serializable {
    @EmbeddedId
    private SeguirId seguirId;

    public Seguir() {
    }

    /**
     * Constructor completo
     * @param seguirId objeto seguirId que contiene el identificador de usuario e identificador de jugador
     */
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
