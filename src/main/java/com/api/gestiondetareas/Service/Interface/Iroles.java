package com.api.gestiondetareas.Service.Interface;

import java.util.List;

import com.api.gestiondetareas.Model.DTOs.rolDTO;

public interface Iroles {

    public List<rolDTO> getAll();
    public rolDTO getById(Long id);
    public void save(rolDTO rolDTO);
    public rolDTO updateRol(Long id,rolDTO rolDTO);
    public void deleteById(Long id);
    public rolDTO getByName(String nombre);

}
