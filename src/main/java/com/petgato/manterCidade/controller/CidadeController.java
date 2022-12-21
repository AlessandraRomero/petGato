/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterCidade.controller;

import com.petgato.manterCidade.model.Cidade;
import com.petgato.manterCidade.repository.CidadeRepository;

/**
 *
 * @author alessandra
 */
public class CidadeController {
    
     private CidadeRepository repository;

    public CidadeController() {
        this.repository = new CidadeRepository();
    }
    
     public void cadastrar(String nome, String uf) {
        Cidade cidade = new Cidade.CidadeBuilder()
                .whitNome(nome)
                .whitUf(uf)
                .build();
        repository.save(cidade);
    }

    public Cidade buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, String nome, String uf) {
        Cidade cidade = buscarPorId(id);
        cidade.setNome(nome);
        cidade.setUf(uf);
        repository.update(cidade);
    }
    
    public void deletar(Long id){
        Cidade cidade = buscarPorId(id);
        repository.delete(cidade);
    }
    
    public Cidade buscarPorNome(String nome){
        return (Cidade) repository.findByNome(nome);
    }     
}
