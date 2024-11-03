package com.diegobermudez.taller_reactivo.a2_domain;

import com.diegobermudez.taller_reactivo.a1_presentation.dtos.NotaDTO;
import com.diegobermudez.taller_reactivo.a2_domain.models.CursoModel;
import com.diegobermudez.taller_reactivo.a2_domain.models.NotaModel;
import com.diegobermudez.taller_reactivo.a2_domain.models.TotalNotaModel;
import com.diegobermudez.taller_reactivo.a3_repository.CursoRepository;
import com.diegobermudez.taller_reactivo.a3_repository.EstudianteRepository;
import com.diegobermudez.taller_reactivo.a3_repository.NotaRepository;
import com.diegobermudez.taller_reactivo.a3_repository.entities.NotaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@AllArgsConstructor
@Component
public class NotaService {

    final NotaRepository notaRepository;
    final CursoService cursoService;
    final CursoRepository cursoRepository;
    final EstudianteRepository estudianteRepository;

    public Flux<NotaModel> getNotasOfStudentInCourse(Integer estudianteId, Integer cursoId){
        return notaRepository.findAll()
                .filter(nota-> Objects.equals(nota.getCursoId(), cursoId))
                .filter(nota-> Objects.equals(nota.getEstudianteId(), estudianteId))
                .flatMap(ent-> entityToModel(ent, false, false));
    }

    public Mono<TotalNotaModel> createNotaForStudentInCourse(NotaDTO notaDTO, Integer estudianteId, Integer cursoId){
        return notaRepository.findAll()
                .filter(curso-> Objects.equals(curso.getCursoId(), cursoId))
                .filter(estudiante -> Objects.equals(estudiante.getEstudianteId(), estudianteId))
                .map(NotaEntity::getPorcentaje)
                .reduce(0d, Double::sum)
                .flatMap(resultado->{
                    if(resultado+notaDTO.porcentaje() <= 100 && notaDTO.valor() <= 5){
                        return notaRepository.save(NotaEntity.builder()
                                .observacion(notaDTO.observacion())
                                .estudianteId(estudianteId)
                                .cursoId(cursoId)
                                .valor(notaDTO.valor())
                                .porcentaje(notaDTO.porcentaje())
                                .build()
                                ).flatMap(s->calculateCurrentGrade(cursoId, estudianteId));
                    }else{
                        return Mono.error(new IllegalArgumentException("El porcentaje o valor son invalidos"));
                    }
                });
    }

    public Mono<TotalNotaModel> updateNota(NotaDTO notaDTO, Integer notaId) {
        return notaRepository.findById(notaId)
                .flatMap((nota) ->
                   notaRepository.save(NotaEntity.builder()
                            .cursoId(nota.getCursoId())
                            .estudianteId(nota.getEstudianteId())
                            .valor(notaDTO.valor())
                             .observacion(notaDTO.observacion())
                            .porcentaje(notaDTO.porcentaje())
                            .id(notaId)
                            .build()).flatMap(n -> calculateCurrentGrade(notaDTO.cursoId(), notaDTO.estudianteId()))
                ).onErrorResume((e) -> {
                    System.out.println(e.getMessage());
                    return Mono.error(new IllegalArgumentException("El porcentaje o valor son invalidos"));
                });
    }


    public Mono<TotalNotaModel> deleteNota(Integer notaId) {
        return notaRepository.findById(notaId)
                .flatMap(notaEntity ->
                        notaRepository.delete(notaEntity)
                                .then(calculateCurrentGrade(notaEntity.getCursoId(), notaEntity.getEstudianteId()))
                )
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No se encontro la nota")));
    }

    public Mono<TotalNotaModel> calculateCurrentGrade(Integer cursoId, Integer estudianteId) {
        Mono<Double> acumulate = notaRepository.findAll()
                .filter(nota -> nota.getCursoId().equals(cursoId))
                .filter(nota -> nota.getEstudianteId().equals(estudianteId))
                .map(nota -> nota.getPorcentaje() * nota.getValor() / 100)
                .reduce(0d, Double::sum);

        Mono<Double> porcentaje = notaRepository.findAll()
                .filter(nota -> nota.getCursoId().equals(cursoId))
                .filter(nota -> nota.getEstudianteId().equals(estudianteId))
                .map(NotaEntity::getPorcentaje)
                .reduce(0d, Double::sum);

        return acumulate.zipWith(porcentaje)
                .map(tuple -> {
                    final double acum = tuple.getT1();
                    final double porc = tuple.getT2();
                    double valor = porc == 0 ? 0 : (acum * 100) / porc;

                    return TotalNotaModel.builder()
                            .porcentaje(porc)
                            .valor(valor)
                            .build();
                });
    }


    public Mono<NotaModel> entityToModel(NotaEntity entity, Boolean mostrarCurso, Boolean mostrarEstudiante) {
        return cursoRepository.findById(entity.getCursoId())
                .flatMap(cursoService::entitiyToModel)
                .zipWith(estudianteRepository.findById(entity.getEstudianteId()))
                .map(tuple->{
                    final var curso = mostrarCurso ? tuple.getT1() : null;
                    final var estudiante = mostrarEstudiante ? tuple.getT2() : null;
                    return NotaModel.builder()
                            .id(entity.getId())
                            .estudiante(estudiante)
                            .curso(curso)
                            .observacion(entity.getObservacion())
                            .porcentaje(entity.getPorcentaje())
                            .valor(entity.getValor())
                            .build();
                });
    }
}
