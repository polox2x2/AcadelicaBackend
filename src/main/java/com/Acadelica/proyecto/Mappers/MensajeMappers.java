package com.Acadelica.proyecto.Mappers;


import com.Acadelica.proyecto.DTO.Mensaje.MensajeDTO;
import com.Acadelica.proyecto.DTO.Mensaje.MensajeRequestDTO;
import com.Acadelica.proyecto.Model.Mensaje;

import java.util.Date;

public class MensajeMappers {

    public static Mensaje mapToMensaje(MensajeRequestDTO dto) {
        Mensaje mensaje = new Mensaje();
        mensaje.setContenido(dto.getContenido());
        mensaje.setFechaEnvio(new Date());
        mensaje.setEstado(true);
        mensaje.setLeido(false);
        return mensaje;
    }


    public static MensajeDTO mapToDTO(Mensaje mensaje) {
        if (mensaje == null) return null;

        MensajeDTO dto = new MensajeDTO();
        dto.setId(mensaje.getId());
        dto.setContenido(mensaje.getContenido());
        dto.setFechaEnvio(mensaje.getFechaEnvio());
        dto.setEstado(mensaje.getEstado());
        dto.setLeido(mensaje.getLeido());

        // Los IDs de emisor/receptor deben mapearse desde las entidades relacionadas si están disponibles
        if (mensaje.getEmisorAlumnoId() != null) {
            dto.setEmisorAlumnoId(mensaje.getEmisorAlumnoId().getId());
        }
        if (mensaje.getEmisorProfesorId() != null) {
            dto.setEmisorProfesorId(mensaje.getEmisorProfesorId().getId());
        }
        if (mensaje.getReceptorAlumnoId() != null) {
            dto.setReceptorAlumnoId(mensaje.getReceptorAlumnoId().getId());
        }
        if (mensaje.getReceptorProfesorId() != null) {
            dto.setReceptorProfesorId(mensaje.getReceptorProfesorId().getId());
        }

        return dto;
    }
    public static Mensaje mapToMensaje(MensajeDTO dto) {
        if (dto == null) return null;

        Mensaje mensaje = new Mensaje();
        mensaje.setId(dto.getId());
        mensaje.setContenido(dto.getContenido());
        mensaje.setFechaEnvio(dto.getFechaEnvio());
        mensaje.setEstado(dto.getEstado());
        mensaje.setLeido(dto.getLeido());
        return mensaje;
    }
}
