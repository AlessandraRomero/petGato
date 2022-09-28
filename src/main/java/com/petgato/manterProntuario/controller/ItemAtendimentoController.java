/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.controller;

import com.petgato.manterProntuario.model.ItemAtendimento;
import com.petgato.manterProntuario.model.Produto;
import static com.petgato.manterProntuario.model.Produto_.nome;
import com.petgato.manterProntuario.repository.ItemAtendimentoRepository;


/**
 *
 * @author alessandra
 */
public class ItemAtendimentoController {

    private ItemAtendimentoRepository repository;
    

    public ItemAtendimentoController() {
        repository = new ItemAtendimentoRepository();
    }

    public void cadastrar(int quantidade) {

        ItemAtendimento item = new ItemAtendimento.ItemAtendimentoBuilder()
                .whitQuantidade(quantidade)
                .build();
        repository.save(item);
    }

    public ItemAtendimento buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, int quantidade) {
        ItemAtendimento item = buscarPorId(id);
        item.setQuantidade(quantidade);
        repository.update(item);
    }
    
    public void deletar(Long id){
        ItemAtendimento item = buscarPorId(id);
        repository.delete(item);
    }
}
