package com.diegobermudez.taller_reactivo.a1_presentation.dtos;

public record NotaDTO(
        Integer id,
        Integer notaId,
        Integer estudianteId,
        Double valor,
        Double porcentaje
){
}
