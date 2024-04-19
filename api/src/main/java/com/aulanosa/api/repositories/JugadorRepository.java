package com.aulanosa.api.repositories;

import com.aulanosa.api.models.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador,Integer> {
    @Query("SELECT * FROM Jugador where anioDraft>=2003 and anioDraft<=2023")
    List<Jugador>listarJugadores();
}
