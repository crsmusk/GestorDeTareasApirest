package com.api.gestiondetareas.Map;

import java.util.List;

import org.springframework.stereotype.Component;

import com.api.gestiondetareas.Model.DTOs.permisosDTO;
import com.api.gestiondetareas.Model.Entities.permiso;

@Component
public class permisoMapper {
   
    public permisosDTO permisoTOPermisosDTO(permiso permisos){
        permisosDTO permisosDT=permisosDTO.builder()
        .nombre(permisos.getNombre())
        .build();
        return permisosDT;
    }

    public List<permisosDTO> permisosToPermisosDto(List<permiso>permisos){
        return permisos.stream().map(this::permisoTOPermisosDTO).toList();
    }
}
