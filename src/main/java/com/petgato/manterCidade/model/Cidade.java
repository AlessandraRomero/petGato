/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterCidade.model;

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
@Table(name = "cidade")
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String uf;

    public Cidade() {
    }

    public Cidade(CidadeBuilder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.uf = builder.uf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        return Objects.equals(this.id, other.getId());
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    public static class CidadeBuilder {

        private Long id;
        private String nome;
        private String uf;

        public CidadeBuilder() {
        }

        public CidadeBuilder whitId(Long value) {
            this.id = value;
            return this;
        }

        public CidadeBuilder whitNome(String value) {
            this.nome = value;
            return this;
        }
        
         public CidadeBuilder whitUf(String value) {
            this.uf = value;
            return this;
        }

        public Cidade build() {
            return new Cidade(this);
        }
    }
}
