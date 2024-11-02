package com.diegobermudez.taller_reactivo.presentation.dtos;

public record NotaDTO(
        Integer id,
        Integer materiaId,
        Integer profesorId,
        String cursoCodigo,
        Integer estudianteId,
        Double valor,
        Double porcentaje
){
}
