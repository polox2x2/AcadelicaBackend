package com.Acadelica.proyecto.service;

import com.Acadelica.proyecto.DTO.Horario.HorarioCreateDTO;
import com.Acadelica.proyecto.DTO.Horario.HorarioDetalleDTO;
import com.Acadelica.proyecto.DTO.Horario.HorarioResponseDTO;
import com.Acadelica.proyecto.Mappers.HorarioMappers;
import com.Acadelica.proyecto.Model.Curso;
import com.Acadelica.proyecto.Model.Horario;
import com.Acadelica.proyecto.repository.CursoRepository;
import com.Acadelica.proyecto.repository.HorarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;
    private final CursoRepository cursoRepository;


    public  HorarioService (HorarioRepository horarioRepository,CursoRepository cursoRepository){
        this.horarioRepository = horarioRepository;
        this.cursoRepository=cursoRepository;
    }

    public List<Horario>obtenerHorario(){
        return  horarioRepository.findAll();
    }

    public HorarioResponseDTO crearHorario(HorarioCreateDTO createDTO){
        Curso curso = cursoRepository.findById(createDTO.getIdCurso()).orElseThrow(
                () -> new RuntimeException("No se encontro el Curso")
        );
        Horario horario = HorarioMappers.mapToHorario(createDTO,curso);
        Horario create = horarioRepository.save(horario);
        return HorarioMappers.mapToResponse(create);
    }

    public ResponseEntity<HorarioResponseDTO> createHorario (HorarioCreateDTO createDTO){
        Curso curso = cursoRepository.findById(createDTO.getIdCurso()).orElseThrow(
                () -> new RuntimeException("no se encontro el curso"));
        Horario horario = HorarioMappers.mapToHorario(createDTO,curso);
        Horario create = horarioRepository.save(horario);
        return ResponseEntity.ok(HorarioMappers.mapToResponse(create));
    }

    public  ResponseEntity<List<HorarioResponseDTO>>horarioResponseDTO(List<Horario>horarios){
            return ResponseEntity.ok(HorarioMappers.mapToListResponse(horarios));
    }
    public ResponseEntity<List<HorarioDetalleDTO>>horarioDetalleDTO(List<Horario>horarios){
        return ResponseEntity.ok(HorarioMappers.mapToListDetalle(horarios));

    }
    public Horario upDateHorario (Long id , HorarioDetalleDTO dto){
        Horario horario = horarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No se encontro el Horario")
        );
        HorarioMappers.upDateHorario(horario,dto);
        return horarioRepository.save(horario);
    }

}
