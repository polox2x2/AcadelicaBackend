package com.Acadelica.proyecto.DTO.Profesor;


import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorCreateDTO {

    @Nonnull
    private String nombre;
    @Nonnull
    private String apellido;
    @NotNull
    @Email
    private String correo;
    @NotNull
    @Size(min = 8, max = 16)
    private String clave;
    @NotNull
    private String especialidad;



}
