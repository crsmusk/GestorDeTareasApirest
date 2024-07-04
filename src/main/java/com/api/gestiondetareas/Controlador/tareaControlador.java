package com.api.gestiondetareas.Controlador;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.api.gestiondetareas.Entidades.tarea;
import com.api.gestiondetareas.Entidades.DTO.tareaDTO;
import com.api.gestiondetareas.Excepciones.tareaNoEncontradaException;
import com.api.gestiondetareas.Servicio.impl.tareaServiceImpl;
@RequestMapping("/tarea")
@RestController
public class tareaControlador {
  @Autowired
  private tareaServiceImpl tareaService;

  @GetMapping
  public ResponseEntity<List<tareaDTO>> getAll(){
    List<tareaDTO>lista=tareaService.findAll().stream().map(tarea->tareaDTO.builder()
    .nombre(tarea.getNombre())
    .categoria(tarea.getCategoria())
    .contenido(tarea.getContenido())
    .estado(tarea.isEstado())
    .fechaLimite(tarea.getFechaLimite())
    .build()).toList();
    return ResponseEntity.ok(lista);
  }

  @GetMapping ("/{id}")
  public ResponseEntity<tareaDTO>getTarea(@PathVariable Long id){
     Optional<tarea>Tarea=tareaService.findById(id);
     if(Tarea.isPresent()){
        tarea tare=Tarea.get();
        tareaDTO tareaDT=tareaDTO.builder()
        .categoria(tare.getCategoria())
        .contenido(tare.getContenido())
        .nombre(tare.getNombre())
        .estado(tare.isEstado())
        .fechaLimite(tare.getFechaLimite())
        .build();
        return ResponseEntity.ok(tareaDT);
     }
     throw new tareaNoEncontradaException("tarea no encontrada");
  }

  @GetMapping("/buscarPorNombre/{nombre}")
  public ResponseEntity<tareaDTO> findByNombre(@PathVariable String nombre){
    Optional<tarea>tare=tareaService.findByNombre(nombre);
    if (tare.isPresent()) {
        tarea Tarea=tare.get();
        tareaDTO tarea=tareaDTO.builder()
        .categoria(Tarea.getCategoria())
        .nombre(Tarea.getNombre())
        .contenido(Tarea.getContenido())
        .estado(Tarea.isEstado())
        .fechaLimite(Tarea.getFechaLimite())
        .build();
        ResponseEntity.ok(tarea);
    }
    throw new tareaNoEncontradaException("tarea no encontrada");
  }

  @GetMapping("/buscarPorCategoria/{categoria}")
  public ResponseEntity<List<tareaDTO>>findByCategoria(@PathVariable String categoria){
    List<tareaDTO>tare=tareaService.findByCategoria(categoria).stream().map(tarea->tareaDTO.builder()
    .nombre(tarea.getNombre())
    .categoria(tarea.getCategoria())
    .contenido(tarea.getContenido())
    .estado(tarea.isEstado())
    .fechaLimite(tarea.getFechaLimite())
    .build()).toList();
    return ResponseEntity.ok(tare);
  }

  @GetMapping("/tareasCompletadas")
  public ResponseEntity<List<tareaDTO>>tareaCompletadas(){
    List<tareaDTO>tareaDTOs=tareaService.findByEstadoIsTrue().stream().map(tarea->tareaDTO.builder()
    .nombre(tarea.getNombre())
    .categoria(tarea.getCategoria())
    .contenido(tarea.getContenido())
    .estado(tarea.isEstado())
    .fechaLimite(tarea.getFechaLimite())
    .build()).toList();
    return ResponseEntity.ok(tareaDTOs);
  }

  @GetMapping("/tareasNoCompletadas")
  public ResponseEntity<List<tareaDTO>>tareaNoCompletadas(){
    List<tareaDTO>tareaDTOs=tareaService.findByEstadoIsFalse().stream().map(tarea->tareaDTO.builder()
    .nombre(tarea.getNombre())
    .categoria(tarea.getCategoria())
    .contenido(tarea.getContenido())
    .estado(tarea.isEstado())
    .fechaLimite(tarea.getFechaLimite())
    .build()).toList();
    return ResponseEntity.ok(tareaDTOs);
  }

  @PutMapping("/{id}")
  public ResponseEntity<tareaDTO>update(@PathVariable Long id,@RequestBody tareaDTO tareaDT){
    tarea Tarea=tareaService.update(id, tareaDT);
    tareaDTO tarea=tareaDTO.builder()
    .nombre(Tarea.getNombre())
    .categoria(Tarea.getCategoria())
    .estado(Tarea.isEstado())
    .fechaLimite(Tarea.getFechaLimite())
    .contenido(Tarea.getContenido())
    .build();
    return ResponseEntity.ok(tarea);
  }

  @PostMapping
  public ResponseEntity<tareaDTO> createTarea(@RequestBody tareaDTO tareaDTO){
    tareaService.save(tareaDTO);
    return ResponseEntity.ok().build();
  }
  
  @DeleteMapping("/{id}")
  ResponseEntity<tareaDTO>delete(@PathVariable Long id){
     tareaService.delete(id);
     return ResponseEntity.ok().build();
  }
  
 

}
