package com.Acadelica.proyecto.DTO.Mensaje;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajeCreateDTO {


    private String contenido;



}
