package com.diegobermudez.taller_reactivo.presentation.controllers;

import com.diegobermudez.taller_reactivo.domain.EstudianteService;
import com.diegobermudez.taller_reactivo.presentation.dtos.EstudianteDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@AllArgsConstructor     //instead of autowired
@Component
public class EstudianteController {

    final EstudianteService service;

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
        final Mono<EstudianteDTO> estudianteDTO = request.bodyToMono(EstudianteDTO.class);
        return estudianteDTO.flatMap(estudiante->
                    service.createEstudiante(estudiante).flatMap(
                            model -> ServerResponse.ok().bodyValue(model)
                    )
                )
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue("Cuerpo invalido"));
    }

}
