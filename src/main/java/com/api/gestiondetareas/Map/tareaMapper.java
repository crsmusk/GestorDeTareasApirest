package com.api.gestiondetareas.Map;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.api.gestiondetareas.Model.DTOs.tareaDTO;
import com.api.gestiondetareas.Model.Entities.tarea;

@Mapper(componentModel = "spring")
public interface tareaMapper {

    @Mappings({
        @Mapping(source = "nombre",target = "nombre"),
        @Mapping(source = "contenido",target = "contenido"),
        @Mapping(source = "estado",target = "estado"),
        @Mapping(source = "fechaLimite",target = "fechaLimite"),
       
    })
    tareaDTO toTareadDto(tarea tarea);
    
    @InheritInverseConfiguration
    @Mappings({
       @Mapping(target = "usuario",ignore = true),
       @Mapping(target = "categoria",ignore = true)
    })
    tarea toTarea(tareaDTO tareadDto);
    
}
