package com.diegobermudez.taller_reactivo.a2_domain.models;

import com.diegobermudez.taller_reactivo.a3_repository.entities.EstudianteEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NotaModel {
    private Integer id;
    private CursoModel curso;
    private EstudianteEntity estudiante;
    private String observacion;
    private Double valor;
    private Double porcentaje;
}
