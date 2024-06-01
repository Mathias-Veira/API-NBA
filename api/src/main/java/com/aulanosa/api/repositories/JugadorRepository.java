package com.aulanosa.api.repositories;

import com.aulanosa.api.models.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JugadorRepository extends JpaRepository<Jugador,Integer> {
    /**
     * Este método permite obtener todos los jugadores actuales
     * @return Lista de objetos Jugador con la lista de jugadores actuales
     */
    @Query("SELECT j FROM Jugador j WHERE (j.anioDraft BETWEEN 2003 AND 2023) OR (j.anioDraft = 0)")
    List<Jugador>listarJugadores();

    /**
     * Este método permite obtener un jugador por su id
     * @param idJugador identificador del jugador
     * @return objeto Jugador
     */
    @Query("SELECT j FROM Jugador j WHERE j.idJugador = :idJugador")
    Jugador getPlayerById(@Param("idJugador") int idJugador);
}
