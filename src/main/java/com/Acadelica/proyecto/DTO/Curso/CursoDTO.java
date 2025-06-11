package com.Acadelica.proyecto.DTO.Curso;


import com.Acadelica.proyecto.DTO.Horario.CursoHorarioDTO;
import com.Acadelica.proyecto.DTO.Profesor.CursoProfesorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CursoDTO {

    private String nombre;
    public String descripcion;
    public Integer duracion;
    public CursoProfesorDTO profesorID;
    public List<CursoHorarioDTO> horarioID;

}
