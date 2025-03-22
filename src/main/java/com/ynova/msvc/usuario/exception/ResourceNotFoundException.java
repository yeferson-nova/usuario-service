package com.ynova.msvc.usuario.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Recurso no encontrado en el servidor");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

}
