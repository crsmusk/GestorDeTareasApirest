package com.api.gestiondetareas.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.gestiondetareas.Exception.categoriaNoEncontradaException;
import com.api.gestiondetareas.Map.categoriaMapper;
import com.api.gestiondetareas.Model.DTOs.categoriaDTO;
import com.api.gestiondetareas.Repository.categoriaRepository;
import com.api.gestiondetareas.Service.impl.categoriaServiceImpl;
@SpringBootTest
public class CategoriaServiceTest {
    
    private categoriaDTO categoriaDTOEsperada;

    @Autowired
    categoriaServiceImpl categoriaService;

    @Autowired
    categoriaRepository categoriaRepo;

    @Autowired
    categoriaMapper mapper;
    
    @BeforeEach
    public void setUp(){
        categoriaDTOEsperada=new categoriaDTO();
        categoriaDTOEsperada.setNombreCategoria("loco");
        categoriaService.save(categoriaDTOEsperada);
    }
    
    
   
    @Test
    public void categoria_find_by_id(){
        Long idLong=categoriaRepo.findByNombreCategoria(categoriaDTOEsperada.getNombreCategoria()).get().getId();
        Optional<categoriaDTO> categoriaObtenida=categoriaService.findById(idLong);
        assertTrue(categoriaObtenida.isPresent());
        assertEquals(categoriaDTOEsperada, categoriaObtenida.get());
       //categoriaService.delete(categoriaEsperada.getId());
    }

    @Test
    public void categoria_find_by_nombreCategoria(){
        Optional<categoriaDTO>categoriaObtenida=categoriaService.findByNombre("loco");
        assertTrue(categoriaObtenida.isPresent());
        assertEquals(categoriaDTOEsperada,categoriaObtenida.get());
        //categoriaService.delete(categoriaEsperada.getId());
    }

    @Test
    public void categoria_update(){
        Long idLong=categoriaRepo.findByNombreCategoria(categoriaDTOEsperada.getNombreCategoria()).get().getId();
        categoriaDTOEsperada.setNombreCategoria("urgente");
        categoriaService.update(idLong, categoriaDTOEsperada);

        Optional<categoriaDTO>categoriaObtenida=categoriaService.findById(idLong);
        
        assertTrue(categoriaObtenida.isPresent());
        assertEquals(categoriaDTOEsperada, categoriaObtenida.get());
        
    }

      @Test 
      public void categoria_test_find_id_exception(){
         assertThrows(categoriaNoEncontradaException.class, ()->{
         categoriaService.findById(68L);
        });
      }
    

    @AfterEach
    public void delete(){
        Long idLong=categoriaRepo.findByNombreCategoria(categoriaDTOEsperada.getNombreCategoria()).get().getId();
        categoriaRepo.deleteById(idLong);
    }

    
   
}