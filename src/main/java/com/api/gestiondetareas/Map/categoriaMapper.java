package com.api.gestiondetareas.Map;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.gestiondetareas.Model.DTOs.categoriaDTO;

import com.api.gestiondetareas.Model.Entities.categoria;



@Mapper(componentModel = "spring")
public interface categoriaMapper {

   @Mapping(source = "nombreCategoria",target = "nombreCategoria")
   categoriaDTO toCategoriaDTO(categoria categoria);
   
   @InheritInverseConfiguration
   @Mapping(target = "tareas",ignore = true)
   categoria toCategoria(categoriaDTO categoriaDTO);
}
