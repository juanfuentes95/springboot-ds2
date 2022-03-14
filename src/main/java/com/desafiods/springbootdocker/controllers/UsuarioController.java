package com.desafiods.springbootdocker.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.desafiods.springbootdocker.exceptions.UsuarioValidationException;
import com.desafiods.springbootdocker.models.UsuarioModel;
import com.desafiods.springbootdocker.services.UsuarioService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Error;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsuarioController {

    Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioService usuarioService;

    //Obtener todos los usuarios
    @GetMapping("/usuarios")
    public ArrayList<UsuarioModel> getUsers(){        
        logger.info("HTTP GET: getUsers() was thrown.");
        return usuarioService.getUsers();
    }

    //Agregar un nuevo usuario
    @PostMapping("/usuarios")
    public UsuarioModel saveUser(@Valid @RequestBody UsuarioModel usuario, BindingResult results){
        if(results.hasErrors()){
            throw new UsuarioValidationException();       
        }else{
            logger.info("HTTP POST: saveUser({},{}) was thrown.", 
                org.springframework.web.util.HtmlUtils.htmlEscape(usuario.getNombre()),
                org.springframework.web.util.HtmlUtils.htmlEscape((usuario.getEdad()).toString()));

            return usuarioService.saveUser(usuario);
        }
    }

    //Obtener el usuario de id = {idUsuario}
    @GetMapping("/usuarios/{idUsuario}")
    public UsuarioModel getUsersById(@PathVariable Integer idUsuario){
        logger.info("HTTP GET: getUsersById({}) was thrown.", 
                org.springframework.web.util.HtmlUtils.htmlEscape(idUsuario.toString()));
        return usuarioService.getUserById(idUsuario);
    }
    
}

