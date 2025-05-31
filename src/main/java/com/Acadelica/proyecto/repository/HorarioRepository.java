package com.Acadelica.proyecto.repository;

import com.Acadelica.proyecto.Model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Long> {
}
