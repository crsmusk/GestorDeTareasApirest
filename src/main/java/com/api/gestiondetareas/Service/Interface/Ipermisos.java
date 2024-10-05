package com.api.gestiondetareas.Service.Interface;

import java.util.List;

import com.api.gestiondetareas.Model.DTOs.permisosDTO;

public interface Ipermisos {
   
    public List<permisosDTO> getAll();
    public permisosDTO getById(Long id);
    public permisosDTO getByNombre(String nombre);
    public void save(permisosDTO permisosDTO);
    public permisosDTO update(Long id,permisosDTO permisosDTO);
    public void deleteById(Long id);
}
