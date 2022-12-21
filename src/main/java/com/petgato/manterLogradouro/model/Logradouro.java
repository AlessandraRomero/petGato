/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterLogradouro.model;

import com.petgato.manterBairro.model.Bairro;
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
@Table(name = "logradouro")
public class Logradouro implements Serializable  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    public Logradouro(){
    }
    
    public Logradouro(LogradouroBuilder builder){
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
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final Logradouro other = (Logradouro) obj;
        return Objects.equals(this.id, other.getId());
    }   

    @Override
    public String toString() {
        return nome;
    }
    
    public static class LogradouroBuilder{
         private Long id;
        private String nome;

        public LogradouroBuilder() {
        }

        public LogradouroBuilder whitId(Long value) {
            this.id = value;
            return this;
        }

        public LogradouroBuilder whitNome(String value) {
            this.nome = value;
            return this;
        }

        public Logradouro build(){
         return new Logradouro(this);
        }
    }
}
