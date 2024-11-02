package com.diegobermudez.taller_reactivo.presentation.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@AllArgsConstructor     //instead of autowired
@Component
public class EstudianteController {

    public Mono<ServerResponse> getEstudiantesByCurso(ServerRequest request){
        return ServerResponse.ok().bodyValue(null);
    }

    public Mono<ServerResponse> getAllEstudiantes(ServerRequest request){
        return ServerResponse.ok().bodyValue(null);
    }

    public Mono<ServerResponse> updateEstudiante(ServerRequest request){
        return ServerResponse.ok().bodyValue(null);
    }

    public Mono<ServerResponse> deleteEstudiante(ServerRequest request){
        return ServerResponse.ok().bodyValue(null);
    }

    public Mono<ServerResponse> createEstudiante(ServerRequest request){
        return ServerResponse.ok().bodyValue(null);
    }

}
