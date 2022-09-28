/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.controller;

import com.petgato.manterProntuario.model.Prontuario;
import com.petgato.manterProntuario.repository.ProntuarioRepository;
import java.time.LocalDate;

/**
 *
 * @author alessandra
 */
public class ProntuarioController {

    private ProntuarioRepository repository;

    public ProntuarioController() {
        repository = new ProntuarioRepository();
    }

    public void cadastrar(LocalDate data, String vacina, String medicacao, String observacao, String condutaTomada) {
        Prontuario pront = new Prontuario.ProntuarioBuilder()
                .whitData(data)
                .whitVacina(vacina)
                .whitMedicacao(medicacao)
                .whitObservacao(observacao)
                .whitCondutaTomada(condutaTomada)
                .build();
        repository.save(pront);
    }

    public Prontuario buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, LocalDate data, String vacina, String medicacao, String observacao, String condutaTomada) {
        Prontuario pront = buscarPorId(id);
        pront.setData(data);
        pront.setVacina(vacina);
        pront.setMedicacao(medicacao);
        pront.setObservacao(observacao);
        pront.setCondutaTomada(condutaTomada);

        repository.update(pront);
    }

    public void deletar(Long id) {
        Prontuario pront = buscarPorId(id);
        repository.delete(pront);
    }

}
