package com.Acadelica.proyecto.DTO.Curso;


import com.Acadelica.proyecto.Model.Actividad;
import com.Acadelica.proyecto.Model.AlumnoCurso;
import com.Acadelica.proyecto.Model.Cateogoria;
import com.Acadelica.proyecto.Model.Horario;
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

    private Cateogoria cateogoria;

    private List<Horario>horarios;
    private List<Actividad>actividad;
    private List<AlumnoCurso>alumnos;

}
