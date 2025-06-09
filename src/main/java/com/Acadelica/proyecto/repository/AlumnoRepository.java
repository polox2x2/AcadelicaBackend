package com.Acadelica.proyecto.repository;

import com.Acadelica.proyecto.DTO.Alumno.AlumnoDetalleDTO;
import com.Acadelica.proyecto.Model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long> {

    List<Alumno> findByEstadoTrue();
    Optional<Alumno>findByCorreo(String correo);

}
