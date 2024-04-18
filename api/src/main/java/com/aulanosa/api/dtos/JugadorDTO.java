package com.aulanosa.api.dtos;

public class JugadorDTO {
    private int idJugador;
    private int idEquipo;
    private String nombreJugador;
    private String apellidoJugador;
    private String posicionJugador;
    private String alturaJugador;
    private int pesoJugador;
    private int numeroCamiseta;
    private String universidad;
    private String procedenciaJugador;
    private int anioDraft;
    private int rondaDraft;
    private int numeroDraft;

    public JugadorDTO() {
    }

    public JugadorDTO(int idJugador, int idEquipo, String nombreJugador, String apellidoJugador, String posicionJugador, String alturaJugador, int pesoJugador, int numeroCamiseta, String universidad, String procedenciaJugador, int anioDraft, int rondaDraft, int numeroDraft) {
        this.idJugador = idJugador;
        this.idEquipo = idEquipo;
        this.nombreJugador = nombreJugador;
        this.apellidoJugador = apellidoJugador;
        this.posicionJugador = posicionJugador;
        this.alturaJugador = alturaJugador;
        this.pesoJugador = pesoJugador;
        this.numeroCamiseta = numeroCamiseta;
        this.universidad = universidad;
        this.procedenciaJugador = procedenciaJugador;
        this.anioDraft = anioDraft;
        this.rondaDraft = rondaDraft;
        this.numeroDraft = numeroDraft;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getApellidoJugador() {
        return apellidoJugador;
    }

    public void setApellidoJugador(String apellidoJugador) {
        this.apellidoJugador = apellidoJugador;
    }

    public String getPosicionJugador() {
        return posicionJugador;
    }

    public void setPosicionJugador(String posicionJugador) {
        this.posicionJugador = posicionJugador;
    }

    public String getAlturaJugador() {
        return alturaJugador;
    }

    public void setAlturaJugador(String alturaJugador) {
        this.alturaJugador = alturaJugador;
    }

    public int getPesoJugador() {
        return pesoJugador;
    }

    public void setPesoJugador(int pesoJugador) {
        this.pesoJugador = pesoJugador;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getProcedenciaJugador() {
        return procedenciaJugador;
    }

    public void setProcedenciaJugador(String procedenciaJugador) {
        this.procedenciaJugador = procedenciaJugador;
    }

    public int getAnioDraft() {
        return anioDraft;
    }

    public void setAnioDraft(int anioDraft) {
        this.anioDraft = anioDraft;
    }

    public int getRondaDraft() {
        return rondaDraft;
    }

    public void setRondaDraft(int rondaDraft) {
        this.rondaDraft = rondaDraft;
    }

    public int getNumeroDraft() {
        return numeroDraft;
    }

    public void setNumeroDraft(int numeroDraft) {
        this.numeroDraft = numeroDraft;
    }
}
