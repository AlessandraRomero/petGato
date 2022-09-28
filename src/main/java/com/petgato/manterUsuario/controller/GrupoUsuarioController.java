/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.controller;

import com.petgato.manterUsuario.model.GrupoUsuario;
import com.petgato.manterUsuario.repository.GrupoUsuarioRepository;

/**
 *
 * @author alessandra
 */
public class GrupoUsuarioController {

    private GrupoUsuarioRepository repository;
    

    public GrupoUsuarioController() {
        repository = new GrupoUsuarioRepository();
    }

    public void cadastrar(String nome) {

        GrupoUsuario grupo = new GrupoUsuario.GrupoUsuarioBuilder()
                .whitNome(nome)
                .build();
        repository.save(grupo);
    }

    public GrupoUsuario buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, String nome) {
        GrupoUsuario grupo = buscarPorId(id);
        grupo.setNome(nome);
        repository.update(grupo);
    }
    
    public void deletar(Long id){
        GrupoUsuario grupo = buscarPorId(id);
        repository.delete(grupo);
    }
}
