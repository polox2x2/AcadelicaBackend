package com.Acadelica.proyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "profesor_mensaje")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ProfesorMensajeId.class)
public class ProfesorMensaje {


    @Id
    @ManyToOne
    @JoinColumn(name = "id_profesor") // FK de la tabla Profesor
    private Profesor profesor;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_mensaje") // FK de la tabla Mensaje
    private Mensaje mensaje;

    @Column(name = "fecha_Registro")
    private Date fechaRegistro;
}
