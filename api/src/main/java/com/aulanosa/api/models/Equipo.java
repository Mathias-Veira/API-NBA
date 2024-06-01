package com.aulanosa.api.models;

import jakarta.persistence.*;

import java.io.Serializable;
/**
 * Esta clase representa la información de un equipo
 */
@Entity
@Table(name = "EQUIPOS")
public class Equipo implements Serializable {

    private int idEquipo;
    private String nombreEquipo;
    private String ciudadEquipo;
    private String abreviacionEquipo;
    private String imagenEquipo;
    private String conferenciaEquipo;
    private String divisionEquipo;
    private int puestoConferencia;
    private int puestoDivision;
    private int nVictorias;
    private int nDerrotas;
    private double porcentajeVictorias;

    /**
     * Constructor vacío
     */
    public Equipo(){

    }
    /**
     * Constructor completo
     * @param idEquipo identificador del equipo
     * @param nombreEquipo nombre del equipo
     * @param ciudadEquipo ciudad del equipo
     * @param abreviacionEquipo abreviación del equipo
     * @param imagenEquipo logo del equipo
     * @param conferenciaEquipo conferencia a la que pertenece el equipo
     * @param divisionEquipo división a la que pertenece el equipo
     * @param puestoConferencia puesto del equipo en la conferencia
     * @param puestoDivision puesto del equipo en la división
     * @param nVictorias número de victorias
     * @param nDerrotas número de derrotas
     * @param porcentajeVictorias porcentaje de victorias
     */
    public Equipo(int idEquipo, String nombreEquipo, String ciudadEquipo, String abreviacionEquipo, String imagenEquipo, String conferenciaEquipo, String divisionEquipo, int puestoConferencia, int puestoDivision, int nVictorias, int nDerrotas, double porcentajeVictorias) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.ciudadEquipo = ciudadEquipo;
        this.abreviacionEquipo = abreviacionEquipo;
        this.imagenEquipo = imagenEquipo;
        this.conferenciaEquipo = conferenciaEquipo;
        this.divisionEquipo = divisionEquipo;
        this.puestoConferencia = puestoConferencia;
        this.puestoDivision = puestoDivision;
        this.nVictorias = nVictorias;
        this.nDerrotas = nDerrotas;
        this.porcentajeVictorias = porcentajeVictorias;
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
    @Column(name = "puesto_conferencia")
    public int getPuestoConferencia() {
        return puestoConferencia;
    }

    public void setPuestoConferencia(int puestoConferencia) {
        this.puestoConferencia = puestoConferencia;
    }
    @Column(name = "puesto_division")
    public int getPuestoDivision() {
        return puestoDivision;
    }

    public void setPuestoDivision(int puestoDivision) {
        this.puestoDivision = puestoDivision;
    }
    @Column(name = "n_victorias")
    public int getnVictorias() {
        return nVictorias;
    }

    public void setnVictorias(int nVictorias) {
        this.nVictorias = nVictorias;
    }
    @Column(name = "n_derrotas")
    public int getnDerrotas() {
        return nDerrotas;
    }

    public void setnDerrotas(int nDerrotas) {
        this.nDerrotas = nDerrotas;
    }
    @Column(name = "porcentaje_victorias")
    public double getPorcentajeVictorias() {
        return porcentajeVictorias;
    }

    public void setPorcentajeVictorias(double porcentajeVictorias) {
        this.porcentajeVictorias = porcentajeVictorias;
    }
}
