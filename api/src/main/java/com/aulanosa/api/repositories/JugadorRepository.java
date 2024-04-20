package com.aulanosa.api.repositories;

import com.aulanosa.api.models.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JugadorRepository extends JpaRepository<Jugador,Integer> {
    @Query("SELECT j FROM Jugador j where j.anioDraft>=2003 and j.anioDraft<=2023")
    List<Jugador>listarJugadores();
}
