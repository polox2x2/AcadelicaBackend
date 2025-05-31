package com.Acadelica.proyecto.DTO.Alumno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoResponseDTO {


    @NonNull
    private Long id;
    @NonNull
    private String nombre;
    @NonNull
    @Email
    private String correo;
    @NonNull
    @Size(min = 8,max = 16)
    private String clave;

}
