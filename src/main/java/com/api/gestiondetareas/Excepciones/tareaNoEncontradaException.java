package com.api.gestiondetareas.Excepciones;

public class tareaNoEncontradaException extends RuntimeException {

    public tareaNoEncontradaException(String mensaje){
        super(mensaje);
    }

}
