/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.controller;

import com.petgato.manterProntuario.model.GrupoProduto;
import com.petgato.manterProntuario.repository.GrupoProdutoRepository;
import com.petgato.manterUsuario.controller.*;
import com.petgato.manterUsuario.model.GrupoUsuario;
import com.petgato.manterUsuario.repository.GrupoUsuarioRepository;

/**
 *
 * @author alessandra
 */
public class GrupoProdutoController {

    private GrupoProdutoRepository repository;
    

    public GrupoProdutoController() {
        repository = new GrupoProdutoRepository();
    }

    public void cadastrar(String nome) {

        GrupoProduto grupo = new GrupoProduto.GrupoProdutoBuilder()
                .whitNome(nome)
                .build();
        repository.save(grupo);
    }

    public GrupoProduto buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, String nome) {
        GrupoProduto grupo = buscarPorId(id);
        grupo.setNome(nome);
        repository.update(grupo);
    }
    
    public void deletar(Long id){
        GrupoProduto grupo = buscarPorId(id);
        repository.delete(grupo);
    }
    
    public GrupoProduto buscarPorNome(String nome){
        return (GrupoProduto) repository.findByNome(nome);
    }
}
