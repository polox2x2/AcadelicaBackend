package com.Acadelica.proyecto.DTO.Horario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoHorarioDTO {
    private String horario;
    private String horaInicio;
    private String horaFin;
}
