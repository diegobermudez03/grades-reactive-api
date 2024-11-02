package com.diegobermudez.taller_reactivo.repository;

import com.diegobermudez.taller_reactivo.repository.entities.MateriaEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface MateriaRepository extends R2dbcRepository<MateriaEntity, Integer> {
}
