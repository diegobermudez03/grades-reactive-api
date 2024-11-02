package com.diegobermudez.taller_reactivo.a2_domain.models;

import com.diegobermudez.taller_reactivo.a3_repository.entities.MateriaEntity;
import com.diegobermudez.taller_reactivo.a3_repository.entities.ProfesorEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class CursoModel {
    private Integer id;
    private MateriaEntity materia;
    private ProfesorEntity profesor;
    private String codigo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

}
