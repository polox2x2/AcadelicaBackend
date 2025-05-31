package com.Acadelica.proyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "alumno_Mensaje")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AlumnoMensajeId.class)
public class AlumnoMensaje {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_mensaje")
    private Mensaje mensaje;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

}
