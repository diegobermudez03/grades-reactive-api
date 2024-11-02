package com.diegobermudez.taller_reactivo.a1_presentation.routers;


import com.diegobermudez.taller_reactivo.a1_presentation.controllers.CursoController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class CursoRouter {

    @Bean
    public RouterFunction<ServerResponse> cursoRoutes(CursoController cursoController) {
        return RouterFunctions
                .route(POST("/cursos"),cursoController::createCurso)
                .andRoute(GET("/cursos/all"), cursoController::getAllCursos)
                .andRoute(DELETE("/cursos/{id}"), cursoController::deleteCurso)
                .andRoute(PATCH("/cursos/{id}"), cursoController::updateCurso);
    }
}
