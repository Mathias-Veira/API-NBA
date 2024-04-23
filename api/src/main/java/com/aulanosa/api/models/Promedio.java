package com.aulanosa.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Promedio {
    private int idJugador;
    private int idEstadistica;
    private double puntosPorPartido;
    private double asistenciasPorPartido;
    private double perdidasPorPartido;
    private double faltasPorPartido;
    private double tirosIntentados;
    private double tirosConvertidos;
    private double tirosLibresIntentados;
    private double tirosLibresConvertidos;
    private double triplesIntentados;
    private double triplesConvertidos;
    private double rebotesPorPartido;
    private double rebotesOfensivosPorPartido;
    private double rebotesDefensivosPorPartido;
    private double robosPorPartido;
    private double taponesPorPartido;
    private double porcentajeTirosDeCampo;
    private double porcentajeTriples;
    private double porcentajeTirosLibres;
    private String minutosJugados;
    private int partidosJugados;
    private String nombreJugador;
    private String apellidoJugador;
    private String posicionJugador;

    public Promedio() {
    }

    public Promedio(int idJugador, int idEstadistica, double puntosPorPartido, double asistenciasPorPartido, double perdidasPorPartido, double faltasPorPartido, double tirosIntentados, double tirosConvertidos, double tirosLibresIntentados, double tirosLibresConvertidos, double triplesIntentados, double triplesConvertidos, double rebotesPorPartido, double rebotesOfensivosPorPartido, double rebotesDefensivosPorPartido, double robosPorPartido, double taponesPorPartido, double porcentajeTirosDeCampo, double porcentajeTriples, double porcentajeTirosLibres, String minutosJugados, int partidosJugados, String nombreJugador, String apellidoJugador, String posicionJugador) {
        this.idJugador = idJugador;
        this.idEstadistica = idEstadistica;
        this.puntosPorPartido = puntosPorPartido;
        this.asistenciasPorPartido = asistenciasPorPartido;
        this.perdidasPorPartido = perdidasPorPartido;
        this.faltasPorPartido = faltasPorPartido;
        this.tirosIntentados = tirosIntentados;
        this.tirosConvertidos = tirosConvertidos;
        this.tirosLibresIntentados = tirosLibresIntentados;
        this.tirosLibresConvertidos = tirosLibresConvertidos;
        this.triplesIntentados = triplesIntentados;
        this.triplesConvertidos = triplesConvertidos;
        this.rebotesPorPartido = rebotesPorPartido;
        this.rebotesOfensivosPorPartido = rebotesOfensivosPorPartido;
        this.rebotesDefensivosPorPartido = rebotesDefensivosPorPartido;
        this.robosPorPartido = robosPorPartido;
        this.taponesPorPartido = taponesPorPartido;
        this.porcentajeTirosDeCampo = porcentajeTirosDeCampo;
        this.porcentajeTriples = porcentajeTriples;
        this.porcentajeTirosLibres = porcentajeTirosLibres;
        this.minutosJugados = minutosJugados;
        this.partidosJugados = partidosJugados;
        this.nombreJugador = nombreJugador;
        this.apellidoJugador = apellidoJugador;
        this.posicionJugador = posicionJugador;
    }
    @Id
    @Column(name = "id_jugador")
    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }
    @Column(name = "id_estadistica")
    public int getIdEstadistica() {
        return idEstadistica;
    }

    public void setIdEstadistica(int idEstadistica) {
        this.idEstadistica = idEstadistica;
    }
    @Column(name = "puntos_por_partido")
    public double getPuntosPorPartido() {
        return puntosPorPartido;
    }

    public void setPuntosPorPartido(double puntosPorPartido) {
        this.puntosPorPartido = puntosPorPartido;
    }
    @Column(name = "asistencias_por_partido")
    public double getAsistenciasPorPartido() {
        return asistenciasPorPartido;
    }

    public void setAsistenciasPorPartido(double asistenciasPorPartido) {
        this.asistenciasPorPartido = asistenciasPorPartido;
    }
    @Column(name = "perdidas_por_partido")
    public double getPerdidasPorPartido() {
        return perdidasPorPartido;
    }

    public void setPerdidasPorPartido(double perdidasPorPartido) {
        this.perdidasPorPartido = perdidasPorPartido;
    }
    @Column(name = "faltas_por_partido")
    public double getFaltasPorPartido() {
        return faltasPorPartido;
    }

    public void setFaltasPorPartido(double faltasPorPartido) {
        this.faltasPorPartido = faltasPorPartido;
    }
    @Column(name = "tiros_intentados")
    public double getTirosIntentados() {
        return tirosIntentados;
    }

    public void setTirosIntentados(double tirosIntentados) {
        this.tirosIntentados = tirosIntentados;
    }
    @Column(name = "tiros_convertidos")
    public double getTirosConvertidos() {
        return tirosConvertidos;
    }

    public void setTirosConvertidos(double tirosConvertidos) {
        this.tirosConvertidos = tirosConvertidos;
    }
    @Column(name = "tiros_libres_intentados")
    public double getTirosLibresIntentados() {
        return tirosLibresIntentados;
    }

    public void setTirosLibresIntentados(double tirosLibresIntentados) {
        this.tirosLibresIntentados = tirosLibresIntentados;
    }
    @Column(name = "tiros_libres_convertidos")
    public double getTirosLibresConvertidos() {
        return tirosLibresConvertidos;
    }

    public void setTirosLibresConvertidos(double tirosLibresConvertidos) {
        this.tirosLibresConvertidos = tirosLibresConvertidos;
    }
    @Column(name = "triples_intentados")
    public double getTriplesIntentados() {
        return triplesIntentados;
    }

    public void setTriplesIntentados(double triplesIntentados) {
        this.triplesIntentados = triplesIntentados;
    }
    @Column(name = "triples_convertidos")
    public double getTriplesConvertidos() {
        return triplesConvertidos;
    }

    public void setTriplesConvertidos(double triplesConvertidos) {
        this.triplesConvertidos = triplesConvertidos;
    }
    @Column(name = "rebotes_por_partido")
    public double getRebotesPorPartido() {
        return rebotesPorPartido;
    }

    public void setRebotesPorPartido(double rebotesPorPartido) {
        this.rebotesPorPartido = rebotesPorPartido;
    }
    @Column(name = "rebotes_ofensivos_por_partido")
    public double getRebotesOfensivosPorPartido() {
        return rebotesOfensivosPorPartido;
    }

    public void setRebotesOfensivosPorPartido(double rebotesOfensivosPorPartido) {
        this.rebotesOfensivosPorPartido = rebotesOfensivosPorPartido;
    }
    @Column(name = "rebotes_defensivos_por_partido")
    public double getRebotesDefensivosPorPartido() {
        return rebotesDefensivosPorPartido;
    }

    public void setRebotesDefensivosPorPartido(double rebotesDefensivosPorPartido) {
        this.rebotesDefensivosPorPartido = rebotesDefensivosPorPartido;
    }
    @Column(name = "robos_por_partido")
    public double getRobosPorPartido() {
        return robosPorPartido;
    }

    public void setRobosPorPartido(double robosPorPartido) {
        this.robosPorPartido = robosPorPartido;
    }
    @Column(name = "tapones_por_partido")
    public double getTaponesPorPartido() {
        return taponesPorPartido;
    }

    public void setTaponesPorPartido(double taponesPorPartido) {
        this.taponesPorPartido = taponesPorPartido;
    }
    @Column(name = "porcentaje_tiros_de_campo ")
    public double getPorcentajeTirosDeCampo() {
        return porcentajeTirosDeCampo;
    }

    public void setPorcentajeTirosDeCampo(double porcentajeTirosDeCampo) {
        this.porcentajeTirosDeCampo = porcentajeTirosDeCampo;
    }
    @Column(name = "porcentaje_triples ")
    public double getPorcentajeTriples() {
        return porcentajeTriples;
    }

    public void setPorcentajeTriples(double porcentajeTriples) {
        this.porcentajeTriples = porcentajeTriples;
    }
    @Column(name = "porcentaje_tiros_libres ")
    public double getPorcentajeTirosLibres() {
        return porcentajeTirosLibres;
    }

    public void setPorcentajeTirosLibres(double porcentajeTirosLibres) {
        this.porcentajeTirosLibres = porcentajeTirosLibres;
    }
    @Column(name = "minutos_jugados_por_partido")
    public String getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(String minutosJugados) {
        this.minutosJugados = minutosJugados;
    }
    @Column(name = "partidos_jugados ")
    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
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
}
