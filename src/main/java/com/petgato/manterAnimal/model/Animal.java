/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author alessandra
 */
@Entity
@Table(name = "animal")
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private float idade;
    private String sexo;
    private float peso;
    @ManyToOne
    private Especie especie;
    @ManyToOne
    private Raca raca;

    public Animal() {
    }

    public Animal(AnimalBuilder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.idade = builder.idade;
        this.sexo = builder.sexo;
        this.peso = builder.peso;
        this.especie = builder.especie;
        this.raca = builder.raca;
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

    public float getIdade() {
        return idade;
    }

    public void setIdade(float idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final Animal other = (Animal) obj;
        return Objects.equals(this.id, other.getId());
    }

    public static class AnimalBuilder {

        private Long id;
        private String nome;
        private float idade;
        private String sexo;
        private float peso;
        @ManyToOne
        private Especie especie;
        @ManyToOne
        private Raca raca;

        public AnimalBuilder() {
        }

        public Animal.AnimalBuilder whitId(Long value) {
            this.id = value;
            return this;
        }

        public AnimalBuilder whitName(String value) {
            this.nome = value;
            return this;
        }

        public AnimalBuilder whitIdade(float value) {
            this.idade = value;
            return this;
        }

        public AnimalBuilder whitSexo(String value) {
            this.sexo = value;
            return this;
        }

        public AnimalBuilder whitPeso(float value) {
            this.peso = value;
            return this;
        }

        public AnimalBuilder whitEspecie(Especie value){
            this.especie = value;
            return this;
        }
        
        public AnimalBuilder whitRaca(Raca value){
            this.raca = value;
            return this;
        }
        
        public Animal build() {
            return new Animal(this);
        }
    }
}
