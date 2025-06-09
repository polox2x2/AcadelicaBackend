package com.Acadelica.proyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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

    @Column(name = "leido", nullable = false)
    private Boolean leido = false;

    @Column(name = "estado", nullable = false)
    private Boolean estado = true;

    @ManyToOne
    @JoinColumn(name = "id_emisor_profesor", nullable = true)
    private Profesor emisorProfesorId;

    @ManyToOne
    @JoinColumn(name = "id_emisor_alumno", nullable = true)
    private Alumno emisorAlumnoId;

    @ManyToOne
    @JoinColumn(name = "id_receptor_profesor", nullable = true)
    private Profesor receptorProfesorId;

    @ManyToOne
    @JoinColumn(name = "id_receptor_alumno", nullable = true)
    private Alumno receptorAlumnoId;

}
