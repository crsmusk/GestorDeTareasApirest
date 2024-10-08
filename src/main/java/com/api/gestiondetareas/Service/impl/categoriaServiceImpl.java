package com.api.gestiondetareas.Service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestiondetareas.Exception.categoriaNoEncontradaException;
import com.api.gestiondetareas.Map.categoriaMapper;
import com.api.gestiondetareas.Model.DTOs.categoriaDTO;
import com.api.gestiondetareas.Model.Entities.categoria;
import com.api.gestiondetareas.Repository.categoriaRepository;
import com.api.gestiondetareas.Service.Interface.Icategoria;

@Service
public class categoriaServiceImpl implements Icategoria{

    @Autowired
    categoriaRepository categoriaRepo;

    @Autowired
    categoriaMapper mapper;

    

    @Override
    public List<categoriaDTO> findAll() {
        List<categoriaDTO>lista=mapper.toCategoriasDto(categoriaRepo.findAll());
        return lista;
    }


    @Override
    public categoriaDTO findByNombre(String nombre) {
        categoria category=categoriaRepo.findByNombreCategoria(nombre).orElseThrow(()-> new categoriaNoEncontradaException("no se encontro la categoria con el nombre"+nombre));
        categoriaDTO categoria=mapper.toCategoriaDto(category);
        return categoria;
    }


    @Override
    public void save(categoriaDTO categoria) { 
        categoriaRepo.save(mapper.toCategoria(categoria));
    }


    @Override
    public void delete(Long id) {
        if (categoriaRepo.existsById(id)) {
             categoriaRepo.deleteById(id);
        }else{
            throw new categoriaNoEncontradaException("no se encontro la categoria con el id "+id);
        }
       
    }


    @Override
    public categoriaDTO findById(long id) {
       categoria category=categoriaRepo.findById(id).orElseThrow(()-> new categoriaNoEncontradaException("no se encontro la categoria con el id"+id));
       categoriaDTO categoria=mapper.toCategoriaDto(category);
       return categoria;
    }

    @Override
    public categoriaDTO update(Long id, categoriaDTO categoriaDT) {
        categoria categoria=categoriaRepo.findById(id).orElseThrow(()->new categoriaNoEncontradaException("no se encontro la categoria con el id"+id));
        categoria.setNombreCategoria(categoriaDT.getNombreCategoria());
        categoriaRepo.save(categoria);
        
        categoriaDTO category=mapper.toCategoriaDto(categoria);
        return category;
    }

}
