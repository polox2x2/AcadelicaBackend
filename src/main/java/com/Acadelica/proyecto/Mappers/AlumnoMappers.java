package com.Acadelica.proyecto.Mappers;


import com.Acadelica.proyecto.DTO.Alumno.AlumnoCreateDTO;
import com.Acadelica.proyecto.DTO.Alumno.AlumnoDetalleDTO;
import com.Acadelica.proyecto.DTO.Alumno.AlumnoResponseDTO;
import com.Acadelica.proyecto.Model.Alumno;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AlumnoMappers {

//Convertir datos entre objetos (DTO ↔ Entidad)
//usa un mapper para separar datos de entrada/salida
//Los Mappers aíslan esa conversión, manteniendo tu lógica de negocio limpia.


    //convertimos Alumno a DTO
    public static Alumno mapToAlumno(AlumnoCreateDTO dto){
        Alumno alumno = new Alumno();
        alumno.setNombre(dto.getNombre());//setNombre-establece el nombre del alumno , getNombre devuelve el nombre almacenado en el DTO
        alumno.setApellido(dto.getApellido());
        alumno.setCorreo(dto.getCorreo());
        alumno.setClave(dto.getClave());
        alumno.setFecha_Registro(LocalDateTime.now());
        return alumno;
    }
    //convertimos el DTO a Alumno
    public static AlumnoResponseDTO mapToResponseDTO(Alumno alumno){
        AlumnoResponseDTO responseDTO = new AlumnoResponseDTO();
        responseDTO.setId(alumno.getId());
        responseDTO.setNombre(alumno.getNombre());
        responseDTO.setCorreo(alumno.getCorreo());
        responseDTO.setClave(alumno.getClave());
        return responseDTO;

    }

    public static AlumnoDetalleDTO mapToDetalleDTO(Alumno alumno){
        AlumnoDetalleDTO detalleDTO = new AlumnoDetalleDTO();
        detalleDTO.setId(alumno.getId());
        detalleDTO.setNombre(alumno.getNombre());
        detalleDTO.setApellido(alumno.getApellido());
        detalleDTO.setCorreo(alumno.getCorreo());
        detalleDTO.setClave(alumno.getClave());
        detalleDTO.setFecha_Registro(LocalDateTime.now());
        detalleDTO.setNombreCursos(alumno.getCursos());
        detalleDTO.setNombresActividades(alumno.getActividades());
        return detalleDTO ;
    }



    public static List<AlumnoDetalleDTO> mapList(List<Alumno>alumnos) {
        //Convierte la lista de alumnos en un Stream, lo que permite operar sobre los elementos de forma funcional
        return alumnos.stream().map(
                        AlumnoMappers::mapToDetalleDTO) // " :: " referenciamos al metodo sin ejecurtarlo
                .collect(Collectors.toList());
        /*Este metodo convierte una lista de Alumno en una lista de
        AlumnoDetalleDTO, utilizando un mapeo definido en el metodo
        mapToDetalleDTO de la clase AlumnoMappers.
         */

    }

    public static void upDateAlumnoName(Alumno alumno, AlumnoDetalleDTO detalleDTO){
        alumno.setNombre(detalleDTO.getNombre());
        alumno.setApellido(detalleDTO.getApellido());
    }
    public static void upDateAlumnoCorreo(Alumno alumno, AlumnoResponseDTO responseDTO){
        alumno.setCorreo(responseDTO.getCorreo());
        alumno.setClave(responseDTO.getClave());
    }



}
