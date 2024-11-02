package com.diegobermudez.taller_reactivo.repository.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@Table("estudiante")
public class EstudianteEntity {

    @Id
    private Integer id;

    private String nombre;

    private String apellido;

    private String correo;
}
