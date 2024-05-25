package com.aulanosa.api.repositories;

import com.aulanosa.api.dtos.EquipoDTO;
import com.aulanosa.api.models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EquipoRepository extends JpaRepository<Equipo,Integer> {
    @Query("SELECT e FROM Equipo e ORDER BY e.porcentajeVictorias DESC")
    List<Equipo> getLeagueRanking();

    @Query("SELECT e FROM Equipo e WHERE e.conferenciaEquipo like :conference ORDER BY e.porcentajeVictorias DESC")
    List<Equipo> getConferenceRanking(@Param("conference") String conference);

    @Query("SELECT e FROM Equipo e WHERE e.divisionEquipo like :division ORDER BY e.puestoDivision")
    List<Equipo> getDivisionRanking(@Param("division") String division);
    @Query("SELECT e FROM Equipo e WHERE e.idEquipo = :idEquipo")
    Equipo getTeamById(@Param("idEquipo") int idEquipo);
    @Query("SELECT e\n" +
            "FROM Usuario u INNER JOIN Apoyar a\n" +
            "ON u.idUsuario = a.apoyarId.idUsuario\n" +
            "INNER JOIN Equipo e\n" +
            "ON a.apoyarId.idEquipo = e.idEquipo\n" +
            "where u.idUsuario = :idUsuario")
    List<Equipo> getEquiposApoyados(@Param("idUsuario") int idUsuario);
}
