/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAdotante.controller;

import com.petgato.manterAdotante.model.Adotante;
import com.petgato.manterAdotante.repository.AdotanteRepository;
import com.petgato.manterBairro.model.Bairro;
import com.petgato.manterCidade.model.Cidade;
import com.petgato.manterLogradouro.model.Logradouro;
import java.time.LocalDate;

/**
 *
 * @author alessandra
 */
public class AdotanteController {
    
     private AdotanteRepository repository;

    public AdotanteController() {
        this.repository = new AdotanteRepository();
    }
    
     public void cadastrar(String nome, String sobrenome, LocalDate idade, String email, 
             String rg, String cpf, String telefone, String referencia, String complemento, 
             String numero, Cidade cidade, Bairro bairro, Logradouro logradouro) {
        Adotante adotante = (Adotante)new Adotante.AdotanteBuilder()
                .whitTelefone(telefone)
                .whitReferencia(referencia)
                .whitComplemento(complemento)
                .whitNumero(numero)
                .whitCidade(cidade)
                .whitBairro(bairro)
                .whitLogradouro(logradouro)
                .whitRg(rg)
                .whitCpf(cpf)
                .whitNome(nome)
                .whitSobrenome(sobrenome)
                .whitIdade(idade)
                .whitEmail(email)
                .build();
        repository.save(adotante);
    }
     
     public Adotante buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void atualizar(Long id, String nome, String sobrenome, LocalDate idade, 
            String email, String rg, String cpf, String telefone, String referencia, String complemento, 
             String numero, Cidade cidade, Bairro bairro, Logradouro logradouro) {
        Adotante adotante = buscarPorId(id);
        adotante.setSobrenome(sobrenome);
        adotante.setNome(nome);
        adotante.setIdade(idade);
        adotante.setEmail(email);
        adotante.setRg(rg);
        adotante.setCpf(cpf);
        adotante.setTelefone(telefone);
        adotante.setReferencia(referencia);
        adotante.setComplemento(complemento);
        adotante.setNumero(numero);
        adotante.setCidade(cidade);
        adotante.setBairro(bairro);
        adotante.setLogradouro(logradouro);
        repository.update(adotante);
    }
    
    public void deletar(Long id){
        Adotante animal = buscarPorId(id);
        repository.delete(animal);
    }
    
    public Adotante buscarPorNome(String nome){
        return (Adotante) repository.findByNome(nome);
    }
}
