package com.api.gestiondetareas.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.gestiondetareas.Model.Entities.tarea;

import java.util.List;

@Repository
public interface tareaRepository  extends JpaRepository<tarea,Long>{
  
   Optional<List<tarea>>findByNombreIgnoreCase(String nombre);

    Optional<List<tarea>>findByNombre(String nombre);

    List<tarea> findAllByEstadoTrueOrderByFechaLimite();

    List<tarea> findAllByEstadoFalseOrderByFechaLimite();
  
}
