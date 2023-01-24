/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.controller;

import com.petgato.manterUsuario.model.GrupoUsuario;
import com.petgato.manterUsuario.model.Usuario;
import com.petgato.manterUsuario.repository.UsuarioRepository;
import java.time.LocalDate;

/**
 *
 * @author alessandra
 */
public class UsuarioController {

    private UsuarioRepository repository;

    public UsuarioController() {
        repository = new UsuarioRepository();
    }

    public void cadastrar(String nome, String sobrenome, LocalDate idade, 
            String email, String username, String senha, boolean bloqueado, GrupoUsuario grupo) {

        Usuario usuario = (Usuario) new Usuario.UsuarioBuilder()
                .whitUsername(username)
                .whitSenha(senha)
                .withBloqueado(bloqueado)
                .withGrupoUsuario(grupo)
                .whitNome(nome)
                .whitSobrenome(sobrenome)
                .whitIdade(idade)
                .whitEmail(email)
                .build();
        repository.save(usuario);
    }
    
     public Usuario buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(long id, String nome, String sobrenome, LocalDate nascimento, String email, String usuario, String senha, boolean bloqueado, GrupoUsuario grupo) {
        Usuario user = buscarPorId(id);
        user.setSobrenome(sobrenome);
        user.setNome(nome);
        user.setIdade(nascimento);
        user.setEmail(email);
        user.setUsername(usuario);
        user.setSenha(senha);
        user.setGrupoUsuario(grupo);
        user.setBloqueado(bloqueado);
        repository.update(user);
    }
    
    public void deletar(Long id){
        Usuario user = buscarPorId(id);
        repository.delete(user);
    }
    
    public Usuario buscarPorNome(String nome){
        return (Usuario) repository.findByNome(nome);
    }
}
