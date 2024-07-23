package com.api.gestiondetareas.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestiondetareas.Exception.categoriaNoEncontradaException;
import com.api.gestiondetareas.Map.categoriaMapper;
import com.api.gestiondetareas.Model.DTOs.categoriaDTO;
import com.api.gestiondetareas.Model.Entities.categoria;
import com.api.gestiondetareas.Repository.categoriaRepository;
import com.api.gestiondetareas.Service.IcategoriaDAO;

@Service
public class categoriaServiceImpl implements IcategoriaDAO{

    @Autowired
    categoriaRepository categoriaRepo;

    @Autowired
    categoriaMapper mapper;

    

    @Override
    public List<categoriaDTO> findAll() {
        
        List<categoriaDTO>lista=categoriaRepo.findAll().stream().map(categoria->categoriaDTO.builder()
        .nombreCategoria(categoria.getNombreCategoria())
        .build()).toList();
        return lista;
    }


    @Override
    public Optional<categoriaDTO> findByNombre(String nombre) {
        categoria category=categoriaRepo.findByNombreCategoria(nombre).orElseThrow(()-> new categoriaNoEncontradaException("no se encontro la categoria con el nombre"+nombre));
        categoriaDTO categoria=categoriaDTO.builder()
        .nombreCategoria(category.getNombreCategoria())
        .build();
        return Optional.of(categoria);
    }


    @Override
    public void save(categoriaDTO categoria) {
        categoria categorias = new categoria();
        categorias=mapper.toCategoria(categoria);
        categoriaRepo.save(categorias);
    }


    @Override
    public void delete(Long id) {
        categoriaRepo.deleteById(id);
    }


    @Override
    public Optional<categoriaDTO> findById(long id) {
       categoria category=categoriaRepo.findById(id).orElseThrow(()-> new categoriaNoEncontradaException("no se encontro la categoria con el id"+id));
       categoriaDTO categoria=categoriaDTO.builder()
       .nombreCategoria(category.getNombreCategoria())
       .build();
       return Optional.of(categoria);
    }

    @Override
    public categoriaDTO update(Long id, categoriaDTO categoriaDT) {
        categoria categoria=categoriaRepo.findById(id).orElseThrow(()->new categoriaNoEncontradaException("no se encontro la categoria con el id"+id));
        categoria.setNombreCategoria(categoriaDT.getNombreCategoria());
        categoriaRepo.save(categoria);
        
        categoriaDTO category=categoriaDTO.builder()
        .nombreCategoria(categoria.getNombreCategoria())
        .build();
        return category;
    }

}
