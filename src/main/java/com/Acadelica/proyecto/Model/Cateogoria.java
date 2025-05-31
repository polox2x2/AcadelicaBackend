package com.Acadelica.proyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table (name = "categorias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cateogoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Categoria")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Fecha_Creacion")
    private Date fechaCreacion;

}
