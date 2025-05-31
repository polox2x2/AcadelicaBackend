package com.Acadelica.proyecto.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity //Lo convierte en una Entidad de JPA - equivale a una table en la BD
@Table(name="alumnos") //Le Introducimos un nombre a la tabla
@Data //genera los getter and setter
@NoArgsConstructor // genera los constructores vacios
@AllArgsConstructor //genera los contructores
public class Alumno {

    @Id //Indica que es el ID de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Genera automaticamente el ID
    @Column(name = "id_alumno") //personalizamos el atributo de la tabla
    private Long id;
    @Column(name = "nombre",nullable = false, length = 100)
    private String nombre;
    @Column(name = "apellido",nullable = false,length = 100)
    private String apellido;
    @Column(name = "correo",unique = true)
    @Email//validamos que sea un correo
    private String correo;
    @Column(name = "password")
    @Size(min=8,max = 16)
    private String clave;
    @Column(name = "fecha_registro")
    private LocalDateTime fecha_Registro;
    @Column(name = "estado",nullable = false)
    private boolean estado= true ;
    @ManyToMany
    @JoinTable(
            name = "alumno_curso",  // Nombre de la tabla de relación
            joinColumns = @JoinColumn(name = "id_alumno"),  // FK de la tabla Alumno
            inverseJoinColumns = @JoinColumn(name = "id_curso")  // FK de la tabla Curso
    )
    private List<Curso> cursos;
    @ManyToMany
    @JoinTable(
            name = "Alumno_Actividad",
            joinColumns=@JoinColumn(name = "id_alumno"),
            inverseJoinColumns = @JoinColumn(name = "id_actividad"))
    private List<Actividad> actividades;


}
