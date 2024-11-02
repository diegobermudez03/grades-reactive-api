package com.diegobermudez.taller_reactivo.a1_presentation.controllers;

import com.diegobermudez.taller_reactivo.a2_domain.EstudianteService;
import com.diegobermudez.taller_reactivo.a1_presentation.dtos.EstudianteDTO;
import com.diegobermudez.taller_reactivo.a3_repository.entities.EstudianteEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@AllArgsConstructor     //instead of autowired
@Component
public class EstudianteController {

    final EstudianteService service;

    public Mono<ServerResponse> getEstudiantesByCurso(ServerRequest request){
        final Integer cursoId = Integer.valueOf(request.pathVariable("id"));
        return ok().body(service.getStudentsByCourse(cursoId), EstudianteEntity.class);
    }

    public Mono<ServerResponse> getAllEstudiantes(ServerRequest request) {
        return ok().body(service.getAllEstudiantes(), EstudianteEntity.class);
    }

    public Mono<ServerResponse> updateEstudiante(ServerRequest request){
        final Integer estudianteId = Integer.valueOf(request.pathVariable("id"));
        final Mono<EstudianteDTO> estudianteDTO = request.bodyToMono(EstudianteDTO.class);
        return estudianteDTO.flatMap(estudiante->
                        service.updateEstudiante(estudiante, estudianteId).flatMap(
                                model -> ok().bodyValue(model)
                        )
                )
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue("Cuerpo invalido"));
    }

    public Mono<ServerResponse> deleteEstudiante(ServerRequest request){
        final Integer estudianteId = Integer.valueOf(request.pathVariable("id"));
        return service.deleteEstudiante(estudianteId)
                .flatMap(deleted-> ok().bodyValue(deleted))
                .onErrorResume(e-> ServerResponse.badRequest().bodyValue("No se pudo eliminar"));
    }

    public Mono<ServerResponse> createEstudiante(ServerRequest request){
        final Mono<EstudianteDTO> estudianteDTO = request.bodyToMono(EstudianteDTO.class);
        return estudianteDTO.flatMap(estudiante->
                    service.createEstudiante(estudiante).flatMap(
                            model -> ok().bodyValue(model)
                    )
                )
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue("Cuerpo invalido"));
    }

}
