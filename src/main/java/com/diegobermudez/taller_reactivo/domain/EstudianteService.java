package com.diegobermudez.taller_reactivo.domain;


import com.diegobermudez.taller_reactivo.domain.models.EstudianteModel;
import com.diegobermudez.taller_reactivo.presentation.dtos.EstudianteDTO;
import com.diegobermudez.taller_reactivo.repository.EstudianteRepository;
import com.diegobermudez.taller_reactivo.repository.NotaRepository;
import com.diegobermudez.taller_reactivo.repository.entities.EstudianteEntity;
import com.diegobermudez.taller_reactivo.repository.entities.NotaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
@AllArgsConstructor
public class EstudianteService {

    final EstudianteRepository estudianteRepository;
    final NotaRepository notaRepository;

    public Mono<EstudianteModel> createEstudiante(EstudianteDTO dto){
        return estudianteRepository.save(
                EstudianteEntity.builder()
                        .nombre(dto.nombre())
                        .apellido(dto.apellido())
                        .correo(dto.correo())
                        .build()
        ).map(entity->
             EstudianteModel.builder()
                    .id(entity.getId())
                    .apellido(entity.getApellido())
                    .correo(entity.getCorreo())
                    .nombre(entity.getNombre())
                    .build()
        );
    }

    public Mono<Boolean> deleteEstudiante(Integer estudianteId){
        return estudianteRepository.deleteById(estudianteId)
                .map(good -> true)
                .onErrorComplete(bad -> false);
    }

    public Mono<EstudianteModel> updateEstudiante(EstudianteDTO dto, Integer id){
        return estudianteRepository.save(
                EstudianteEntity.builder()
                        .id(id)
                        .nombre(dto.nombre())
                        .apellido(dto.apellido())
                        .correo(dto.correo())
                        .build()
        ).map(entity->
                EstudianteModel.builder()
                        .id(entity.getId())
                        .apellido(entity.getApellido())
                        .correo(entity.getCorreo())
                        .nombre(entity.getNombre())
                        .build()
        );
    }

    public Flux<EstudianteModel> getAllEstudiantes(){
        return estudianteRepository.findAll()
                .map(entity-> EstudianteModel.builder()
                        .id(entity.getId())
                        .apellido(entity.getApellido())
                        .nombre(entity.getNombre())
                        .correo(entity.getCorreo())
                        .build());
    }

    public Flux<EstudianteModel> getStudentsByCourse(Integer cursoId){
        final var estudiantes = notaRepository.findAll()
                .filter(nota-> nota.getCursoId() == cursoId)
                .map(NotaEntity::getEstudianteId)
                .distinct();

        return estudianteRepository.findAllById(estudiantes)
                .map(entity-> EstudianteModel.builder()
                        .id(entity.getId())
                        .apellido(entity.getApellido())
                        .nombre(entity.getNombre())
                        .correo(entity.getCorreo())
                        .build());
    }
}
