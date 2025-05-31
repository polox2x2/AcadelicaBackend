package com.Acadelica.proyecto.DTO.Alumno;


import com.Acadelica.proyecto.Model.Actividad;
import com.Acadelica.proyecto.Model.Curso;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDetalleDTO {

    @NotNull
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    @Email
    private String correo;
    @NotNull
    private String clave;

    private LocalDateTime fecha_Registro;

    private List<Actividad> nombresActividades;

    private List<Curso> nombreCursos;

}
