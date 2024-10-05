package com.api.gestiondetareas.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.api.gestiondetareas.Exception.permisoNoEncontroException;
import com.api.gestiondetareas.Map.permisoMapper;
import com.api.gestiondetareas.Model.DTOs.permisosDTO;
import com.api.gestiondetareas.Model.Entities.permiso;
import com.api.gestiondetareas.Repository.permisosRepository;
import com.api.gestiondetareas.Service.Interface.Ipermisos;

@Service
public class permisoServiceImpl implements Ipermisos {
  
    @Autowired
    permisosRepository permisosRepo;
    
    @Autowired
    permisoMapper mapper;

    @Override
    public List<permisosDTO> getAll() {
       if (permisosRepo.findAll().isEmpty()) {
        throw new permisoNoEncontroException("no hay permisos");
       }else{
        return mapper.permisosToPermisosDto(permisosRepo.findAll());
       }
    }

    @Override
    public permisosDTO getById(Long id) {
        if (permisosRepo.existsById(id)) {
            return mapper.permisoTOPermisosDTO(permisosRepo.findById(id).get());
        }else{
            throw new permisoNoEncontroException("no se encontro el permiso con el id "+id);
        }
    }

    @Override
    public permisosDTO getByNombre(String nombre) {
        if (permisosRepo.findByNombreIgnoreCase(nombre).isPresent()) {
            return mapper.permisoTOPermisosDTO(permisosRepo.findByNombreIgnoreCase(nombre).get());
        }else{
            throw new permisoNoEncontroException("no se econtro el permiso con el nombre "+nombre);
        }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void save(permisosDTO permisosDTO) {
        permiso permiso=new permiso();
        permiso.setNombre(permisosDTO.getNombre());
        permisosRepo.save(permiso);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public permisosDTO update(Long id, permisosDTO permisosDTO) {
       if (permisosRepo.existsById(id)) {
        permiso permiso=permisosRepo.findById(id).get();
        permiso.setNombre(permisosDTO.getNombre());
        permisosRepo.save(permiso);
        return mapper.permisoTOPermisosDTO(permiso);
       }else{
        throw new permisoNoEncontroException("no se encontro el permiso con el id "+id);
       }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(Long id) {
        if (permisosRepo.existsById(id)) {
            permisosRepo.deleteById(id);
        }else{
            throw new permisoNoEncontroException("no se encontro el permiso con el id "+id);
        }
    }

}
