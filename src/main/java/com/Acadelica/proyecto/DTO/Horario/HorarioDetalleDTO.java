package com.Acadelica.proyecto.DTO.Horario;


import com.Acadelica.proyecto.Model.Curso;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorarioDetalleDTO {


    private String dia;


    private String horaInicio;


    private String horaFin;


    private Curso curso;
}
