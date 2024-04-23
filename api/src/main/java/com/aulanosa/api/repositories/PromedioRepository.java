package com.aulanosa.api.repositories;

import com.aulanosa.api.models.Promedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromedioRepository extends JpaRepository<Promedio,Integer> {
    //En el select se utiliza new Promedio para mapear los resultados de la consulta, ya que la consulta devuelve datos de dos tablas
    @Query("SELECT NEW com.aulanosa.api.models.Promedio(e.idJugador,e.idEstadistica, e.puntosPorPartido, e.asistenciasPorPartido, e.perdidasPorPartido, e.faltasPorPartido, e.tirosIntentados, e.tirosConvertidos, e.tirosLibresIntentados, e.tirosLibresConvertidos, e.triplesIntentados, e.triplesConvertidos, e.rebotesPorPartido, e.rebotesOfensivosPorPartido, e.rebotesDefensivosPorPartido, e.robosPorPartido, e.taponesPorPartido, e.porcentajeTirosDeCampo, e.porcentajeTriples, e.porcentajeTirosLibres, e.minutosJugados, e.partidosJugados,j.nombreJugador, j.apellidoJugador, j.posicionJugador) FROM Estadistica e INNER JOIN Jugador j ON e.idJugador = j.idJugador WHERE e.partidosJugados > 65 ORDER BY e.puntosPorPartido DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY")
    List<Promedio> getMaximosAnotadores();

    //En el select se utiliza new Promedio para mapear los resultados de la consulta, ya que la consulta devuelve datos de dos tablas
    @Query("SELECT NEW com.aulanosa.api.models.Promedio(e.idJugador,e.idEstadistica, e.puntosPorPartido, e.asistenciasPorPartido, e.perdidasPorPartido, e.faltasPorPartido, e.tirosIntentados, e.tirosConvertidos, e.tirosLibresIntentados, e.tirosLibresConvertidos, e.triplesIntentados, e.triplesConvertidos, e.rebotesPorPartido, e.rebotesOfensivosPorPartido, e.rebotesDefensivosPorPartido, e.robosPorPartido, e.taponesPorPartido, e.porcentajeTirosDeCampo, e.porcentajeTriples, e.porcentajeTirosLibres, e.minutosJugados, e.partidosJugados,j.nombreJugador, j.apellidoJugador, j.posicionJugador) FROM Estadistica e INNER JOIN Jugador j ON e.idJugador = j.idJugador WHERE e.partidosJugados > 65 ORDER BY e.asistenciasPorPartido DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY")
    List<Promedio> getMaximosAsistentes();

    //En el select se utiliza new Promedio para mapear los resultados de la consulta, ya que la consulta devuelve datos de dos tablas
    @Query("SELECT NEW com.aulanosa.api.models.Promedio(e.idJugador,e.idEstadistica, e.puntosPorPartido, e.asistenciasPorPartido, e.perdidasPorPartido, e.faltasPorPartido, e.tirosIntentados, e.tirosConvertidos, e.tirosLibresIntentados, e.tirosLibresConvertidos, e.triplesIntentados, e.triplesConvertidos, e.rebotesPorPartido, e.rebotesOfensivosPorPartido, e.rebotesDefensivosPorPartido, e.robosPorPartido, e.taponesPorPartido, e.porcentajeTirosDeCampo, e.porcentajeTriples, e.porcentajeTirosLibres, e.minutosJugados, e.partidosJugados,j.nombreJugador, j.apellidoJugador, j.posicionJugador) FROM Estadistica e INNER JOIN Jugador j ON e.idJugador = j.idJugador WHERE e.partidosJugados > 65 ORDER BY e.rebotesPorPartido DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY")
    List<Promedio> getMaximosReboteadores();
    //En el select se utiliza new Promedio para mapear los resultados de la consulta, ya que la consulta devuelve datos de dos tablas
    @Query("SELECT NEW com.aulanosa.api.models.Promedio(e.idJugador,e.idEstadistica, e.puntosPorPartido, e.asistenciasPorPartido, e.perdidasPorPartido, e.faltasPorPartido, e.tirosIntentados, e.tirosConvertidos, e.tirosLibresIntentados, e.tirosLibresConvertidos, e.triplesIntentados, e.triplesConvertidos, e.rebotesPorPartido, e.rebotesOfensivosPorPartido, e.rebotesDefensivosPorPartido, e.robosPorPartido, e.taponesPorPartido, e.porcentajeTirosDeCampo, e.porcentajeTriples, e.porcentajeTirosLibres, e.minutosJugados, e.partidosJugados,j.nombreJugador, j.apellidoJugador, j.posicionJugador) FROM Estadistica e INNER JOIN Jugador j ON e.idJugador = j.idJugador WHERE e.partidosJugados > 65 ORDER BY e.perdidasPorPartido DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY")
    List<Promedio> getMaxPerdidas();

    //En el select se utiliza new Promedio para mapear los resultados de la consulta, ya que la consulta devuelve datos de dos tablas
    @Query("SELECT NEW com.aulanosa.api.models.Promedio(e.idJugador,e.idEstadistica, e.puntosPorPartido, e.asistenciasPorPartido, e.perdidasPorPartido, e.faltasPorPartido, e.tirosIntentados, e.tirosConvertidos, e.tirosLibresIntentados, e.tirosLibresConvertidos, e.triplesIntentados, e.triplesConvertidos, e.rebotesPorPartido, e.rebotesOfensivosPorPartido, e.rebotesDefensivosPorPartido, e.robosPorPartido, e.taponesPorPartido, e.porcentajeTirosDeCampo, e.porcentajeTriples, e.porcentajeTirosLibres, e.minutosJugados, e.partidosJugados,j.nombreJugador, j.apellidoJugador, j.posicionJugador) FROM Estadistica e INNER JOIN Jugador j ON e.idJugador = j.idJugador WHERE e.partidosJugados > 65 ORDER BY e.robosPorPartido DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY")
    List<Promedio> getMaxRobos();
    //En el select se utiliza new Promedio para mapear los resultados de la consulta, ya que la consulta devuelve datos de dos tablas
    @Query("SELECT NEW com.aulanosa.api.models.Promedio(e.idJugador,e.idEstadistica, e.puntosPorPartido, e.asistenciasPorPartido, e.perdidasPorPartido, e.faltasPorPartido, e.tirosIntentados, e.tirosConvertidos, e.tirosLibresIntentados, e.tirosLibresConvertidos, e.triplesIntentados, e.triplesConvertidos, e.rebotesPorPartido, e.rebotesOfensivosPorPartido, e.rebotesDefensivosPorPartido, e.robosPorPartido, e.taponesPorPartido, e.porcentajeTirosDeCampo, e.porcentajeTriples, e.porcentajeTirosLibres, e.minutosJugados, e.partidosJugados,j.nombreJugador, j.apellidoJugador, j.posicionJugador) FROM Estadistica e INNER JOIN Jugador j ON e.idJugador = j.idJugador WHERE e.partidosJugados > 65 ORDER BY e.taponesPorPartido DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY")
    List<Promedio> getMaximosTaponadores();


}
