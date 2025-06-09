package com.Acadelica.proyecto.service;

import com.Acadelica.proyecto.DTO.Mensaje.MensajeDTO;
import com.Acadelica.proyecto.Mappers.MensajeMappers;
import com.Acadelica.proyecto.Model.Alumno;
import com.Acadelica.proyecto.Model.Mensaje;
import com.Acadelica.proyecto.Model.Profesor;
import com.Acadelica.proyecto.repository.AlumnoRepository;
import com.Acadelica.proyecto.repository.MensajeRepository;
import com.Acadelica.proyecto.repository.ProfesorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MensajeService {

    private final MensajeRepository mensajeRepository;
    private final AlumnoRepository alumnoRepository;
    private final ProfesorRepository profesorRepository;

    // Enviar mensaje
    @Transactional
    public MensajeDTO enviarMensaje(MensajeDTO dto) {
        Mensaje mensaje = MensajeMappers.mapToMensaje(dto);
        mensaje.setFechaEnvio(new Date());
        mensaje.setEstado(true);
        mensaje.setLeido(false);
        // Asignar emisor y receptor según IDs
        if (dto.getEmisorAlumnoId() != null) {
            Alumno emisor = alumnoRepository.findById(dto.getEmisorAlumnoId())
                    .orElseThrow(() -> new RuntimeException("Alumno emisor no encontrado"));
            mensaje.setEmisorAlumnoId(emisor);
        }
        if (dto.getEmisorProfesorId() != null) {
            Profesor emisor = profesorRepository.findById(dto.getEmisorProfesorId())
                    .orElseThrow(() -> new RuntimeException("Profesor emisor no encontrado"));
            mensaje.setEmisorProfesorId(emisor);
        }
        if (dto.getReceptorAlumnoId() != null) {
            Alumno receptor = alumnoRepository.findById(dto.getReceptorAlumnoId())
                    .orElseThrow(() -> new RuntimeException("Alumno receptor no encontrado"));
            mensaje.setReceptorAlumnoId(receptor);
        }

        if (dto.getReceptorProfesorId() != null) {
            Profesor receptor = profesorRepository.findById(dto.getReceptorProfesorId())
                    .orElseThrow(() -> new RuntimeException("Profesor receptor no encontrado"));
            mensaje.setReceptorProfesorId(receptor);
        }

        Mensaje guardado = mensajeRepository.save(mensaje);
        return MensajeMappers.mapToDTO(guardado);
    }

    // Listar mensajes por profesor
    public List<MensajeDTO> listarMensajesPorProfesor(Long idProfesor) {
        Profesor profesor = profesorRepository.findById(idProfesor)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        List<Mensaje> mensajes = mensajeRepository.findByEmisorProfesorIdOrReceptorProfesorId(profesor, profesor);
        return mensajes.stream()
                .map(MensajeMappers::mapToDTO)
                .collect(Collectors.toList());
    }
    //listar mensaje por Alumno
    public List<MensajeDTO> obtenerMensajesPorAlumno(Long idAlumno) {
        Alumno alumno = alumnoRepository.findById(idAlumno)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        List<Mensaje> mensajes = mensajeRepository.findByEmisorAlumnoIdOrReceptorAlumnoId(alumno, alumno);

        return mensajes.stream()
                .map(MensajeMappers::mapToDTO)
                .collect(Collectors.toList());
    }


    // Marcar mensaje como leído
    public void marcarComoLeido(Long idMensaje) {
        Optional<Mensaje> mensajeOpt = mensajeRepository.findById(idMensaje);
        if (mensajeOpt.isPresent()) {
            Mensaje mensaje = mensajeOpt.get();
            mensaje.setLeido(true);
            mensajeRepository.save(mensaje);
        } else {
            throw new RuntimeException("Mensaje no encontrado");
        }
    }

}
