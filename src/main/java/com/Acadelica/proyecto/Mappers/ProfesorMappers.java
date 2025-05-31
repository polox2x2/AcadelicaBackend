package com.Acadelica.proyecto.Mappers;


import com.Acadelica.proyecto.DTO.Profesor.ProfesorClassDTO;
import com.Acadelica.proyecto.DTO.Profesor.ProfesorCreateDTO;
import com.Acadelica.proyecto.DTO.Profesor.ProfesorDetalleDTO;
import com.Acadelica.proyecto.DTO.Profesor.ProfesorResponseDTO;
import com.Acadelica.proyecto.Model.Profesor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProfesorMappers {


    public static Profesor mapToProfesor (ProfesorCreateDTO createDTO){
        Profesor profesor = new Profesor();
        profesor.setNombre(createDTO.getNombre());
        profesor.setApellido(createDTO.getApellido());
        profesor.setCorreo(createDTO.getCorreo());
        profesor.setClave(createDTO.getClave());
        profesor.setEspecialidad(createDTO.getEspecialidad());
        profesor.setFechaRegistro(LocalDateTime.now());
        return profesor;
    }

    public static ProfesorResponseDTO mapToResponse (Profesor profesor){
        ProfesorResponseDTO responseDTO = new ProfesorResponseDTO();
        responseDTO.setId(profesor.getId());
        responseDTO.setNombre(profesor.getNombre());
        responseDTO.setCorreo(profesor.getCorreo());
        responseDTO.setEspecialidad(profesor.getEspecialidad());
        return  responseDTO;
    }

    public static ProfesorDetalleDTO mapToDetalle (Profesor profesor){
        ProfesorDetalleDTO detalleDTO = new ProfesorDetalleDTO();
        detalleDTO.setId(profesor.getId());
        detalleDTO.setNombre(profesor.getNombre());
        detalleDTO.setApellido(profesor.getApellido());
        detalleDTO.setCorreo(profesor.getCorreo());
        detalleDTO.setClave(profesor.getClave());
        detalleDTO.setEspecialidad(profesor.getEspecialidad());
        detalleDTO.setFecha_Registro(LocalDateTime.now());
        return detalleDTO;
    }

    public static List<ProfesorDetalleDTO> mapList (List<Profesor>profesor){
        return profesor.stream().map(
                ProfesorMappers::mapToDetalle)
                .collect(Collectors.toList());
    }

    public static ProfesorClassDTO mapToClass(Profesor profesor){
        ProfesorClassDTO classDTO = new ProfesorClassDTO();
        classDTO.setNombre(profesor.getNombre());
        classDTO.setApellido(profesor.getApellido());
        classDTO.setEspecialidad(profesor.getEspecialidad());
        return classDTO;
    }
    public static List <ProfesorClassDTO> mapClass(List<Profesor>profesor){
        return profesor.stream().map(
                ProfesorMappers::mapToClass)
                .collect(Collectors.toList());

    }
    public static void upDateProfesor(Profesor profesor, ProfesorDetalleDTO detalleDTO ){
        profesor.setNombre(detalleDTO.getNombre());
        profesor.setApellido(detalleDTO.getApellido());
        profesor.setEspecialidad(detalleDTO.getEspecialidad());
        profesor.setCursos(detalleDTO.getNombreCurso());
    }
    public static void upDateProfesorCorreo(Profesor profesor, ProfesorResponseDTO responseDTO){
        profesor.setCorreo(responseDTO.getCorreo());
        profesor.setClave(responseDTO.getClave());
    }




}
