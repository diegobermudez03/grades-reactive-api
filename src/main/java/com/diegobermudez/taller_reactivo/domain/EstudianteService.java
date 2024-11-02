package com.diegobermudez.taller_reactivo.domain;


import com.diegobermudez.taller_reactivo.domain.models.EstudianteModel;
import com.diegobermudez.taller_reactivo.presentation.dtos.EstudianteDTO;
import com.diegobermudez.taller_reactivo.repository.EstudianteRepository;
import com.diegobermudez.taller_reactivo.repository.entities.EstudianteEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class EstudianteService {

    final EstudianteRepository repository;

    public Mono<EstudianteModel> createEstudiante(EstudianteDTO dto){
        return repository.save(
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
}
