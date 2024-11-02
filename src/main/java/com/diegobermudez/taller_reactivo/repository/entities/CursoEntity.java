package com.diegobermudez.taller_reactivo.repository.entities;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Table("curso")
public class CursoEntity {
    @Id
    @Embedded.Nullable
    private CursoKey id;

    @Column("fecha_inicio")
    private LocalDate fechaInicio;

    @Column("fecha_fin")
    private LocalDate fechaFin;


    @Getter
    @Setter
    public class CursoKey implements Serializable{
        @Column("materia_id")
        private Integer materiaId;

        @Column("profesor_id")
        private Integer profesorId;

        private String codigo;
    }

}
