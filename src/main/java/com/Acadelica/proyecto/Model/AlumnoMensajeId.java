package com.Acadelica.proyecto.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoMensajeId implements Serializable {
    private Long alumno;
    private Long mensaje;
}
