package com.diegobermudez.taller_reactivo.presentation.dtos;

import java.time.LocalDate;

public record CursoDTO(
        Integer materiaId,
        Integer profesorId,
        String varchar,
        LocalDate fechaInicio,
        LocalDate fechaFin
) {
}
