package com.Acadelica.proyecto.DTO.Curso;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CursoDTO {

    private String nombre;
    public String descripcion;
    public Integer duracion;
}
