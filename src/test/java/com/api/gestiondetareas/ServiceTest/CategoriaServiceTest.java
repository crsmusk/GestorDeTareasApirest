package com.api.gestiondetareas.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.gestiondetareas.Map.categoriaMapper;
import com.api.gestiondetareas.Model.DTOs.categoriaDTO;
import com.api.gestiondetareas.Model.Entities.categoria;
import com.api.gestiondetareas.Repository.categoriaRepository;
import com.api.gestiondetareas.Service.impl.categoriaServiceImpl;
@SpringBootTest
public class CategoriaServiceTest {
    
    private categoria categoriaEsperada;

    @Autowired
    categoriaServiceImpl categoriaService;

    @Autowired
    categoriaRepository categoriaRepo;

    @Autowired
    categoriaMapper mapper;
    
    @BeforeEach
    public void setUp(){
        categoriaEsperada=new categoria();
        categoriaEsperada.setId(1L);
        categoriaEsperada.setNombreCategoria("Tarea");
        categoriaRepo.save(categoriaEsperada);
    }
    @AfterEach
    public void finalizarTest(){
        categoriaService.delete(categoriaEsperada.getId());
    }
    @Test
    public void categoria_find_by_id(){
        Optional<categoriaDTO> categoriaObtenida=categoriaService.findById(categoriaEsperada.getId());
        assertTrue(categoriaObtenida.isPresent());
        assertEquals(mapper.toCategoriaDto(categoriaEsperada), categoriaObtenida.get());
       
    }
}
