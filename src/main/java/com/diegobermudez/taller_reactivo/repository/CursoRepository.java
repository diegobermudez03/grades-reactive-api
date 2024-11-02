package com.diegobermudez.taller_reactivo.repository;

import com.diegobermudez.taller_reactivo.repository.entities.CursoEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CursoRepository extends R2dbcRepository<CursoEntity, CursoEntity.CursoKey> {
}
