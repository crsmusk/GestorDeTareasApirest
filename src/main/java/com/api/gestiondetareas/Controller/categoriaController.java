package com.api.gestiondetareas.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gestiondetareas.Model.DTOs.categoriaDTO;
import com.api.gestiondetareas.Service.impl.categoriaServiceImpl;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/tarea/categoria")
@Tag(name="categoria")
public class categoriaController {
   
    @Autowired
    private categoriaServiceImpl categoriaService;
    


    @Operation(summary = "Trae todas las Categorias")
    @ApiResponse(responseCode = "200",description = "se recupero la lista de categorias")

    @GetMapping
    public ResponseEntity<List<categoriaDTO>> getAll(){        
        return new ResponseEntity<>(categoriaService.findAll(),HttpStatus.OK);
    }

    @Operation(summary = "busca una categoria por el id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "se recupero la categoria con exito"),
        @ApiResponse(responseCode = "404",description = "no se econtro la categoria con el id dado")
    })

    @GetMapping("/{id}")
    public ResponseEntity<categoriaDTO>getById(@Parameter(description = "se espera el id de la categoria a buscar")@PathVariable Long id){
       
        return new ResponseEntity<>(categoriaService.findById(id),HttpStatus.OK);      
    }

    @Operation(summary = "busca una categoria por su respectivo nombre ")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "se recupero la categoria con exito"),
        @ApiResponse(responseCode = "404",description = "no se econtro la categoria con el nombre dado")
    })

    @GetMapping("/buscarCategoriaPorNombre/{nombreCategoria}")
    public ResponseEntity<categoriaDTO>getByNombre(@Parameter(description = "se espera el nombre de la tarea a buscar")@PathVariable String nombreCategoria){
       
        return new ResponseEntity<>(categoriaService.findByNombre(nombreCategoria),HttpStatus.OK);
       
    }

    @Operation(summary = "borra una categoria")
    @ApiResponse(responseCode = "200",description = "la tarea se elimino con exito")

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@Parameter(description = "se espera el id de la categoria a eliminar")@PathVariable Long id){
        categoriaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @Operation(summary = "crea una nueva categoria")
    @ApiResponse(responseCode = "201",description = "se creo la categoria con exito")

    @PostMapping
    public ResponseEntity<?> save(@RequestBody categoriaDTO categoria) {
        categoriaService.save(categoria);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "actualiza una nueva categoria")
    @ApiResponse(responseCode = "200",description = "se actualizo la categoria con exito")

    @PutMapping("/{id}")
    public ResponseEntity<categoriaDTO>updateCategoria(@PathVariable Long id,@RequestBody categoriaDTO categoriaDTO){
        return new ResponseEntity<>(categoriaService.update(id, categoriaDTO),HttpStatus.OK);
    }

}
