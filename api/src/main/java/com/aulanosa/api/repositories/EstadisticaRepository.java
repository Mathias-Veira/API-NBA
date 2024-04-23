package com.aulanosa.api.repositories;

import com.aulanosa.api.models.Estadistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica,Integer> {
}
