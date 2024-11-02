package com.diegobermudez.taller_reactivo.a3_repository;

import com.diegobermudez.taller_reactivo.a3_repository.entities.NotaEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface NotaRepository extends R2dbcRepository<NotaEntity, Integer> {
}
