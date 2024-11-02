package com.diegobermudez.taller_reactivo.a1_presentation.controllers;


import com.diegobermudez.taller_reactivo.a1_presentation.dtos.CursoDTO;
import com.diegobermudez.taller_reactivo.a1_presentation.dtos.EstudianteDTO;
import com.diegobermudez.taller_reactivo.a2_domain.CursoService;
import com.diegobermudez.taller_reactivo.a2_domain.models.CursoModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@AllArgsConstructor
@Component
public class CursoController {

    final CursoService service;

    public Mono<ServerResponse> createCurso(ServerRequest request){
        final Mono<CursoDTO> cursoDTO = request.bodyToMono(CursoDTO.class);
        return cursoDTO.flatMap(curso->
                        service.createCurso(curso).flatMap(
                                model -> ok().bodyValue(model)
                        )
                )
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue("Cuerpo invalido"));
    }

    public Mono<ServerResponse> getAllCursos(ServerRequest request){
        return ServerResponse.ok().body(service.getAllCursos(), CursoModel.class);
    }

    public Mono<ServerResponse> deleteCurso(ServerRequest request){
        final Integer cursoId = Integer.valueOf(request.pathVariable("id"));
        return ServerResponse.ok().body(service.deleteCurso(cursoId), Boolean.class);
    }

    public Mono<ServerResponse> updateCurso(ServerRequest request){
        final Integer cursoId = Integer.valueOf(request.pathVariable("id"));
        final Mono<CursoDTO> cursoDTO = request.bodyToMono(CursoDTO.class);
        return cursoDTO.flatMap(curso->
                        service.updateCurso(curso, cursoId).flatMap(
                                model -> ok().bodyValue(model)
                        )
                )
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue("Cuerpo invalido"));
    }
}
