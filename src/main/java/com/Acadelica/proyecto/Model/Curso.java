package com.Acadelica.proyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cursos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long id;
    @Column(name = "nombre",nullable = false,length = 100,unique = true)
    private String nombreCurso;
    @Column(name = "descripcion",nullable = false)
    private String descripcion;
    @Column(name = "duracion")
    private Integer duracion;
    @Column(name = "estado")
    private boolean estado =true;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @ManyToOne  // Relación muchos a uno con Categoria
    @JoinColumn(name = "id_categoria")  // FK de la tabla Categoria
    private Categoria categoria;  // La relación con Categoria

    @OneToMany(mappedBy = "curso",cascade = CascadeType.ALL)
    private List<Horario>horarios;
    @OneToMany(mappedBy = "curso",cascade = CascadeType.ALL)
    private List<Actividad>actividades;
    @OneToMany(mappedBy = "curso",cascade = CascadeType.ALL)
    private List<AlumnoCurso>alumnos;
}
