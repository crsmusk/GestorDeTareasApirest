package com.api.gestiondetareas.Controller;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gestiondetareas.Model.DTOs.permisosDTO;
import com.api.gestiondetareas.Service.impl.permisoServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/tarea/permisos")

public class permisoController {

    @Autowired
    permisoServiceImpl permisoService;

    @GetMapping 
    public ResponseEntity<List<permisosDTO>>getAll(){
        return new ResponseEntity<>(permisoService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<permisosDTO>getById(@PathVariable Long id){
        return new ResponseEntity<>(permisoService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/buscarPorNombre/{nombre}")
    public ResponseEntity<permisosDTO>getByNombre(@PathVariable String nombre){
        return new ResponseEntity<>(permisoService.getByNombre(nombre),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?>savePermiso(@RequestBody permisosDTO permisosDTO){
        permisoService.save(permisosDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizarPermisos/{id}")
    public ResponseEntity<permisosDTO>updatePermiso(@PathVariable Long id,@RequestBody permisosDTO permisosDTO){
        return new ResponseEntity<>(permisoService.update(id, permisosDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id){
        permisoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
