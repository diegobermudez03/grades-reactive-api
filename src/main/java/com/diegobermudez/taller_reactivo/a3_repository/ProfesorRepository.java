package com.diegobermudez.taller_reactivo.a3_repository;

import com.diegobermudez.taller_reactivo.a3_repository.entities.ProfesorEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ProfesorRepository extends R2dbcRepository<ProfesorEntity, Integer> {
}
