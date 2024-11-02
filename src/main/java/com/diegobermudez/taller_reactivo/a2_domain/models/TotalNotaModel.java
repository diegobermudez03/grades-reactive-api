package com.diegobermudez.taller_reactivo.a2_domain.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TotalNotaModel {

    private Double porcentaje;
    private Double valor;
}
