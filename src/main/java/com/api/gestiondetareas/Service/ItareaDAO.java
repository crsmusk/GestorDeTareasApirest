package com.api.gestiondetareas.Service;
import java.util.List;
import java.util.Optional;

import com.api.gestiondetareas.Model.DTOs.tareaDTO;


public interface ItareaDAO  {

  public List<tareaDTO>findAll();

  public Optional<List<tareaDTO>>findByNombre(String nombre);

  public void save(tareaDTO tareaDTO);

  public void delete(Long id);

  public Optional<tareaDTO>findById(Long id);

  public List<tareaDTO>findByEstadoIsTrue();

  public List<tareaDTO>findByEstadoIsFalse();

  public tareaDTO update(Long id,tareaDTO tarea);
}
