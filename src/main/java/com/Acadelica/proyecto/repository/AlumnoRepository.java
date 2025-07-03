package com.Acadelica.proyecto.repository;


import com.Acadelica.proyecto.Model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long> {

    List<Alumno> findByEstadoTrue();
    Optional<Alumno>findByCorreo(String correo);

    // Verificar si existe y está activo
    boolean existsByIdAndEstadoTrue(Long id);

    // Actualizar última conexión
    @Modifying
    @Query("UPDATE Alumno a SET a.ultimaConexion = :fecha WHERE a.id = :id")
    void actualizarUltimaConexion(@Param("id") Long id, @Param("fecha") LocalDateTime fecha);
}
