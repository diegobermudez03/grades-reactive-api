package com.diegobermudez.taller_reactivo.a1_presentation.routers;


import com.diegobermudez.taller_reactivo.a1_presentation.controllers.NotaController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class NotaRouter {

    @Bean
    public RouterFunction<ServerResponse> notaRoutes(NotaController notaController){
        return RouterFunctions
                .route(GET("/notas/{courseId}/{studentId}"), notaController::getNotasFromEstudiante)
                .andRoute(GET("/notas/ponderado/{courseId}/{studentId}"), notaController::getNotaPonderada)
                .andRoute(POST("/notas/{courseId}/{studentId}"), notaController::createNotaForEstudiante)
                .andRoute(DELETE("/notas/{id}"), notaController::deleteNota)
                .andRoute(PATCH("/notas/{id}"), notaController::updateNota);
    }
}
