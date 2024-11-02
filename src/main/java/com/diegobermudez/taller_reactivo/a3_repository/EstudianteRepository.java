package com.diegobermudez.taller_reactivo.a3_repository;

import com.diegobermudez.taller_reactivo.a3_repository.entities.EstudianteEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface EstudianteRepository extends R2dbcRepository<EstudianteEntity, Integer> {
}
