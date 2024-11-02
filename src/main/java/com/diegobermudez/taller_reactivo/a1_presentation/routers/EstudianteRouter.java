package com.diegobermudez.taller_reactivo.a1_presentation.routers;


import com.diegobermudez.taller_reactivo.a1_presentation.controllers.EstudianteController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class EstudianteRouter {

    @Bean
    public RouterFunction<ServerResponse> estudianteRoutes(EstudianteController estudianteController){
        return RouterFunctions
                .route(GET("/estudiantes/byCurso/{id}"), estudianteController::getEstudiantesByCurso)
                .andRoute(GET("/estudiantes/all"), estudianteController::getAllEstudiantes)
                .andRoute(PATCH("/estudiantes/{id}"), estudianteController::updateEstudiante)
                .andRoute(DELETE("/estudiantes/{id}"), estudianteController::deleteEstudiante)
                .andRoute(POST("/estudiantes"), estudianteController::createEstudiante);

    }
}
