package com.Acadelica.proyecto.DTO.Curso;


import com.Acadelica.proyecto.Model.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponseDTO {

    @NotNull
    private String nombre ;
    @NotNull
    private String Descripcion ;
    @NotNull
    private Integer Duracion ;

    private Categoria categoria;
    private Profesor profesor;
    private List<Horario>horarios;
    private List<Actividad>actividad;
    private List<AlumnoCurso>alumnos;

}
