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
public class UsuarioValidationAdvice {

    static final Logger logger = LoggerFactory.getLogger(UsuarioValidationAdvice.class);

    @ResponseBody
    @ExceptionHandler(UsuarioValidationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String UsuarioValidationHandler(UsuarioValidationException ex) {
        logger.info("User not valid. Msg."
                +org.springframework.web.util.HtmlUtils.htmlEscape(ex.getMessage()));
        return ex.getMessage();
    }

}
