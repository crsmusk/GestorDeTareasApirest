package com.api.gestiondetareas.Servicio;
import java.util.List;
import java.util.Optional;
import com.api.gestiondetareas.Entidades.tarea;
import com.api.gestiondetareas.Entidades.DTO.tareaDTO;
public interface ItareaDAO  {

  public List<tarea>findAll();

  public Optional<tarea>findByNombre(String nombre);

  public void save(tareaDTO tareaDTO);

  public void delete(Long id);

  public Optional<tarea>findById(Long id);

  public List<tarea>findByCategoria(String categoria);

  public List<tarea>findByEstadoIsTrue();

  public List<tarea>findByEstadoIsFalse();

  public tarea update(Long id,tareaDTO tarea);
}
