package com.Acadelica.proyecto.DTO.Mensaje;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajeDTO {

    private Long id;

    @NotBlank(message = "El contenido no puede estar vacío")
    @Size(max = 500, message = "El contenido no debe superar los 500 caracteres")
    private String contenido;

    private Date fechaEnvio;

    @NotNull(message = "El estado no puede ser nulo")
    private Boolean estado;

    private Boolean leido;

    // Permitir que uno de los dos emisores esté presente
    private Long emisorProfesorId;

    private Long emisorAlumnoId;

    private Long receptorProfesorId;

    private Long receptorAlumnoId;
}
