package com.diegobermudez.taller_reactivo.a1_presentation.controllers;

import com.diegobermudez.taller_reactivo.a1_presentation.dtos.NotaDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class NotaController {

    public Mono<ServerResponse> createNotaForEstudiante(ServerRequest request){
        final Integer estudianteId = Integer.valueOf(request.pathVariable("id"));
        final Mono<NotaDTO> notaDTO = request.bodyToMono(NotaDTO.class);
        return notaDTO.flatMap(nota->ServerResponse.ok().bodyValue(null))
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue("Body invalido"));
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
