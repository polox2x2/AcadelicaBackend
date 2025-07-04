package com.Acadelica.proyecto.DTO.Categoria;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaCreateDTO {


    @NotBlank(message = "Debes Completar el Campo del nombre")
    private String nombre;

    @NotNull
    private LocalDateTime fechaCreacion;




}
