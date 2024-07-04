package com.api.gestiondetareas.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.gestiondetareas.Entidades.tarea;
import java.util.List;


public interface tareaRepository  extends JpaRepository<tarea,Long>{
  Optional<tarea>findByNombre(String nombre);
  List<tarea>findByCategoria(String categoria);
  @Query("SELECT t FROM tarea t WHERE t.estado = true")
    List<tarea> encontrarTareasCompletadas();

    @Query("SELECT t FROM tarea t WHERE t.estado = false")
    List<tarea> encontrarTareasNoCompletadas();
  
}
