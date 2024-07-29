package com.api.gestiondetareas.Map;


import java.util.List;

import org.springframework.stereotype.Component;

import com.api.gestiondetareas.Model.DTOs.categoriaDTO;

import com.api.gestiondetareas.Model.Entities.categoria;



@Component
public class categoriaMapper {

  public categoriaDTO toCategoriaDto (categoria categoria){
   return categoriaDTO.builder()
   .nombreCategoria(categoria.getNombreCategoria())
   .build();
  }
  public List<categoriaDTO>toCategoriasDto(List<categoria>categorias){
   return categorias.stream().map(this::toCategoriaDto).toList();
  }

  public categoria toCategoria(categoriaDTO categoriaDTO){
   categoria categoria=new categoria();
   categoria.setNombreCategoria(categoriaDTO.getNombreCategoria());
   return categoria;
  }
}
