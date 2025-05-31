package com.Acadelica.proyecto.DTO.Alumno;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoCreateDTO {

    @NonNull // Cuando necesitas que un campo sea obligatorio (aunque puede ser vacío "")
    private String nombre;
    @NonNull
    private String apellido;
    @NonNull
    @Email // Para campos de correos electrónicos.
    private String correo;
    @NonNull
    @Size(min = 8 ,max = 16) // Cuando necesitas controlar la longitud o cantidad de elementos.
    private String clave;

}
