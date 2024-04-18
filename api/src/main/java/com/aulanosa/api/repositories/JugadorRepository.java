package com.aulanosa.api.repositories;

import com.aulanosa.api.models.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador,Integer> {
}
