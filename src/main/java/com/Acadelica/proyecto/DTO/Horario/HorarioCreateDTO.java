package com.Acadelica.proyecto.DTO.Horario;


import com.Acadelica.proyecto.Model.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorarioCreateDTO {

    private String dia;

    private String horaInicio;


    private String horaFin;


    private Curso curso;

    private Long idCurso;
}
