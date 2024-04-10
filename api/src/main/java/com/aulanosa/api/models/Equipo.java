package com.aulanosa.api.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Equipos")
public class Equipo implements Serializable {

    private int idEquipo;
    private String nombreEquipo;
    private String ciudadEquipo;
    private String abreviacionEquipo;
    private String imagenEquipo;
    private String conferenciaEquipo;
    private String divisionEquipo;

    public Equipo(){

    }

    public Equipo(int idEquipo, String nombreEquipo, String ciudadEquipo, String abreviacionEquipo, String imagenEquipo, String conferenciaEquipo, String divisionEquipo) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.ciudadEquipo = ciudadEquipo;
        this.abreviacionEquipo = abreviacionEquipo;
        this.imagenEquipo = imagenEquipo;
        this.conferenciaEquipo = conferenciaEquipo;
        this.divisionEquipo = divisionEquipo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
    @Column(name = "nombre_equipo")
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    @Column(name = "ciudad_equipo")
    public String getCiudadEquipo() {
        return ciudadEquipo;
    }

    public void setCiudadEquipo(String ciudadEquipo) {
        this.ciudadEquipo = ciudadEquipo;
    }
    @Column(name = "abreviacion_equipo")
    public String getAbreviacionEquipo() {
        return abreviacionEquipo;
    }

    public void setAbreviacionEquipo(String abreviacionEquipo) {
        this.abreviacionEquipo = abreviacionEquipo;
    }
    @Column(name = "imagen_equipo")
    public String getImagenEquipo() {
        return imagenEquipo;
    }

    public void setImagenEquipo(String imagenEquipo) {
        this.imagenEquipo = imagenEquipo;
    }
    @Column(name = "conferencia_equipo")
    public String getConferenciaEquipo() {
        return conferenciaEquipo;
    }

    public void setConferenciaEquipo(String conferenciaEquipo) {
        this.conferenciaEquipo = conferenciaEquipo;
    }
    @Column(name = "division_equipo")
    public String getDivisionEquipo() {
        return divisionEquipo;
    }

    public void setDivisionEquipo(String divisionEquipo) {
        this.divisionEquipo = divisionEquipo;
    }
}
