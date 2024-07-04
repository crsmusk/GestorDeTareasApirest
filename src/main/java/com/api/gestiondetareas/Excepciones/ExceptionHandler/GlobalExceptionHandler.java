package com.api.gestiondetareas.Excepciones.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.gestiondetareas.Excepciones.categoriaNoEncontradaException;
import com.api.gestiondetareas.Excepciones.tareaNoEncontradaException;
import com.api.gestiondetareas.Excepciones.ClassException.Error;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(categoriaNoEncontradaException.class)
  public ResponseEntity<Error>manejarCategoriaException(categoriaNoEncontradaException ex){
    Error error=new Error(
        HttpStatus.BAD_REQUEST.value(),
        ex.getMessage(),
        System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
  }
    @ExceptionHandler(tareaNoEncontradaException.class)
  public ResponseEntity<Error>manejarTareaException(tareaNoEncontradaException ex){
    Error error=new Error(
      HttpStatus.BAD_REQUEST.value(),
      ex.getMessage(),
      System.currentTimeMillis()
    );
    return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
  }

}
