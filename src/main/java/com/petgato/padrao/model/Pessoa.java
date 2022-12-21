/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.padrao.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author alessandra
 */
//@Inheritance(strategy = InheritanceType.JOINED)

@MappedSuperclass
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pessoaSequence")
    private Long id;
    private String nome;
    private String sobrenome;
//    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate idade;
    private String email;

    public Pessoa() {
    }

    public Pessoa(PessoaBuilder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.sobrenome = builder.sobrenome;
        this.idade = builder.idade;
        this.email = builder.email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getIdade() {
        return idade;
    }

    public void setIdade(LocalDate idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.id, other.getId());
    }

    public static class PessoaBuilder {

        private Long id;
        private String nome;
        private String sobrenome;
        private LocalDate idade;
        private String email;

        public PessoaBuilder() {

        }

        public PessoaBuilder whitId(Long value) {
            this.id = value;
            return this;
        }

        public PessoaBuilder whitNome(String value) {
            this.nome = value;
            return this;
        }

        public PessoaBuilder whitSobrenome(String value) {
            this.sobrenome = value;
            return this;
        }

        public PessoaBuilder whitIdade(LocalDate value) {
            this.idade = value;
            return this;
        }

        public PessoaBuilder whitEmail(String value) {
            this.email = value;
            return this;
        }

        public Pessoa build() {
            return new Pessoa(this);
        }
    }
}
