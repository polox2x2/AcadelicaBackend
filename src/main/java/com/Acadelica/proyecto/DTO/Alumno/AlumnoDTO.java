package com.Acadelica.proyecto.DTO.Alumno;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO {

    @NotNull
    private String nombre;
    @NotNull
    private String apellido;




}
