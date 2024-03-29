/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.model;

import java.io.Serializable;
import java.time.LocalDate;
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
    private LocalDate dataResgate;
    @ManyToOne
    private Especie especie;
    @ManyToOne
    private Raca raca;

    public Animal() {
    }

    public Animal(Animal.AnimalBuilder builder) {
        super();
        this.id = builder.id;
        this.nome = builder.nome;
        this.idade = builder.idade;
        this.sexo = builder.sexo;
        this.peso = builder.peso;
        this.dataResgate = builder.dataResgate;
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

    public LocalDate getDataResgate() {
        return dataResgate;
    }

    public void setDataResgate(LocalDate dataResgate) {
        this.dataResgate = dataResgate;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Float.floatToIntBits(this.idade);
        hash = 37 * hash + Objects.hashCode(this.sexo);
        hash = 37 * hash + Float.floatToIntBits(this.peso);
        hash = 37 * hash + Objects.hashCode(this.dataResgate);
        hash = 37 * hash + Objects.hashCode(this.especie);
        hash = 37 * hash + Objects.hashCode(this.raca);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        final Animal other = (Animal) obj;
        if (Float.floatToIntBits(this.idade) != Float.floatToIntBits(other.idade)) {
            return false;
        }
        if (Float.floatToIntBits(this.peso) != Float.floatToIntBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataResgate, other.dataResgate)) {
            return false;
        }
        if (!Objects.equals(this.especie, other.especie)) {
            return false;
        }
        
        return Objects.equals(this.raca, other.raca);
    }

    public static class AnimalBuilder {

        private Long id;
        private String nome;
        private float idade;
        private String sexo;
        private float peso;
        private LocalDate dataResgate;
        private Especie especie;
        private Raca raca;

        public AnimalBuilder() {
        }

        public Animal.AnimalBuilder withId(Long value) {
            this.id = value;
            return this;
        }

        public AnimalBuilder withName(String value) {
            this.nome = value;
            return this;
        }

        public AnimalBuilder withIdade(float value) {
            this.idade = value;
            return this;
        }

        public AnimalBuilder withSexo(String value) {
            this.sexo = value;
            return this;
        }

        public AnimalBuilder withPeso(float value) {
            this.peso = value;
            return this;
        }

        public AnimalBuilder withEspecie(Especie value) {
            this.especie = value;
            return this;
        }

        public AnimalBuilder withRaca(Raca value) {
            this.raca = value;
            return this;
        }

        public AnimalBuilder withDataResgate(LocalDate value) {
            this.dataResgate = value;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }
}
