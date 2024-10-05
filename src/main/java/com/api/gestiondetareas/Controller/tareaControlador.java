package com.api.gestiondetareas.Controller;
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
import java.util.List;


import com.api.gestiondetareas.Model.DTOs.tareaDTO;
import com.api.gestiondetareas.Service.impl.tareaServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
@RequestMapping("/tarea")
@RestController
@Tag(name="tarea",description = "tareas api")
public class tareaControlador {
  @Autowired
  private tareaServiceImpl tareaService;


  @Operation(summary = "Trae todas las tareas")
  @ApiResponse(responseCode = "200",description = "se recupero la lista de tareas")
  
  @GetMapping
  public ResponseEntity<List<tareaDTO>> getll(){
    return new ResponseEntity<>(tareaService.findAll(),HttpStatus.OK);
  }

  @Operation(summary = "busca una tarea por su ID")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200",description = "se recupero la tarea"),
    @ApiResponse(responseCode = "404",description = "no se encontro la tarae")
  })

  @GetMapping ("/{id}")
  public ResponseEntity<tareaDTO>getTareaById(@Parameter(description = " se espera el id de la tarea a buscar") @PathVariable long id){
      return new ResponseEntity<>(tareaService.findById(id),HttpStatus.OK);
  }

  @Operation(summary = "busca una tarea por su nombre ")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200",description = "se encontro la tarea"),
    @ApiResponse(responseCode = "404",description = "no se encontro la tarea")
  })

  @GetMapping("/buscarPorNombre/{nombre}")
  public ResponseEntity<List<tareaDTO>> findByNombre(@Parameter(description = "se espera el nombre de la tarea a buscar")@PathVariable String nombre){
      return new ResponseEntity<>(tareaService.findByNombre(nombre),HttpStatus.OK);
  }

    

  @Operation(summary = "busca las tareas completadas")
  @ApiResponses(value={
    @ApiResponse(responseCode = "200",description = "se recupero las tareas completadas"),
    @ApiResponse(responseCode = "204",description = "no hay tareas completadas")
  })

  @GetMapping("/tareasCompletadas")
  public ResponseEntity<List<tareaDTO>>tareaCompletadas(){
    if(tareaService.findByEstadoIsTrue().isEmpty()){
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }else{
      return new ResponseEntity<>(tareaService.findByEstadoIsTrue(),HttpStatus.OK);
    }
  }

  @Operation(summary = "busca las tareas no completadas")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200",description = "se encontro la tarea con exito"),
    @ApiResponse(responseCode = "204",description = "no hay tareas por completar")
  })

  @GetMapping("/tareasNoCompletadas")
  public ResponseEntity<List<tareaDTO>>tareaNoCompletadas(){
   if(tareaService.findByEstadoIsFalse().isEmpty()){
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }else{
    return new ResponseEntity<>(tareaService.findByEstadoIsFalse(),HttpStatus.OK);
   }
  }

 @Operation(summary = "actualizar una tarea")
 @ApiResponse(responseCode = "200",description = "se actualizo la tarea con exito")

  @PutMapping("/{id}")
  public ResponseEntity<tareaDTO>update(@Parameter(description = "se espera el id de la tarea a buscar ")@PathVariable Long id,
  @Parameter(description = "se espera los datos a actualizar")@RequestBody tareaDTO tareaDT){
       return new ResponseEntity<>(tareaService.update(id, tareaDT),HttpStatus.OK);
  }


  @Operation(summary = "crea una tarea")
  @ApiResponse(responseCode = "200",description = "se creo la tarea con exito")

  @PostMapping
  public ResponseEntity<?> createTarea(@Parameter(description = "se espera el cuerpo de la tarea a crear")@RequestBody tareaDTO tareaDTO){
    tareaService.save(tareaDTO);
    return new ResponseEntity<>(HttpStatus.OK);
  }


  @Operation(summary = "borra una tarea")
  @ApiResponse(responseCode = "200",description = "se borro la tarea con exito")

  @DeleteMapping("/{id}")
  ResponseEntity<tareaDTO>delete(@Parameter(description = "se espera el id de la tarea")@PathVariable Long id){
     tareaService.delete(id);
     return ResponseEntity.ok().build();
  }
  
 

}
