/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.controller;

import com.petgato.manterAnimal.model.Animal;
import com.petgato.manterAnimal.model.Especie;
import com.petgato.manterAnimal.model.Raca;
import com.petgato.manterAnimal.repository.AnimalRepository;

/**
 *
 * @author alessandra
 */
public class AnimalController {
     
    private AnimalRepository repository;

    public AnimalController() {
        this.repository = new AnimalRepository();
    }
    
     public void cadastrar(String nome, float idade, String sexo, float peso, Raca raca, Especie especie) {
        Animal animal = (Animal) new Animal.AnimalBuilder()
                .whitRaca(raca)
                .whitEspecie(especie)
                .whitName(nome)
                .whitIdade(idade)
                .whitSexo(sexo)
                .whitPeso(peso)
                .build();
        repository.save(animal);
    }
     
     public Animal buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, String nome, float idade, String sexo, float peso, Raca raca, Especie especie) {
        Animal animal = buscarPorId(id);
        animal.setNome(nome);
        animal.setIdade(idade);
        animal.setSexo(sexo);
        animal.setPeso(peso);
        animal.setRaca(raca);
        animal.setEspecie(especie);
        repository.update(animal);
    }
    
    public void deletar(Long id){
        Animal animal = buscarPorId(id);
        repository.delete(animal);
    }
    
    public Animal buscarPorNome(String nome){
        return (Animal) repository.findByNome(nome);
    }
}
