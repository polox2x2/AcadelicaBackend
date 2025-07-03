package com.Acadelica.proyecto.controller;


import com.Acadelica.proyecto.DTO.AgenteIA.ChatRequestDTO;
import com.Acadelica.proyecto.DTO.AgenteIA.ChatResponseDTO;
import com.Acadelica.proyecto.service.ChatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@Slf4j
public class ChatController {
    private final ChatService chatService;


    @PostMapping("/webhook")
    public ResponseEntity<ChatResponseDTO> procesarChat(@Valid @RequestBody ChatRequestDTO request) {

        log.info("Recibida petición de chat: {}", request.getMessage());

        // Validación básica
        if (request.getMessage() == null || request.getMessage().trim().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(new ChatResponseDTO("El mensaje no puede estar vacío"));
        }
        // Limitar longitud del mensaje (opcional pero recomendado)
        if (request.getMessage().length() > 1000) {
            return ResponseEntity.badRequest()
                    .body(new ChatResponseDTO("El mensaje es demasiado largo (máximo 1000 caracteres)"));
        //El id no puede ser nulo
        }if (request.getAlumnoId() == null) {
            return ResponseEntity.badRequest()
                    .body(new ChatResponseDTO("Error: el ID del alumno es obligatorio y no puede ser nulo."));
        }
        // Procesar con n8n
        ChatResponseDTO response = chatService.procesarMensajeConN8N(request);

        log.info("Respuesta enviada al cliente");
        return ResponseEntity.ok(response);
    }

    // Endpoint adicional para health check
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Chat service is running!");
    }
}
