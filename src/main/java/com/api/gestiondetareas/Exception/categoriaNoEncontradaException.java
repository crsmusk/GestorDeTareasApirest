package com.api.gestiondetareas.Exception;

public class categoriaNoEncontradaException extends RuntimeException{
   public categoriaNoEncontradaException(String mensaje){
    super(mensaje);
   }
}
