package com.api.gestiondetareas.Exception.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.gestiondetareas.Exception.categoriaNoEncontradaException;
import com.api.gestiondetareas.Exception.permisoNoEncontroException;
import com.api.gestiondetareas.Exception.rolNoEncontradoException;
import com.api.gestiondetareas.Exception.tareaNoEncontradaException;
import com.api.gestiondetareas.Exception.usuarioNoEncontradoException;
import com.api.gestiondetareas.Exception.ClassException.Error;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(categoriaNoEncontradaException.class)
  public ResponseEntity<Error>manejarCategoriaException(categoriaNoEncontradaException ex){
    Error error=new Error(
        HttpStatus.NOT_FOUND.value(),
        ex.getMessage(),
        System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
  }

    @ExceptionHandler(tareaNoEncontradaException.class)
  public ResponseEntity<Error>manejarTareaException(tareaNoEncontradaException ex){
    Error error=new Error(
      HttpStatus.NOT_FOUND.value(),
      ex.getMessage(),
      System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(usuarioNoEncontradoException.class)
  public ResponseEntity<Error>manejarUsuarioException(usuarioNoEncontradoException ex){
    Error error=new Error(
      HttpStatus.NOT_FOUND.value(),
      ex.getMessage(),
      System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(rolNoEncontradoException.class)
  public ResponseEntity<Error>manejarrolNoEncontradoException(rolNoEncontradoException ex){
    Error error=new Error(
      HttpStatus.NOT_FOUND.value(),
      ex.getMessage(),
      System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(permisoNoEncontroException.class)
   public ResponseEntity<Error>manejarpermisoNoEncontroException(permisoNoEncontroException ex){
    Error error=new Error(
      HttpStatus.NOT_FOUND.value(),
      ex.getMessage(),
      System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
   }



}
