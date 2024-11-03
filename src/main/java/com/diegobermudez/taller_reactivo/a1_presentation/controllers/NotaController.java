package com.diegobermudez.taller_reactivo.a1_presentation.controllers;

import com.diegobermudez.taller_reactivo.a1_presentation.dtos.CursoDTO;
import com.diegobermudez.taller_reactivo.a1_presentation.dtos.NotaDTO;
import com.diegobermudez.taller_reactivo.a2_domain.NotaService;
import com.diegobermudez.taller_reactivo.a2_domain.models.NotaModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
public class NotaController {

    private final NotaService service;

    public Mono<ServerResponse> createNotaForEstudiante(ServerRequest request){
        final Integer cursoId = Integer.valueOf(request.pathVariable("courseId"));
        final Integer estudianteId = Integer.valueOf(request.pathVariable("studentId"));
        final Mono<NotaDTO> notaDTO = request.bodyToMono(NotaDTO.class);
        return notaDTO.flatMap(nota->
                        service.createNotaForStudentInCourse(nota, estudianteId, cursoId)
                                .flatMap(model->ServerResponse.ok().bodyValue(model))
                )
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue("Cuerpo invalido"));
    }

    public Mono<ServerResponse> getNotaPonderada(ServerRequest request){
        final Integer cursoId = Integer.valueOf(request.pathVariable("courseId"));
        final Integer estudianteId = Integer.valueOf(request.pathVariable("studentId"));
        return service.calculateCurrentGrade(cursoId, estudianteId).flatMap(model->ServerResponse.ok().bodyValue(model))
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue("Cuerpo invalido"));
    }

    public Mono<ServerResponse> getNotasFromEstudiante(ServerRequest request){
        final Integer cursoId = Integer.valueOf(request.pathVariable("courseId"));
        final Integer estudianteId = Integer.valueOf(request.pathVariable("studentId"));
        return ServerResponse.ok().body(service.getNotasOfStudentInCourse(estudianteId, cursoId), NotaModel.class);
    }

    public Mono<ServerResponse> updateNota(ServerRequest request){
        final Integer id = Integer.valueOf(request.pathVariable("id"));
        final Mono<NotaDTO> notaDTO = request.bodyToMono(NotaDTO.class);
        return notaDTO.flatMap(nota->
                        service.updateNota(nota, id)
                                .flatMap(model->ServerResponse.ok().bodyValue(model))
                )
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue("Cuerpo invalido"));
    }

    public Mono<ServerResponse> deleteNota(ServerRequest request){
        final Integer id = Integer.valueOf(request.pathVariable("id"));
        return service.deleteNota(id).flatMap(model->ServerResponse.ok().bodyValue(model))
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue("Cuerpo invalido"));
    }
}
