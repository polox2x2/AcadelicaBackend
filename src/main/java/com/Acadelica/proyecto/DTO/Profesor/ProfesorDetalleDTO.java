package com.Acadelica.proyecto.DTO.Profesor;


import com.Acadelica.proyecto.Model.Curso;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorDetalleDTO {
    @Nonnull
    private Long id;
    @Nonnull
    private String nombre;
    @Nonnull
    private String apellido;
    @Nonnull
    @Email
    private String correo;
    @Nonnull
    @Size(min = 8,max = 16)
    private String clave;
    @Nonnull
    private String especialidad;
    @Nonnull
    private LocalDateTime fecha_Registro;

    private List<Curso> nombreCurso;



}
