package com.Acadelica.proyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "mensajes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Mensaje")
    private Long id;

    @Column(name = "Contenido")
    private String contenido;

    @Column(name = "Fecha_Envio")
    private Date fechaEnvio;

    @Column(name = "Estado")
    private Boolean estado;




}
