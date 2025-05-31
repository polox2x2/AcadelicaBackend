package com.Acadelica.proyecto.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="profesores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long Id;
    @Column(name = "nombre",nullable = false,length = 80)
    private String nombre;
    @Column(name = "apellido",nullable = false,length = 80)
    private  String apellido;
    @Column(name = "correo",nullable = false,unique = true)
    @Email
    private  String correo;
    @Column(name = "password")
    @Size(min = 8,max = 16)
    private String clave;
    @Column(name = "especialidad",length = 50,nullable = false)
    private String especialidad;
    @Column(name = "estado",nullable = false)
    private boolean estado=true;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;


    @OneToMany(mappedBy = "profesor",cascade = CascadeType.ALL)
    private List<Curso>cursos;

}
