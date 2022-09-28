/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.controller;

import com.petgato.manterProntuario.model.Produto;
import com.petgato.manterProntuario.repository.ProdutoRepository;
import com.petgato.manterUsuario.model.GrupoUsuario;


/**
 *
 * @author alessandra
 */
public class ProdutoController {

    private ProdutoRepository repository;
    

    public ProdutoController() {
        repository = new ProdutoRepository();
    }

    public void cadastrar(String nome) {

        Produto prod = new Produto.ProdutoBuilder()
                .whitNome(nome)
                .build();
        repository.save(prod);
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, String nome) {
        Produto prod = buscarPorId(id);
        prod.setNome(nome);
        repository.update(prod);
    }
    
    public void deletar(Long id){
        Produto prod = buscarPorId(id);
        repository.delete(prod);
    }
}
