package com.diegobermudez.taller_reactivo.repository.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@Table("nota")
public class NotaEntity {

    @Id
    private Integer id;

    @Column("curso_id")
    private Integer cursoId;

    @Column("estudiante_id")
    private Integer estudianteId;

    private  String observacion;

    private Double valor;

    private Double porcentaje;
}
