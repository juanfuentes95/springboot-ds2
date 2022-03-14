package com.desafiods.springbootdocker.exceptions;

import com.desafiods.springbootdocker.controllers.UsuarioController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UsuarioNotFoundAdvice {

    static final Logger logger = LoggerFactory.getLogger(UsuarioNotFoundAdvice.class);

    @ResponseBody
    @ExceptionHandler(UsuarioNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String UsuarioNotFoundHandler(UsuarioNotFoundException ex) {
        logger.info("User no found. Msg."
                +org.springframework.web.util.HtmlUtils.htmlEscape(ex.getMessage()));
        return ex.getMessage();
    }

}
