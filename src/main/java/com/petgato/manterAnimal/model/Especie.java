/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.model;

import com.petgato.manterLogradouro.model.Logradouro;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alessandra
 */
@Entity
@Table(name = "especie")
public class Especie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Especie() {
    }

    public Especie(Especie.EspecieBuilder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final Especie other = (Especie) obj;
        return Objects.equals(this.id, other.getId());
    }

    public static class EspecieBuilder {

        private Long id;
        private String nome;

        public EspecieBuilder() {
        }

        public EspecieBuilder whitId(Long value) {
            this.id = value;
            return this;
        }

        public EspecieBuilder whitNome(String value) {
            this.nome = value;
            return this;
        }

        public Especie build() {
            return new Especie(this);
        }
    }
}
