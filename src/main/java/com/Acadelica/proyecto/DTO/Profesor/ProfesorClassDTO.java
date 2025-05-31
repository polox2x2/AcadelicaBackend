package com.Acadelica.proyecto.DTO.Profesor;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorClassDTO {

    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String especialidad;
}
