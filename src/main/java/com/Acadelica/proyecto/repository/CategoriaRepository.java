package com.Acadelica.proyecto.repository;

import com.Acadelica.proyecto.Model.Cateogoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Cateogoria,Long> {
}
