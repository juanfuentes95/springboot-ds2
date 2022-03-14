package com.desafiods.springbootdocker.exceptions;

public class UsuarioValidationException extends RuntimeException {
    
    public UsuarioValidationException(){
        super("No valid user");
    }
}
