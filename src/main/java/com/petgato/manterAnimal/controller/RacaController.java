/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.controller;

import com.petgato.manterAnimal.model.Raca;
import com.petgato.manterAnimal.repository.RacaRepository;

/**
 *
 * @author alessandra
 */
public class RacaController {
    
     private RacaRepository repository;

    public RacaController() {
        this.repository = new RacaRepository();
    }
    
    public void cadastrar(String nome) {
        Raca raca = new Raca.RacaBuilder()
                .whitNome(nome)
                .build();
        repository.save(raca);
    }
     
    public Raca buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, String nome) {
        Raca raca = buscarPorId(id);
        raca.setNome(nome);
        repository.update(raca);
    }
    
    public void deletar(Long id){
        Raca raca = buscarPorId(id);
        repository.delete(raca);
    }
    
    public Raca buscarPorNome(String nome){
        return (Raca) repository.findByNome(nome);
    }
}
