package com.api.gestiondetareas.Map;

import java.util.List;

import org.springframework.stereotype.Component;

import com.api.gestiondetareas.Model.DTOs.rolDTO;
import com.api.gestiondetareas.Model.Entities.permiso;
import com.api.gestiondetareas.Model.Entities.rol;

@Component
public class rolMapper {
  
    public rolDTO rolToRolDto(rol rol){
        rolDTO rolDt=rolDTO.builder()
        .nombre(rol.getNombre())
        .permisos(rol.getPermisos().stream().map(permisos->permisos.getNombre()).toList())
        .build();
        return rolDt;
    }

    public List<rolDTO> rolsToRolsDto(List<rol>roles){
        return roles.stream().map(this::rolToRolDto).toList();
    }

}
