package com.diegobermudez.taller_reactivo.presentation.routers;


import com.diegobermudez.taller_reactivo.presentation.controllers.NotaController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class NotaRouter {

    @Bean
    public RouterFunction<ServerResponse> notasCurso(NotaController notaController){
        return RouterFunctions
                .route(GET("/notas/{studentId}"), notaController::getNotasFromEstudiante)
                .andRoute(POST("/notas/{studentId}"), notaController::createNotaForStudent)
                .andRoute(DELETE("/notas/{id}"), notaController::deleteNota)
                .andRoute(PATCH("/notas/{id}"), notaController::updateNota);
    }
}
