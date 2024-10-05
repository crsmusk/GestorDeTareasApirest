package com.api.gestiondetareas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gestiondetareas.Model.DTOs.rolDTO;
import com.api.gestiondetareas.Service.impl.rolServiceImpl;


@RestController
@RequestMapping("/tarea/roles")

public class rolController {

    @Autowired
    rolServiceImpl rolService;
    
    @GetMapping
    public ResponseEntity<List<rolDTO>>getAll(){
     return new ResponseEntity<>(rolService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<rolDTO>getById(@PathVariable Long id){
        return new ResponseEntity<>(rolService.getById(id),HttpStatus.OK);
    }
    @GetMapping("buscarPorNombre/{nombre}")
    public ResponseEntity<rolDTO>getByNombre(@PathVariable String nombre){
      return new ResponseEntity<>(rolService.getByName(nombre),HttpStatus.OK);
    }
     @PutMapping("/actualizarRol/{id}")
    public ResponseEntity<rolDTO>updateRol(@PathVariable Long id,@RequestBody rolDTO rolDTO){
        return new ResponseEntity<>(rolService.updateRol(id, rolDTO),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?>saveRol(@RequestBody rolDTO rolDTO){
     rolService.save(rolDTO);
     return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id){
       rolService.deleteById(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }
}
