package com.Acadelica.proyecto.DTO.Horario;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorarioResponseDTO {

    private String dia;


    private String horaInicio;


    private String horaFin;

    private HorarioDTO Curso;

}
