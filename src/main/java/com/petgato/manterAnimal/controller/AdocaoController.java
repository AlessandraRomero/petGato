/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.controller;

import com.petgato.manterAdotante.model.Adotante;
import com.petgato.manterAnimal.model.Adocao;
import com.petgato.manterAnimal.model.Animal;
import com.petgato.manterAnimal.model.Especie;
import com.petgato.manterAnimal.model.Raca;
import com.petgato.manterAnimal.model.enums.Status;
import com.petgato.manterAnimal.repository.AdocaoRepository;
import com.petgato.manterUsuario.model.Usuario;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author alessandra
 */
public class AdocaoController {
     
    private AdocaoRepository repository;

    public AdocaoController() {
        this.repository = new AdocaoRepository();
    }
    
     public void cadastrar(LocalDate dataEmissao, Status status, Adotante adotante,
             Usuario atendente, List adotados, List Visitas) {
        Adocao adocao = (adocao) new Adocao.AdocaoBuilder()
                .whit
                .build();
        repository.save(adocao);
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
