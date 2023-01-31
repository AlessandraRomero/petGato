/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.controller;

import com.petgato.manterAnimal.model.Adocao;
import com.petgato.manterAnimal.model.Adotado;
import com.petgato.manterAnimal.model.Animal;
import com.petgato.manterAnimal.repository.AdotadoRepository;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author alessandra
 */
public class AdotadoController {

    private AdotadoRepository repository;

    public AdotadoController() {
        this.repository = new AdotadoRepository();
    }

    public void cadastrar(LocalDate dataAdocao, boolean isAdotado, List<Animal> animais, Adocao adocao) {
        Adotado adotad = new Adotado.AdotadoBuilder()
                .withDataAdocao(dataAdocao)
                .withIsAdotado(isAdotado)
                .withAdocao(adocao)
                .withAnimais(animais)
                .build();
        repository.save(adotad);
    }

    public Adotado buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(long id, LocalDate dataAdocao, boolean isAdotado, List<Animal> animais, Adocao adocao) {
        Adotado adotad = buscarPorId(id);
        adotad.setDataAdocao(dataAdocao);
        adotad.setAdotado(isAdotado);
        adotad.setAnimais(animais);
        adotad.setAdocao(adocao);
        repository.update(adotad);
    }

    public void deletar(Long id) {
        Adotado adotado = buscarPorId(id);
        repository.delete(adotado);
    }

    public Adotado buscarPorNome(String nome) {
        return (Adotado) repository.findByNome(nome);
    }
}
