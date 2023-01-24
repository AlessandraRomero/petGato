/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.controller;

import com.petgato.manterAnimal.model.Adocao;
import com.petgato.manterAnimal.model.Visita;
import com.petgato.manterAnimal.model.enums.Status;
import com.petgato.manterAnimal.repository.VisitaRepository;
import java.time.LocalDate;

/**
 *
 * @author alessandra
 */
public class VisitaController {

    private VisitaRepository repository;

    public VisitaController() {
        this.repository = new VisitaRepository();
    }

    public void cadastrar(LocalDate dataVisita, String Observacao, Status status, Adocao adocao) {
        Visita visita = new Visita.VisitaBuilder()
                .whitDataVisita(dataVisita)
                .whitObservacao(Observacao)
                .whitStatus(status)
                .whitAdocao(adocao)
                .build();
        repository.save(visita);
    }

    public Visita buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, LocalDate dataVisita, String Observacao, Status status, Adocao adocao) {
        Visita visita = buscarPorId(id);
        visita.setDataVisita(dataVisita);
        visita.setObservacao(Observacao);
        visita.setStatus(status);
        visita.setAdocao(adocao);
        repository.update(visita);
    }

    public void deletar(Long id) {
        Visita visita = buscarPorId(id);
        repository.delete(visita);
    }

    public Visita buscarPorNome(String nome) {
        return (Visita) repository.findByNome(nome);
    }
}
