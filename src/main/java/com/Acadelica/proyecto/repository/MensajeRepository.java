package com.Acadelica.proyecto.repository;

import com.Acadelica.proyecto.Model.Alumno;
import com.Acadelica.proyecto.Model.Mensaje;
import com.Acadelica.proyecto.Model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje,Long> {
    // Para buscar mensajes de profesor como emisor o receptor
    List<Mensaje> findByEmisorProfesorIdOrReceptorProfesorId(Profesor emisor, Profesor receptor);

    // Para buscar mensajes de alumno como emisor o receptor
    List<Mensaje> findByEmisorAlumnoIdOrReceptorAlumnoId(Alumno emisor, Alumno receptor);

}
