/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.controller;

import com.petgato.manterAdotante.model.Adotante;
import com.petgato.manterAnimal.model.Adocao;
import com.petgato.manterAnimal.model.Animal;
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
             Usuario atendente) {
        Adocao adocao = new Adocao.AdocaoBuilder()
                .whitDataEmissao(dataEmissao)
                .whitStatus(status)
                .whitAdotante(adotante)
                .whitAdotante(adotante)
                .whitAtendente(atendente)
//                .whitAdotados(adotados)
//                .whitVisitas(Visitas)
                .build();
        repository.save(adocao);
    }
     
     public Adocao buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, LocalDate dataEmissao, Status status, Adotante adotante,
             Usuario atendente, List adotados, List Visitas) {
        Adocao adocao = buscarPorId(id);
        adocao.setDataEmissao(dataEmissao);
        adocao.setStatus(status);
        adocao.setAdotante(adotante);
        adocao.setAtendente(atendente);
        adocao.setAdotados(adotados);
        adocao.setVisitas(Visitas);
        repository.update(adocao);
    }
    
    public void deletar(Long id){
        Adocao adocao = buscarPorId(id);
        repository.delete(adocao);
    }
    
    public Animal buscarPorNome(String nome){
        return (Animal) repository.findByNome(nome);
    }
}
