package com.diegobermudez.taller_reactivo.presentation.controllers;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CursoController {

    public Mono<ServerResponse> createCurso(ServerRequest request){
        return ServerResponse.ok().bodyValue(null);
    }

    public Mono<ServerResponse> getAllCursos(ServerRequest request){
        return ServerResponse.ok().bodyValue(null);
    }

    public Mono<ServerResponse> deleteCurso(ServerRequest request){
        return ServerResponse.ok().bodyValue(null);
    }

    public Mono<ServerResponse> updateCurso(ServerRequest request){
        return ServerResponse.ok().bodyValue(null);
    }
}
