package com.Acadelica.proyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "horarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Horario")
    private Long id;

    @Column(name = "Dia")
    private String dia;

    @Column(name = "Hora_Inicio")
    private String horaInicio;

    @Column(name = "Hora_Fin")
    private String horaFin;

    @ManyToOne
    @JoinColumn(name = "Id_Curso")
    private Curso curso;
}
