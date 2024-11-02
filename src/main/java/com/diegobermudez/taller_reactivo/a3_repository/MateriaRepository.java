package com.diegobermudez.taller_reactivo.a3_repository;

import com.diegobermudez.taller_reactivo.a3_repository.entities.MateriaEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface MateriaRepository extends R2dbcRepository<MateriaEntity, Integer> {
}
