package com.Acadelica.proyecto.Mappers;

import com.Acadelica.proyecto.DTO.Categoria.CategoriaDTO;
import com.Acadelica.proyecto.DTO.Curso.*;
import com.Acadelica.proyecto.DTO.Horario.CursoHorarioDTO;
import com.Acadelica.proyecto.DTO.Profesor.CursoProfesorDTO;
import com.Acadelica.proyecto.Model.Categoria;
import com.Acadelica.proyecto.Model.Curso;
import com.Acadelica.proyecto.Model.Horario;
import com.Acadelica.proyecto.Model.Profesor;

import java.util.List;
import java.util.stream.Collectors;

public class CursoMappers {


    public static Curso mapToCurso(CursoCreateDTO createDTO, Categoria categoria){
        Curso curso = new Curso();
        curso.setNombreCurso(createDTO.getNombre());
        curso.setDescripcion(createDTO.getDescripcion());
        curso.setDuracion(createDTO.getDuracion());
        curso.setCategoria(categoria);
        return curso;
    }
    public static CursoDTO mapToCursoDTO(Curso curso){
        CursoDTO dto = new CursoDTO();
        dto.setNombre(curso.getNombreCurso());
        dto.setDescripcion(curso.getDescripcion());
        dto.setDuracion(curso.getDuracion());
        Profesor profesor = curso.getProfesor();
        if(profesor !=null){
            dto.setProfesorID(new CursoProfesorDTO(profesor.getNombre()));
        }
        if (curso.getHorarios() != null && !curso.getHorarios().isEmpty()) {
            List<CursoHorarioDTO> horariosDTO = curso.getHorarios().stream()
                    .map(h -> new CursoHorarioDTO(h.getDia(), h.getHoraInicio(), h.getHoraFin()))
                    .collect(Collectors.toList());
            dto.setHorarioID(horariosDTO);
        }
        return dto;
    }


    public static CursoResponseDTO mapToResponseDTO (Curso curso){
        CursoResponseDTO responseDTO = new CursoResponseDTO();
            responseDTO.setNombre(curso.getNombreCurso());
            responseDTO.setDescripcion(curso.getDescripcion());
            responseDTO.setDuracion(curso.getDuracion());
            responseDTO.setAlumnos(curso.getAlumnos());
            responseDTO.setHorarios(curso.getHorarios());
            responseDTO.setActividad(curso.getActividades());
            Categoria categoria = curso.getCategoria();
            if(categoria !=null){
                responseDTO.setCategoriaDTO(new CategoriaDTO(categoria.getNombre()));
            }
        return responseDTO;
    }
    public static CursoDetalleDTO mapToCursoDetalleDTO(Curso curso){
        CursoDetalleDTO dto = new CursoDetalleDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombreCurso());
        dto.setDescripcion(curso.getDescripcion());
        dto.setDuracion(curso.getDuracion());
        dto.setCategoria(curso.getCategoria());
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
    public static List<CursoDTO>mapToListDTO(List<Curso>cursos){
        return cursos.stream().map(
                CursoMappers::mapToCursoDTO
        ).collect(Collectors.toList());
    }

    public static List<CursoResponseDTO>mapToListResponse(List<Curso>cursos){
        return cursos.stream().map(
                CursoMappers::mapToResponseDTO
        ).collect(Collectors.toList());
    }

        public static void upDateCurso(Curso curso, CursoDetalleDTO dto){
            curso.setNombreCurso(dto.getNombre());
            curso.setCategoria(dto.getCategoria());
            curso.setDuracion(dto.getDuracion());
            curso.setDescripcion(dto.getDescripcion());
        }

    public static void updateCursoFromDTO(Curso curso, CursoDTO dto, Profesor profesor) {
        curso.setNombreCurso(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setDuracion(dto.getDuracion());
        curso.setProfesor(profesor);

        // Limpiar horarios actuales antes de agregar los nuevos
        curso.getHorarios().clear();

        if (dto.getHorarioID() != null && !dto.getHorarioID().isEmpty()) {
            List<Horario> nuevosHorarios = dto.getHorarioID().stream()
                    .map(h -> {
                        Horario horario = new Horario();
                        horario.setDia(h.getHorario()); // O usa getHoraInicio() si lo tienes
                        horario.setCurso(curso);
                        return horario;
                    }).collect(Collectors.toList());

            curso.setHorarios(nuevosHorarios);
        }
    }

}
