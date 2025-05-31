package com.Acadelica.proyecto.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoActividadId implements Serializable {
    private Long alumno;
    private Long actividad;
}
