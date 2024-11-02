package com.diegobermudez.taller_reactivo.a2_domain;


import com.diegobermudez.taller_reactivo.a2_domain.models.EstudianteModel;
import com.diegobermudez.taller_reactivo.a1_presentation.dtos.EstudianteDTO;
import com.diegobermudez.taller_reactivo.a3_repository.EstudianteRepository;
import com.diegobermudez.taller_reactivo.a3_repository.NotaRepository;
import com.diegobermudez.taller_reactivo.a3_repository.entities.EstudianteEntity;
import com.diegobermudez.taller_reactivo.a3_repository.entities.NotaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class EstudianteService {

    final EstudianteRepository estudianteRepository;
    final NotaRepository notaRepository;

    public Mono<EstudianteEntity> createEstudiante(EstudianteDTO dto){
        return estudianteRepository.save(
                EstudianteEntity.builder()
                        .nombre(dto.nombre())
                        .apellido(dto.apellido())
                        .correo(dto.correo())
                        .build()
        );
    }

    public Mono<Boolean> deleteEstudiante(Integer estudianteId){
        return estudianteRepository.deleteById(estudianteId)
                .map(good -> true)
                .onErrorComplete(bad -> false);
    }

    public Mono<EstudianteEntity> updateEstudiante(EstudianteDTO dto, Integer id){
        return estudianteRepository.save(
                EstudianteEntity.builder()
                        .id(id)
                        .nombre(dto.nombre())
                        .apellido(dto.apellido())
                        .correo(dto.correo())
                        .build()
        );
    }

    public Flux<EstudianteEntity> getAllEstudiantes(){
        return estudianteRepository.findAll();
    }

    public Flux<EstudianteEntity> getStudentsByCourse(Integer cursoId){
        final var estudiantes = notaRepository.findAll()
                .filter(nota-> nota.getCursoId() == cursoId)
                .map(NotaEntity::getEstudianteId)
                .distinct();

        return estudianteRepository.findAllById(estudiantes);
    }
}
