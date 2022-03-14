package com.desafiods.springbootdocker.services;

import java.util.ArrayList;

import com.desafiods.springbootdocker.exceptions.UsuarioNotFoundAdvice;
import com.desafiods.springbootdocker.exceptions.UsuarioNotFoundException;
import com.desafiods.springbootdocker.models.UsuarioModel;
import com.desafiods.springbootdocker.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    //Obtener todos los usuarios (GET)
    public ArrayList<UsuarioModel> getUsers(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    //Obtener usuario por id (GET)
    public UsuarioModel getUserById(Integer idUsuario){
        return usuarioRepository.findById(idUsuario)
            .orElseThrow(() -> new UsuarioNotFoundException(idUsuario));
    }

    //Guardar un usuario (POST)
    public UsuarioModel saveUser(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

}
