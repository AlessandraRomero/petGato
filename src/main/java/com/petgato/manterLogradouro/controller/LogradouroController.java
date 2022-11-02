/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterLogradouro.controller;

import com.petgato.manterLogradouro.model.Logradouro;
import com.petgato.manterLogradouro.repository.LogradouroRepository;

/**
 *
 * @author alessandra
 */
public class LogradouroController {
    private LogradouroRepository repository;

    public LogradouroController() {
        this.repository = new LogradouroRepository();
    }
    
     public void cadastrar(String nome) {
        Logradouro log = new Logradouro.LogradouroBuilder()
                .whitNome(nome)
                .build();
        repository.save(log);
    }

    public Logradouro buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, String nome) {
        Logradouro log = buscarPorId(id);
        log.setNome(nome);
        repository.update(log);
    }
    
    public void deletar(Long id){
        Logradouro log = buscarPorId(id);
        repository.delete(log);
    }
    
    public Logradouro buscarPorNome(String nome){
        return (Logradouro) repository.findByNome(nome);
    }
      
}
