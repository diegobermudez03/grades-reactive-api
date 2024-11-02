package com.diegobermudez.taller_reactivo.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EstudianteModel {

    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
}
