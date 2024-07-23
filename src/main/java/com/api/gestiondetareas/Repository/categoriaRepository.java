package com.api.gestiondetareas.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.gestiondetareas.Model.Entities.categoria;




@Repository
public interface categoriaRepository extends JpaRepository<categoria,Long>{
 
    Optional<categoria>findByNombreCategoria(String nombreCategoria);
    
}