package com.Acadelica.proyecto.DTO.Curso;


import com.Acadelica.proyecto.Model.Actividad;
import com.Acadelica.proyecto.Model.AlumnoCurso;
import com.Acadelica.proyecto.Model.Categoria;
import com.Acadelica.proyecto.Model.Horario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDetalleDTO {


    public Long id;
    public String nombre;
    public String descripcion;
    public Integer duracion;
    private Categoria categoria;
    private List<Horario> horarios;
    private List<Actividad>actividades;
    private List<AlumnoCurso>alumnos;

}
