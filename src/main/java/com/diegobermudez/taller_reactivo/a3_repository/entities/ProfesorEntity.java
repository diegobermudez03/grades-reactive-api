package com.diegobermudez.taller_reactivo.a3_repository.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder    //for builder pattern
@Table("profesor")
public class ProfesorEntity {

    @Id
    private Integer id;

    private String nombre;

    private String apellido;

    private String correo;
}
