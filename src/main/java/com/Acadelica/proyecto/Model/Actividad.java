package com.Acadelica.proyecto.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "actividades")
@AllArgsConstructor
@NoArgsConstructor
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Actividad")
    private Long id;

    @Column(name = "Nombre_Actividad",nullable = false,length = 100)
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Fecha_Entrega")
    private Date fechaEntrega;

    @ManyToOne
    @JoinColumn(name = "id_curso") // FK de la tabla Curso
    private Curso curso;

    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL)
    private List<AlumnoActividad> alumnos;
}
