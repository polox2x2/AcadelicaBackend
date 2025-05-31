package com.Acadelica.proyecto.repository;

import com.Acadelica.proyecto.Model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje,Long> {
}
