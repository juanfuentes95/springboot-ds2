package com.desafiods.springbootdocker.repositories;

import com.desafiods.springbootdocker.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Integer> {
    
}
