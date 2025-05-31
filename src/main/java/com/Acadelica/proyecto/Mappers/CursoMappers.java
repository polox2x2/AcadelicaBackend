package com.Acadelica.proyecto.Mappers;

import com.Acadelica.proyecto.DTO.Curso.CursoCreateDTO;
import com.Acadelica.proyecto.DTO.Curso.CursoDetalleDTO;
import com.Acadelica.proyecto.DTO.Curso.CursoResponseDTO;
import com.Acadelica.proyecto.Model.Curso;

import java.util.List;
import java.util.stream.Collectors;

public class CursoMappers {


    public static Curso mapToCurso(CursoCreateDTO createDTO){
        Curso curso = new Curso();
        curso.setNombreCurso(createDTO.getNombre());
        curso.setDescripcion(createDTO.getDescripcion());
        curso.setDuracion(createDTO.getDuracion());
        return curso;
    }

    public static CursoResponseDTO mapToResponseDTO (Curso curso){
        CursoResponseDTO responseDTO = new CursoResponseDTO();
            responseDTO.setNombre(curso.getNombreCurso());
            responseDTO.setCateogoria(curso.getCateogoria());
            responseDTO.setDescripcion(curso.getDescripcion());
            responseDTO.setDuracion(curso.getDuracion());

        return responseDTO;
    }
    public static CursoDetalleDTO mapToCursoDetalleDTO(Curso curso){
        CursoDetalleDTO dto = new CursoDetalleDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombreCurso());
        dto.setDescripcion(curso.getDescripcion());
        dto.setDuracion(curso.getDuracion());
        dto.setCateogoria(curso.getCateogoria());
        dto.setAlumnos(curso.getAlumnos());
        dto.setActividades(curso.getActividades());
        dto.setHorarios(curso.getHorarios());
        return dto;
    }

    public static List<CursoDetalleDTO> mapToList(List<Curso>cursos){
        return cursos.stream().map(
                CursoMappers::mapToCursoDetalleDTO).collect(
                            Collectors.toList());
    }

        public static void upDateCurso(Curso curso, CursoDetalleDTO dto){
            curso.setNombreCurso(dto.getNombre());
            curso.setCateogoria(dto.getCateogoria());
            curso.setDuracion(dto.getDuracion());
            curso.setDescripcion(dto.getDescripcion());
        }


}
