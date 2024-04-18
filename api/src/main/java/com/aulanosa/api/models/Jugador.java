package com.aulanosa.api.models;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "JUGADORES")
public class Jugador implements Serializable {
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

    public Jugador() {
    }

    public Jugador(int idJugador, int idEquipo, String nombreJugador, String apellidoJugador, String posicionJugador, String alturaJugador, int pesoJugador, int numeroCamiseta, String universidad, String procedenciaJugador, int anioDraft, int rondaDraft, int numeroDraft) {
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }
    @Column(name = "id_equipo")
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
    @Column(name = "nombre_jugador")
    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    @Column(name = "apellido_jugador")
    public String getApellidoJugador() {
        return apellidoJugador;
    }

    public void setApellidoJugador(String apellidoJugador) {
        this.apellidoJugador = apellidoJugador;
    }
    @Column(name = "posicion_jugador")
    public String getPosicionJugador() {
        return posicionJugador;
    }

    public void setPosicionJugador(String posicionJugador) {
        this.posicionJugador = posicionJugador;
    }
    @Column(name = "altura_jugador")
    public String getAlturaJugador() {
        return alturaJugador;
    }

    public void setAlturaJugador(String alturaJugador) {
        this.alturaJugador = alturaJugador;
    }
    @Column(name = "peso_jugador")
    public int getPesoJugador() {
        return pesoJugador;
    }

    public void setPesoJugador(int pesoJugador) {
        this.pesoJugador = pesoJugador;
    }
    @Column(name = "numero_camiseta")
    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }
    @Column(name = "universidad")
    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    @Column(name = "procedencia_jugador")
    public String getProcedenciaJugador() {
        return procedenciaJugador;
    }

    public void setProcedenciaJugador(String procedenciaJugador) {
        this.procedenciaJugador = procedenciaJugador;
    }
    @Column(name = "anio_draft")
    public int getAnioDraft() {
        return anioDraft;
    }

    public void setAnioDraft(int anioDraft) {
        this.anioDraft = anioDraft;
    }
    @Column(name = "ronda_draft")
    public int getRondaDraft() {
        return rondaDraft;
    }

    public void setRondaDraft(int rondaDraft) {
        this.rondaDraft = rondaDraft;
    }
    @Column(name = "numero_draft")
    public int getNumeroDraft() {
        return numeroDraft;
    }

    public void setNumeroDraft(int numeroDraft) {
        this.numeroDraft = numeroDraft;
    }


}
