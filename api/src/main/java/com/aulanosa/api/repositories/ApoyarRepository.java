package com.aulanosa.api.repositories;

import com.aulanosa.api.models.Apoyar;
import com.aulanosa.api.models.ApoyarId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para poder hacer consultas con la tabla Apoyar
 */
@Repository
public interface ApoyarRepository extends JpaRepository<Apoyar, ApoyarId> {
}
