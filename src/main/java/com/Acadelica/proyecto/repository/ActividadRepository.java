package com.Acadelica.proyecto.repository;

import com.Acadelica.proyecto.Model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad,Long> {
}
