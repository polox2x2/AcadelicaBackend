package com.Acadelica.proyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "alumno_Actividad")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AlumnoActividadId.class)
public class AlumnoActividad {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_alumno") // FK de la tabla Alumno
    private Alumno alumno;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_actividad") // FK de la tabla Actividad
    private Actividad actividad;

    @Column(name = "Fecha_Realizacion")
    private Date fechaRealizacion;
}
