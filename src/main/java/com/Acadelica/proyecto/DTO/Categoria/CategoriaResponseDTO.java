package com.Acadelica.proyecto.DTO.Categoria;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponseDTO {

    private String nombre;
    private LocalDateTime fechaCreacion;

}
