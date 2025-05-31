package com.Acadelica.proyecto.DTO.Curso;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoCreateDTO {

    @NotBlank(message = "Los datos de Nombre no puedenestar vacios")
    @NotNull
    private String nombre;
    @NotNull
    @NotBlank(message = "Necesita una descipcion")
    private String descripcion;
    @NotNull
    private Integer duracion ;




}
