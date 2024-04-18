package com.aulanosa.api.dtos;

public class EquipoDTO {
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

    public EquipoDTO(){

    }

    public EquipoDTO(int idEquipo, String nombreEquipo, String ciudadEquipo, String abreviacionEquipo, String imagenEquipo, String conferenciaEquipo, String divisionEquipo, int puestoConferencia, int puestoDivision, int nVictorias, int nDerrotas, double porcentajeVictorias) {
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

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getCiudadEquipo() {
        return ciudadEquipo;
    }

    public void setCiudadEquipo(String ciudadEquipo) {
        this.ciudadEquipo = ciudadEquipo;
    }

    public String getAbreviacionEquipo() {
        return abreviacionEquipo;
    }

    public void setAbreviacionEquipo(String abreviacionEquipo) {
        this.abreviacionEquipo = abreviacionEquipo;
    }

    public String getImagenEquipo() {
        return imagenEquipo;
    }

    public void setImagenEquipo(String imagenEquipo) {
        this.imagenEquipo = imagenEquipo;
    }

    public String getConferenciaEquipo() {
        return conferenciaEquipo;
    }

    public void setConferenciaEquipo(String conferenciaEquipo) {
        this.conferenciaEquipo = conferenciaEquipo;
    }

    public String getDivisionEquipo() {
        return divisionEquipo;
    }

    public void setDivisionEquipo(String divisionEquipo) {
        this.divisionEquipo = divisionEquipo;
    }

    public int getPuestoConferencia() {
        return puestoConferencia;
    }

    public void setPuestoConferencia(int puestoConferencia) {
        this.puestoConferencia = puestoConferencia;
    }

    public int getPuestoDivision() {
        return puestoDivision;
    }

    public void setPuestoDivision(int puestoDivision) {
        this.puestoDivision = puestoDivision;
    }

    public int getnVictorias() {
        return nVictorias;
    }

    public void setnVictorias(int nVictorias) {
        this.nVictorias = nVictorias;
    }

    public int getnDerrotas() {
        return nDerrotas;
    }

    public void setnDerrotas(int nDerrotas) {
        this.nDerrotas = nDerrotas;
    }

    public double getPorcentajeVictorias() {
        return porcentajeVictorias;
    }

    public void setPorcentajeVictorias(double porcentajeVictorias) {
        this.porcentajeVictorias = porcentajeVictorias;
    }
}
