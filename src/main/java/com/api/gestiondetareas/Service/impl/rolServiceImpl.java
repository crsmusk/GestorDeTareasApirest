package com.api.gestiondetareas.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.gestiondetareas.Exception.rolNoEncontradoException;
import com.api.gestiondetareas.Map.rolMapper;
import com.api.gestiondetareas.Model.DTOs.rolDTO;
import com.api.gestiondetareas.Model.Entities.permiso;
import com.api.gestiondetareas.Model.Entities.rol;
import com.api.gestiondetareas.Repository.permisosRepository;
import com.api.gestiondetareas.Repository.rolRepository;
import com.api.gestiondetareas.Service.Interface.Iroles;

@Service
public class rolServiceImpl implements Iroles{
 
    @Autowired
    rolRepository rolRepo;
    @Autowired
    permisosRepository permisosRepo;
    @Autowired
    rolMapper mapper;

    @Override
    public List<rolDTO> getAll() {
        if(rolRepo.findAll().isEmpty()){
            throw new rolNoEncontradoException("no hay roles creados");
        }else{
           
            return mapper.rolsToRolsDto(rolRepo.findAll());
        }
    }

    @Override
    public rolDTO getById(Long id) {
        if (rolRepo.existsById(id)) {
            return mapper.rolToRolDto(rolRepo.findById(id).get());
        }else{
            throw new rolNoEncontradoException("no se encontro el rol con el id "+id);
        }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void save(rolDTO rolDTO) {
       rol rol=new rol();
       rol.setNombre(rolDTO.getNombre().toUpperCase());
       List<permiso>listaPermisos=new ArrayList<>();
       for(String nombre:rolDTO.getPermisos()){
           if (permisosRepo.findByNombreIgnoreCase(nombre).isPresent()) {
              listaPermisos.add(permisosRepo.findByNombreIgnoreCase(nombre).get());
           }else{
            throw new rolNoEncontradoException("no se econtro el permiso con el nombre "+nombre);
           }
       }
       rol.setPermisos(listaPermisos);
       rolRepo.save(rol);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public rolDTO updateRol(Long id, rolDTO rolDTO) {
       if (rolRepo.existsById(id)) {
        rol rol=rolRepo.findById(id).get();
        rol.setNombre(rolDTO.getNombre().toUpperCase());
        List<permiso>listaPermisos=new ArrayList<>();
        for(String nombre:rolDTO.getPermisos()){
            if (permisosRepo.findByNombreIgnoreCase(nombre).isPresent()) {
               listaPermisos.add(permisosRepo.findByNombreIgnoreCase(nombre).get());
            }else{
             throw new rolNoEncontradoException("no se econtro el permiso con el nombre "+nombre);
            }
        }
        rol.setPermisos(listaPermisos);
        rolRepo.save(rol);
        return mapper.rolToRolDto(rol);
       }else{
        throw new rolNoEncontradoException("no se encontro el rol con el id "+id);
       }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(Long id) {
        if (rolRepo.existsById(id)) {
            rolRepo.deleteById(id);
        }else{
            throw new rolNoEncontradoException("no se encontro el rol con el id "+id);
        }
    }

    @Override
    public rolDTO getByName(String nombre) {
       if (rolRepo.findByNombreIgnoreCase(nombre).isPresent()) {
         return mapper.rolToRolDto(rolRepo.findByNombreIgnoreCase(nombre).get());
       }else{
        throw new rolNoEncontradoException("no se encontro el rol con el nombre "+nombre);
       }
    }


}
