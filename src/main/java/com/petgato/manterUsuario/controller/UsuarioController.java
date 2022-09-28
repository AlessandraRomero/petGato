/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.controller;

import com.petgato.manterUsuario.model.GrupoUsuario;
import com.petgato.manterUsuario.model.Usuario;
import com.petgato.manterUsuario.repository.UsuarioRepository;

/**
 *
 * @author alessandra
 */
public class UsuarioController {

    private UsuarioRepository repository;

    public UsuarioController() {
        repository = new UsuarioRepository();

    }

    public void cadastrar(String username, String senha, boolean bloqueado, String situacao) {

        Usuario usuario = new Usuario.UsuarioBuilder()
                .whitUsername(senha)
                .whitSenha(senha)
                .whitBloqueado(bloqueado)
                .whitSituacao(senha)
                .build();

        repository.save(usuario);

    }
}
