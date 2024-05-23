package com.aulanosa.api.repositories;

import com.aulanosa.api.models.Seguir;
import com.aulanosa.api.models.SeguirId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguirRepository extends JpaRepository<Seguir, SeguirId> {
}
