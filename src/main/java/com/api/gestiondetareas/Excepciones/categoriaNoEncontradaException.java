package com.api.gestiondetareas.Excepciones;

public class categoriaNoEncontradaException extends RuntimeException{
   public categoriaNoEncontradaException(String mensaje){
    super(mensaje);
   }
}
