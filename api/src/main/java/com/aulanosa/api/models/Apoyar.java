package com.aulanosa.api.models;

import jakarta.persistence.*;

import java.io.Serializable;
/**
 * Esta clase representa los datos de la tabla que relaciona los usuarios con los equipos
 */
@Entity
@Table(name = "APOYAR")
public class Apoyar implements Serializable {
    @EmbeddedId
    private ApoyarId apoyarId;

    /**
     * Constructor vacío
     */
    public Apoyar() {
    }

    /**
     * Constructor completo
     * @param apoyarId objeto apoyarId con el identificador de usuario e identificador de equipo
     */
    public Apoyar(ApoyarId apoyarId) {
        this.apoyarId = apoyarId;
    }

    public ApoyarId getApoyarId() {
        return apoyarId;
    }

    public void setApoyarId(ApoyarId apoyarId) {
        this.apoyarId = apoyarId;
    }
}
