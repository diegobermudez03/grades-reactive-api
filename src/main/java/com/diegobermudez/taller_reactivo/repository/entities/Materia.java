package com.diegobermudez.taller_reactivo.repository.entities;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder    //for builder pattern
@Table("materia")
public class Materia {

    @Id
    private Integer id;

    private String nombre;

    private Integer creditos;
}
