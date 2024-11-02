package com.diegobermudez.taller_reactivo.a1_presentation.dtos;

public record NotaDTO(
        Integer id,
        Integer cursoId,
        Integer estudianteId,
        String observacion,
        Double valor,
        Double porcentaje
){
}
