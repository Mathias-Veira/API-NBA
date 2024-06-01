package com.aulanosa.api.dtos;

/**
 * Esta clase representa las estadísticas
 */
public class EstadisticaDTO {
    private int idEstadistica;
    private int idJugador;
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

    /**
     * Constructor vacío
     */
    public EstadisticaDTO() {
    }

    /**
     * Constructor completo
     * @param idEstadistica identificador de la estadística
     * @param idJugador identificador del jugador
     * @param puntosPorPartido puntos por partido
     * @param asistenciasPorPartido asistencias por partido
     * @param perdidasPorPartido pérdidas por partido
     * @param faltasPorPartido faltas por partido
     * @param tirosIntentados tiros intentados
     * @param tirosConvertidos tiros convertidos
     * @param tirosLibresIntentados tiros libres intentados
     * @param tirosLibresConvertidos tiros libres convertidos
     * @param triplesIntentados triples intentados
     * @param triplesConvertidos triples convertidos
     * @param rebotesPorPartido rebotes por partido
     * @param rebotesOfensivosPorPartido rebotes ofernsivos por partido
     * @param rebotesDefensivosPorPartido rebotes defensivos por partido
     * @param robosPorPartido robos por partido
     * @param taponesPorPartido tapones por partido
     * @param porcentajeTirosDeCampo porcentaje de tiros de campo
     * @param porcentajeTriples porcentaje de triples
     * @param porcentajeTirosLibres porcentaje de tiros libres
     * @param minutosJugados minutos jugados
     * @param partidosJugados partidos jugados
     */
    public EstadisticaDTO(int idEstadistica, int idJugador, double puntosPorPartido, double asistenciasPorPartido, double perdidasPorPartido, double faltasPorPartido, double tirosIntentados, double tirosConvertidos, double tirosLibresIntentados, double tirosLibresConvertidos, double triplesIntentados, double triplesConvertidos, double rebotesPorPartido, double rebotesOfensivosPorPartido, double rebotesDefensivosPorPartido, double robosPorPartido, double taponesPorPartido, double porcentajeTirosDeCampo, double porcentajeTriples, double porcentajeTirosLibres, String minutosJugados, int partidosJugados) {
        this.idEstadistica = idEstadistica;
        this.idJugador = idJugador;
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
    }

    public int getIdEstadistica() {
        return idEstadistica;
    }

    public void setIdEstadistica(int idEstadistica) {
        this.idEstadistica = idEstadistica;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public double getPuntosPorPartido() {
        return puntosPorPartido;
    }

    public void setPuntosPorPartido(double puntosPorPartido) {
        this.puntosPorPartido = puntosPorPartido;
    }

    public double getAsistenciasPorPartido() {
        return asistenciasPorPartido;
    }

    public void setAsistenciasPorPartido(double asistenciasPorPartido) {
        this.asistenciasPorPartido = asistenciasPorPartido;
    }

    public double getPerdidasPorPartido() {
        return perdidasPorPartido;
    }

    public void setPerdidasPorPartido(double perdidasPorPartido) {
        this.perdidasPorPartido = perdidasPorPartido;
    }

    public double getFaltasPorPartido() {
        return faltasPorPartido;
    }

    public void setFaltasPorPartido(double faltasPorPartido) {
        this.faltasPorPartido = faltasPorPartido;
    }

    public double getTirosIntentados() {
        return tirosIntentados;
    }

    public void setTirosIntentados(double tirosIntentados) {
        this.tirosIntentados = tirosIntentados;
    }

    public double getTirosConvertidos() {
        return tirosConvertidos;
    }

    public void setTirosConvertidos(double tirosConvertidos) {
        this.tirosConvertidos = tirosConvertidos;
    }

    public double getTirosLibresIntentados() {
        return tirosLibresIntentados;
    }

    public void setTirosLibresIntentados(double tirosLibresIntentados) {
        this.tirosLibresIntentados = tirosLibresIntentados;
    }

    public double getTirosLibresConvertidos() {
        return tirosLibresConvertidos;
    }

    public void setTirosLibresConvertidos(double tirosLibresConvertidos) {
        this.tirosLibresConvertidos = tirosLibresConvertidos;
    }

    public double getTriplesIntentados() {
        return triplesIntentados;
    }

    public void setTriplesIntentados(double triplesIntentados) {
        this.triplesIntentados = triplesIntentados;
    }

    public double getTriplesConvertidos() {
        return triplesConvertidos;
    }

    public void setTriplesConvertidos(double triplesConvertidos) {
        this.triplesConvertidos = triplesConvertidos;
    }

    public double getRebotesPorPartido() {
        return rebotesPorPartido;
    }

    public void setRebotesPorPartido(double rebotesPorPartido) {
        this.rebotesPorPartido = rebotesPorPartido;
    }

    public double getRebotesOfensivosPorPartido() {
        return rebotesOfensivosPorPartido;
    }

    public void setRebotesOfensivosPorPartido(double rebotesOfensivosPorPartido) {
        this.rebotesOfensivosPorPartido = rebotesOfensivosPorPartido;
    }

    public double getRebotesDefensivosPorPartido() {
        return rebotesDefensivosPorPartido;
    }

    public void setRebotesDefensivosPorPartido(double rebotesDefensivosPorPartido) {
        this.rebotesDefensivosPorPartido = rebotesDefensivosPorPartido;
    }

    public double getRobosPorPartido() {
        return robosPorPartido;
    }

    public void setRobosPorPartido(double robosPorPartido) {
        this.robosPorPartido = robosPorPartido;
    }

    public double getTaponesPorPartido() {
        return taponesPorPartido;
    }

    public void setTaponesPorPartido(double taponesPorPartido) {
        this.taponesPorPartido = taponesPorPartido;
    }

    public double getPorcentajeTirosDeCampo() {
        return porcentajeTirosDeCampo;
    }

    public void setPorcentajeTirosDeCampo(double porcentajeTirosDeCampo) {
        this.porcentajeTirosDeCampo = porcentajeTirosDeCampo;
    }

    public double getPorcentajeTriples() {
        return porcentajeTriples;
    }

    public void setPorcentajeTriples(double porcentajeTriples) {
        this.porcentajeTriples = porcentajeTriples;
    }

    public double getPorcentajeTirosLibres() {
        return porcentajeTirosLibres;
    }

    public void setPorcentajeTirosLibres(double porcentajeTirosLibres) {
        this.porcentajeTirosLibres = porcentajeTirosLibres;
    }

    public String getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(String minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }
}
