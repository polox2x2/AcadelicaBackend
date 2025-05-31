package com.Acadelica.proyecto.DTO.Profesor;


import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorResponseDTO {

    @NotNull
    private Long id;
    @NotNull
    private String nombre;
    @Nonnull
    @Email
    private String correo;
    @Nonnull
    @Size(min = 8,max = 16)
    private String clave;
    @Nonnull
    private String especialidad;
}
