package com.diegobermudez.taller_reactivo.a1_presentation.dtos;

public record EstudianteDTO(
        Integer id, //can be null if its creating endpoint
        String nombre,
        String apellido,
        String correo
) {
}
