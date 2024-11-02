package com.diegobermudez.taller_reactivo.a1_presentation.dtos;

import java.time.LocalDate;

public record CursoDTO(
        Integer id,
        Integer materiaId,
        Integer profesorId,
        String codigo,
        LocalDate fechaInicio,
        LocalDate fechaFin
) {
}
