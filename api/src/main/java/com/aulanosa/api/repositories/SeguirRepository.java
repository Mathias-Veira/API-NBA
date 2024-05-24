package com.aulanosa.api.repositories;

import com.aulanosa.api.models.Jugador;
import com.aulanosa.api.models.Seguir;
import com.aulanosa.api.models.SeguirId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeguirRepository extends JpaRepository<Seguir, SeguirId> {
    @Query("SELECT j FROM Seguir s JOIN Jugador j ON s.seguirId.idJugador = j.idJugador WHERE s.seguirId.idUsuario = :idUsuario")
    List<Jugador> listarJugadoresSeguidos(@Param("idUsuario") int idUsuario);
}
