package com.diegobermudez.taller_reactivo.a2_domain;

import com.diegobermudez.taller_reactivo.a1_presentation.dtos.CursoDTO;
import com.diegobermudez.taller_reactivo.a2_domain.models.CursoModel;
import com.diegobermudez.taller_reactivo.a3_repository.CursoRepository;
import com.diegobermudez.taller_reactivo.a3_repository.MateriaRepository;
import com.diegobermudez.taller_reactivo.a3_repository.ProfesorRepository;
import com.diegobermudez.taller_reactivo.a3_repository.entities.CursoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
public class CursoService {
    final CursoRepository cursoRepository;
    final ProfesorRepository profesorRepository;
    final MateriaRepository materiaRepository;

    public Mono<CursoModel> createCurso(CursoDTO curso) {
        return cursoRepository.save(
                CursoEntity.builder()
                        .materiaId(curso.materiaId())
                        .profesorId(curso.profesorId())
                        .codigo(curso.codigo())
                        .fechaInicio(curso.fechaInicio())
                        .fechaFin(curso.fechaFin())
                        .build()
        ).flatMap(this::entitiyToModel);
    }

    public Flux<CursoModel> getAllCursos(){
        return cursoRepository.findAll()
                .flatMap(this::entitiyToModel);
    }

    public Mono<Boolean> deleteCurso(Integer id){
        return cursoRepository.deleteById(id)
                .map(good->true)
                .onErrorComplete(bad->false);
    }

    public Mono<CursoModel> updateCurso(CursoDTO dto, Integer cursoId){
        return cursoRepository.save(CursoEntity.builder()
                .id(cursoId)
                .codigo(dto.codigo())
                .materiaId(dto.materiaId())
                .profesorId(dto.profesorId())
                .fechaInicio(dto.fechaInicio())
                .fechaFin(dto.fechaFin())
                .build())
                .flatMap(this::entitiyToModel);
    }


    public Mono<CursoModel> entitiyToModel(CursoEntity entity){
        return profesorRepository.findById(entity.getProfesorId())
                .zipWith(materiaRepository.findById(entity.getMateriaId()))
                .map(tuple -> {
                    final var profesor = tuple.getT1();
                    final var materia = tuple.getT2();
                    return CursoModel.builder()
                            .id(entity.getId())
                            .fechaFin(entity.getFechaFin())
                            .fechaInicio(entity.getFechaInicio())
                            .codigo(entity.getCodigo())
                            .profesor(profesor)
                            .materia(materia)
                            .build();
                });
    }

}
