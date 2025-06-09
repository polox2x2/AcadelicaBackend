package com.Acadelica.proyecto.controller;


import com.Acadelica.proyecto.DTO.Mensaje.MensajeDTO;
import com.Acadelica.proyecto.service.MensajeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mensaje")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @PostMapping("/enviar")
    public ResponseEntity<MensajeDTO> enviarMensaje(@Valid @RequestBody MensajeDTO dto) {
        MensajeDTO mensajeCreado = mensajeService.enviarMensaje(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensajeCreado);
    }
    //  Obtener mensajes relacionados a un profesor
    @GetMapping("/profesor/{idProfesor}")
    public List<MensajeDTO> obtenerMensajesPorProfesor(@PathVariable Long idProfesor) {
        return mensajeService.listarMensajesPorProfesor(idProfesor);
    }
    //  Obtener mensajes relacionados a un alumno
    @GetMapping("/alumno/{idAlumno}")
    public ResponseEntity<List<MensajeDTO>> obtenerMensajesAlumno(@PathVariable Long idAlumno) {
        List<MensajeDTO> mensajes = mensajeService.obtenerMensajesPorAlumno(idAlumno);
        return ResponseEntity.ok(mensajes);
    }
    @PutMapping("/{id}/leido")
    public ResponseEntity<Void> marcarComoLeido(@PathVariable Long id) {
        mensajeService.marcarComoLeido(id);
        return ResponseEntity.noContent().build();
    }

}
