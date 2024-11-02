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

    @Column("materia_id")
    private Integer materiaId;

    @Column("profesor_id")
    private Integer profesorId;

    @Column("curso_codigo")
    private  String cursoCodigo;

    @Column("estudiante_id")
    private Integer estudianteId;

    private  String observacion;

    private Double valor;

    private Double porcentaje;
}
