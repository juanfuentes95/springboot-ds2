package com.desafiods.springbootdocker.exceptions;

public class UsuarioNotFoundException extends RuntimeException {
    
    public UsuarioNotFoundException(Integer idUsuario){
        super("No se pudo encontrar al usuario "
                +org.springframework.web.util.HtmlUtils.htmlEscape(idUsuario.toString()));
    }
}
