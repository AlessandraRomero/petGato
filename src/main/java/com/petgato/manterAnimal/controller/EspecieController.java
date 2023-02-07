/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.controller;

import com.petgato.manterAnimal.model.Especie;
import com.petgato.manterAnimal.repository.EspecieRepository;

/**
 *
 * @author alessandra
 */
public class EspecieController {
     
    private EspecieRepository repository;

    public EspecieController() {
        this.repository = new EspecieRepository();
    }
    
     public void cadastrar(String nome) {
        Especie esp = new Especie.EspecieBuilder()
                .whitNome(nome)
                .build();
        repository.save(esp);
    }
     
     public Especie buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, String nome) {
        Especie esp = buscarPorId(id);
        esp.setNome(nome);
        repository.update(esp);
    }
    
    public void deletar(Long id){
        Especie esp = buscarPorId(id);
        repository.delete(esp);
    }
    
    public Especie buscarPorNome(String nome){
        return (Especie) repository.findByNome(nome);
    }
}
