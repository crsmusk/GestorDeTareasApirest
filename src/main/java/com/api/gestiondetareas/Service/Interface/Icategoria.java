package com.api.gestiondetareas.Service.Interface;

import java.util.List;

import com.api.gestiondetareas.Model.DTOs.categoriaDTO;





public interface Icategoria {

  public List<categoriaDTO>findAll();

  public categoriaDTO findByNombre(String nombre);

  public void save(categoriaDTO categoria);

  public void delete(Long id);

  public categoriaDTO findById(long id);

  public categoriaDTO update(Long id,categoriaDTO categoriaDTO);
}
