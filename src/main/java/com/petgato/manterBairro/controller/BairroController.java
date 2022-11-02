/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterBairro.controller;

import com.petgato.manterBairro.model.Bairro;
import com.petgato.manterBairro.repository.BairroRepository;

/**
 *
 * @author alessandra
 */
public class BairroController {
     private BairroRepository repository;

    public BairroController() {
        this.repository = new BairroRepository();
    }
    
     public void cadastrar(String nome) {
        Bairro bairro = new Bairro.BairroBuilder()
                .whitNome(nome)
                .build();
        repository.save(bairro);
    }

    public Bairro buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, String nome) {
        Bairro bairro = buscarPorId(id);
        bairro.setNome(nome);
        repository.update(bairro);
    }
    
    public void deletar(Long id){
        Bairro bairro = buscarPorId(id);
        repository.delete(bairro);
    }
    
    public Bairro buscarPorNome(String nome){
        return (Bairro) repository.findByNome(nome);
    }
}
