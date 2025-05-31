package com.Acadelica.proyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "alumno_Curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AlumnoCursoId.class)
public class AlumnoCurso {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_alumno") // FK de la tabla Alumno
    private Alumno alumno;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_curso") // FK de la tabla Curso
    private Curso curso;

    @Column(name = "Fecha_Inscripcion")
    private Date fechaInscripcion;
}
