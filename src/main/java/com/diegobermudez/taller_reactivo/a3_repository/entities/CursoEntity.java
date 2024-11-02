package com.diegobermudez.taller_reactivo.a3_repository.entities;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Table("curso")
public class CursoEntity {
    @Id
    private Integer id;

    @Column("materia_id")
    private Integer materiaId;

    @Column("profesor_id")
    private Integer profesorId;

    private String codigo;

    @Column("fecha_inicio")
    private LocalDate fechaInicio;

    @Column("fecha_fin")
    private LocalDate fechaFin;

}
