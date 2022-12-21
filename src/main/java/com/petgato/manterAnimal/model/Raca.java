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
import javax.persistence.Table;

/**
 *
 * @author alessandra
 */
@Entity
@Table(name = "raca")
public class Raca implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    public Raca (){
    }
    
    public Raca(Raca.RacaBuilder builder) {
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
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final Raca other = (Raca) obj;
        return Objects.equals(this.id, other.getId());
    }    

    @Override
    public String toString() {
        return nome;
    }
    
    
     public static class RacaBuilder {

        private Long id;
        private String nome;

        public RacaBuilder() {
        }

        public RacaBuilder whitId(Long value) {
            this.id = value;
            return this;
        }

        public RacaBuilder whitNome(String value) {
            this.nome = value;
            return this;
        }

        public Raca build() {
            return new Raca(this);
        }
    }
}
