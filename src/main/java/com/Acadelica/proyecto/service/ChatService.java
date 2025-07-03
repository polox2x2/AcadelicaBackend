package com.Acadelica.proyecto.service;

import com.Acadelica.proyecto.DTO.AgenteIA.ChatRequestDTO;
import com.Acadelica.proyecto.DTO.AgenteIA.ChatResponseDTO;
import com.Acadelica.proyecto.Model.Alumno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class ChatService {

    private final AlumnoService alumnoService;
    private final RestTemplate restTemplate;
    private static final String N8N_WEBHOOK_URL ="https://polox2x2.app.n8n.cloud/webhook/ia-agent";

    public ChatService(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
        this.restTemplate = new RestTemplate();
    }

    public ChatResponseDTO procesarMensajeConN8N (ChatRequestDTO request){
        try{
            Optional<Alumno> alumnoOptional = alumnoService.buscaryConectar(request.getAlumnoId());
            if(alumnoOptional.isEmpty()){
                return new ChatResponseDTO("ID de alumno invalido o inactivo");
            }

            Alumno alumno = alumnoOptional.get();

            log.info("Enviar Mensaje a n8n: {}", request.getMessage());

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, Object> body = Map.of(
                    "message", request.getMessage(),
                    "alumnoId", alumno.getId(),
                    "alumnoNombre", alumno.getNombre() + " " + alumno.getApellido(),
                    "sessionId", alumno.getId(),
                    "timestamp", System.currentTimeMillis(),
                    "source", "Spring-boot-chat",
                    "plataform", "spring-boot"
            );

            HttpEntity<Map<String,Object>> entity = new HttpEntity<>(body, headers);
            ResponseEntity<Map<String,Object>> response = restTemplate.exchange(
                    N8N_WEBHOOK_URL,
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<Map<String,Object>>() {}
            );

            Map<String, Object> responseBody = response.getBody();

            log.info("Respuesta cruda recibida desde n8n: {}", responseBody);

            if (responseBody == null || responseBody.isEmpty()) {
                return new ChatResponseDTO("Sin respuesta del AgenteIA");
            }

            String reply = extraerRespuestaDeN8N(responseBody);

            log.info("Respuesta recibida de n8n: {}", reply);

            return new ChatResponseDTO(reply);

        } catch (Exception e){
            log.error("Error conectando con n8n :{}", e.getMessage(), e);
            return new ChatResponseDTO("Lo siento, Hay problemas técnicos.Intenta de Nuevo");
        }
    }

    private String extraerRespuestaDeN8N(Map<String,Object> responseBody) {
        if (responseBody == null || responseBody.isEmpty()) {
            return "Sin respuesta del AgenteIA";
        }

        List<String> posiblesClaves = List.of("reply", "message", "response", "text", "data", "Respuesta");

        for (String key : posiblesClaves) {
            if (responseBody.containsKey(key)) {
                Object val = responseBody.get(key);
                if (val != null) {
                    if (val instanceof Map) {
                        Map<String, Object> nested = (Map<String, Object>) val;
                        if (nested.containsKey("text")) {
                            return nested.get("text").toString();
                        } else {
                            return val.toString();
                        }
                    }
                    return val.toString();
                }
            }
        }

        return "Respuesta Procesada por IA(formato no reconocido)";
    }
}