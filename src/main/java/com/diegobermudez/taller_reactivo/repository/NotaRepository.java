package com.diegobermudez.taller_reactivo.repository;

import com.diegobermudez.taller_reactivo.repository.entities.NotaEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface NotaRepository extends R2dbcRepository<NotaEntity, Integer> {
}
