package com.api.gestiondetareas.Controller;

import java.util.List;
import java.util.Optional;

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

import com.api.gestiondetareas.Exception.categoriaNoEncontradaException;
import com.api.gestiondetareas.Exception.usuarioNoEncontradoException;


import com.api.gestiondetareas.Model.DTOs.usuarioDTO;


import com.api.gestiondetareas.Service.impl.usuarioServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/tarea/usuario")
@Tag(name="usuarios")
public class usuarioController {
  
    @Autowired
    private usuarioServiceImpl usuarioService;
   
    
    @Operation(summary = "trae todos los usuarios")
    @ApiResponse(responseCode = "200",description = "se optuvieron los usuarios correctamente")

    @GetMapping
    public ResponseEntity<List<usuarioDTO>> traerTodo(){
        return new ResponseEntity<>(usuarioService.findAll(),HttpStatus.OK);
    }
    
    @Operation(summary = "busca un usuario por su id ")
    @ApiResponse(responseCode = "200",description = "se optuvo el usuario correctamente")

    @GetMapping("/{id}")
    public Optional<usuarioDTO>getById(@Parameter(description = "se espera el id del usuario a buscar")@PathVariable Long id){
        Optional<usuarioDTO>user=usuarioService.findById(id);
        if (user.isPresent()) {
            return user;   
        }else{
            throw new categoriaNoEncontradaException("no se encontro el usuario");
        }
    }

    @Operation(summary = "busca un usuario por su nickname")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "404")
    })

    @GetMapping("/buscarUsuarioPorNickName/{nickname}")
    public ResponseEntity<Optional<usuarioDTO>>getByNickName(@Parameter(description = "se espera el nickname del usuario a buscar")@PathVariable String nickName){
        if(usuarioService.findByNickName(nickName).isPresent()){
            return new ResponseEntity<>(usuarioService.findByNickName(nickName),HttpStatus.OK);
        }else{
            throw new usuarioNoEncontradoException("no se encontro al usuario con el nickName "+nickName);
        }
    }

    @Operation(summary = "busca un usuario por su email")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "404")
    })
    @GetMapping("/buscarUsuarioPorEmail/{email}")
    public ResponseEntity<Optional<usuarioDTO>>getByEmail(@Parameter(description = "se espera el email del usuario a buscar")@PathVariable String email){
        if(usuarioService.findByEmail(email).isPresent()){
            return new ResponseEntity<>(usuarioService.findByEmail(email),HttpStatus.OK);
        }else {
            throw new usuarioNoEncontradoException("no se encontro al usuario con el email "+email);
        }
    }
    @Operation(summary = "borra un usuario por su id")
    @ApiResponse(responseCode = "200")
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteById(@Parameter(description = "se espera el id del usuario a eliminar")@PathVariable Long id){
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @Operation(summary = "crea un usuario nuevo")
    @ApiResponse(responseCode = "200")

    @PostMapping
    public ResponseEntity<?>saveUsuario(@Parameter(description = "se espera el cuerpo del usuario a crear")@RequestBody usuarioDTO usuarioDTO){
        usuarioService.save(usuarioDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

   @Operation(summary = "Actualiza un usuario buscandolo por su id")
   @ApiResponse(responseCode = "200")

    @PutMapping("/{id}")
    public ResponseEntity<usuarioDTO>updateUsuario(@Parameter(description = "se espera el id del usuario a actualizar")@PathVariable Long id,
    @Parameter(description = "Se espera el cuerpo con los datos a actualizar")@RequestBody usuarioDTO usuarioDTO){
        return new ResponseEntity<>(usuarioService.update(id, usuarioDTO),HttpStatus.OK);
    }

}
