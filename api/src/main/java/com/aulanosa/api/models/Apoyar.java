package com.aulanosa.api.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "APOYAR")
public class Apoyar implements Serializable {
    @EmbeddedId
    private ApoyarId apoyarId;


    public Apoyar() {
    }

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
