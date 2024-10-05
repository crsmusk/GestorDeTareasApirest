package com.api.gestiondetareas.Service.Interface;
import java.util.List;


import com.api.gestiondetareas.Model.DTOs.tareaDTO;


public interface Itarea  {

  public List<tareaDTO>findAll();

  public List<tareaDTO>findByNombre(String nombre);

  public void save(tareaDTO tareaDTO);

  public void delete(Long id);

  public tareaDTO findById(Long id);

  public List<tareaDTO>findByEstadoIsTrue();

  public List<tareaDTO>findByEstadoIsFalse();

  public tareaDTO update(Long id,tareaDTO tarea);
}
