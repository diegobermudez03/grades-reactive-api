package com.diegobermudez.taller_reactivo.a3_repository;

import com.diegobermudez.taller_reactivo.a3_repository.entities.CursoEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CursoRepository extends R2dbcRepository<CursoEntity, Integer> {
}
