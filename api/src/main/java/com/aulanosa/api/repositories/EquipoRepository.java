package com.aulanosa.api.repositories;

import com.aulanosa.api.models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EquipoRepository extends JpaRepository<Equipo,Integer> {
    /**
     * Este método permite obtener la clasificación general de la liga
     * @return lista de objetos Equipo con la clasificación general de la liga
     */
    @Query("SELECT e FROM Equipo e ORDER BY e.porcentajeVictorias DESC")
    List<Equipo> getLeagueRanking();

    /**
     * Este método permite obtener la clasificación de la conferencia
     * @param conference conferencia de la que queramos saber la clasificación
     * @return lista de objetos Equipo con la clasificación de la conferencia que se pasa por parámetro
     */
    @Query("SELECT e FROM Equipo e WHERE e.conferenciaEquipo like :conference ORDER BY e.porcentajeVictorias DESC")
    List<Equipo> getConferenceRanking(@Param("conference") String conference);

    /**
     * Este método permite obtener la clasificación de la división
     * @param division división de la que queramos saber la clasificación
     * @return lista de objetos Equipo con la clasificación de la división que se pasa por parámetro
     */
    @Query("SELECT e FROM Equipo e WHERE e.divisionEquipo like :division ORDER BY e.puestoDivision")
    List<Equipo> getDivisionRanking(@Param("division") String division);

    /**
     * Este método permite obtener un equipo por su id
     * @param idEquipo identificador del equipo
     * @return un objeto Equipo
     */
    @Query("SELECT e FROM Equipo e WHERE e.idEquipo = :idEquipo")
    Equipo getTeamById(@Param("idEquipo") int idEquipo);

    /**
     * Este método permite obtener una lista de objetos Equipo con los equipos apoyados por un usuario
     * @param idUsuario identificador del usuario
     * @return lista de objetos Equipo con los equipos que apoya un usuario
     */
    @Query("SELECT e\n" +
            "FROM Usuario u INNER JOIN Apoyar a\n" +
            "ON u.idUsuario = a.apoyarId.idUsuario\n" +
            "INNER JOIN Equipo e\n" +
            "ON a.apoyarId.idEquipo = e.idEquipo\n" +
            "where u.idUsuario = :idUsuario")
    List<Equipo> getEquiposApoyados(@Param("idUsuario") int idUsuario);
}
