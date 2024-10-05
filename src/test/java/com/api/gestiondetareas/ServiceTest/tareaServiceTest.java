package com.api.gestiondetareas.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.gestiondetareas.Exception.tareaNoEncontradaException;
import com.api.gestiondetareas.Model.DTOs.tareaDTO;
import com.api.gestiondetareas.Model.Entities.tarea;
import com.api.gestiondetareas.Repository.tareaRepository;
import com.api.gestiondetareas.Service.impl.tareaServiceImpl;

@SpringBootTest
public class tareaServiceTest {
    private tareaDTO tareaDTOEsperada;

    private Optional<List<tarea>>lista;

    @Autowired
    tareaServiceImpl tareaService;
    @Autowired
    tareaRepository tareaRepo;

    @BeforeEach
    public void setUp(){ 
        tareaDTOEsperada=new tareaDTO();
        tareaDTOEsperada.setNombre("trabajo");
        tareaDTOEsperada.setContenido("realizar el trabajo en grupo");
        tareaDTOEsperada.setEstado(false);
        tareaDTOEsperada.setFechaLimite(LocalDate.of(2025, 07, 24));
        tareaService.save(tareaDTOEsperada);
    }

    @Test
    public void tarea_find_by_nombre(){
        lista=tareaRepo.findByNombreIgnoreCase("trabajo");
        List<tareaDTO> tareaOptenida=tareaService.findByNombre("trabajo");
        tareaDTO tarea=tareaOptenida.getFirst();
        
        
        assertEquals(tareaDTOEsperada, tarea);
    }

    @Test
    public void tarea_find_by_id(){
        lista=tareaRepo.findByNombreIgnoreCase("trabajo");
        tareaDTO tareaOptenida=tareaService.findById(lista.get().getFirst().getId());
        
        
        assertEquals(tareaDTOEsperada, tareaOptenida);
    }

    @Test
    public void tarea_update(){
        lista=tareaRepo.findByNombreIgnoreCase("trabajo");
        tareaDTOEsperada.setNombre("urgente");
        tareaService.update(lista.get().getFirst().getId(), tareaDTOEsperada);

        List<tareaDTO>tareaDTOsOptenida=tareaService.findByNombre("urgente");
        tareaDTO tareaDTOptenida=tareaDTOsOptenida.getFirst();

        
        assertEquals(tareaDTOEsperada, tareaDTOptenida);
        
    }
    @Test 
     public void tarea_test_find_id_exception(){
        lista=tareaRepo.findByNombreIgnoreCase("trabajo");

     assertThrows(tareaNoEncontradaException.class, ()->{
      tareaService.findById(78L);
     });
  }
        
    @AfterEach
    public void delete(){
        tareaRepo.deleteById(lista.get().getFirst().getId());
    }
}
