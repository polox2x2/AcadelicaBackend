package com.Acadelica.proyecto.DTO.Mensaje;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MensajeRequestDTO {
    @NotBlank(message = "El contenido no puede estar vacío")
    private String contenido;

    // El emisor debe ser o profesor o alumno (uno solo, el otro debe ser null)
    private Long emisorProfesorId;

    private Long emisorAlumnoId;

    // Lo mismo para receptor
    private Long receptorProfesorId;

    private Long receptorAlumnoId;
}

