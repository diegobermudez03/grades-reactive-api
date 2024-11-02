package com.diegobermudez.taller_reactivo.presentation.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class NotaController {

    public Mono<ServerResponse> createNotaForStudent(ServerRequest request){
        return ServerResponse.ok().bodyValue(null);
    }

    public Mono<ServerResponse> getNotasFromEstudiante(ServerRequest request){
        return ServerResponse.ok().bodyValue(null);
    }

    public Mono<ServerResponse> updateNota(ServerRequest request){
        return ServerResponse.ok().bodyValue(null);
    }

    public Mono<ServerResponse> deleteNota(ServerRequest request){
        return ServerResponse.ok().bodyValue(null);
    }
}
