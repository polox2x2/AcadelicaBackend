package com.Acadelica.proyecto.Mappers;

import com.Acadelica.proyecto.DTO.Horario.HorarioCreateDTO;
import com.Acadelica.proyecto.DTO.Horario.HorarioDTO;
import com.Acadelica.proyecto.DTO.Horario.HorarioDetalleDTO;
import com.Acadelica.proyecto.DTO.Horario.HorarioResponseDTO;
import com.Acadelica.proyecto.Model.Curso;
import com.Acadelica.proyecto.Model.Horario;

import java.util.List;
import java.util.stream.Collectors;

public class HorarioMappers {


    public static Horario mapToHorario(HorarioCreateDTO dto, Curso curso) {
        Horario horario = new Horario();

        horario.setDia(dto.getDia());
        horario.setHoraInicio(dto.getHoraInicio());
        horario.setHoraFin(dto.getHoraFin());
        horario.setCurso(curso);
        return horario;
    }

    public static HorarioResponseDTO mapToResponse(Horario horario) {
        HorarioResponseDTO dto = new HorarioResponseDTO();
        dto.setDia(horario.getDia());
        dto.setHoraInicio(horario.getHoraInicio());
        dto.setHoraFin(horario.getHoraFin());
        Curso curso = horario.getCurso();
        if (curso != null) {
            dto.setCurso(new HorarioDTO(curso.getNombreCurso()));
        }
        return dto;
    }

    public static HorarioDetalleDTO mapToDetalle (Horario horario){
        HorarioDetalleDTO dto = new HorarioDetalleDTO();
        dto.setId(horario.getId());
        dto.setDia(horario.getDia());
        dto.setHoraInicio(horario.getHoraInicio());
        dto.setHoraFin(horario.getHoraFin());
        dto.setCurso(horario.getCurso());
        return dto;
    }

    public static List<HorarioResponseDTO>mapToListResponse(List<Horario>horarios){
        return horarios.stream().map(
                HorarioMappers::mapToResponse
        ).collect(Collectors.toList());



    }
    public static List<HorarioDetalleDTO>mapToListDetalle(List<Horario>horarios){
        return horarios.stream().map(
                HorarioMappers::mapToDetalle
        ).collect(Collectors.toList());
    }

    public static void upDateHorario(Horario horario , HorarioDetalleDTO dto){
        horario.setId(dto.getId());
        horario.setDia(dto.getDia());
        horario.setHoraInicio(dto.getHoraInicio());
        horario.setHoraFin(dto.getHoraFin());
        horario.setCurso(dto.getCurso());
    }

}