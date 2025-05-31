package com.Acadelica.proyecto.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorMensajeId implements Serializable {
    private Long profesor;
    private Long mensaje;
}
