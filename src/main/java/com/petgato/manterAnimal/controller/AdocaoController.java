/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.controller;

import com.petgato.manterAdotante.model.Adotante;
import com.petgato.manterAnimal.model.Adocao;
import com.petgato.manterAnimal.model.Adotado;
import com.petgato.manterAnimal.model.Animal;
import com.petgato.manterAnimal.model.Visita;
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

    public void cadastrar(LocalDate dataEmissao, Adotante adotante,
            Usuario atendente, List<Adotado> adotados, List<Visita> visitas) {
        Adocao adocao = new Adocao.AdocaoBuilder()
                .whitDataEmissao(dataEmissao)
                .whitAdotante(adotante)
                .whitAtendente(atendente)
                //                .whitStatus(status)
                .build();
        for (int i = 0; i < visitas.size(); i++) {
            visitas.get(i).setAdocao(adocao);
        }
        for (int i = 0; i < adotados.size(); i++) {
            adotados.get(i).setAdocao(adocao);
        }
        adocao.setVisitas(visitas);
        adocao.setAdotados(adotados);
        repository.save(adocao);
    }

    public Adocao buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, Adotante adotante,
        Usuario atendente, List<Adotado> adotados, List<Visita> visitas) {
        Adocao adocao = buscarPorId(id);
        adocao.setAdotante(adotante);
        adocao.setAtendente(atendente);
        adocao.setAdotados(adotados);
//        adocao.setStatus(status);
        adocao.setVisitas(visitas);
        repository.update(adocao);
    }

    public void deletar(Long id) {
        Adocao adocao = buscarPorId(id);
        repository.delete(adocao);
    }

    public Animal buscarPorNome(String nome) {
        return (Animal) repository.findByNome(nome);
    }
}
