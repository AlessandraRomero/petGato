/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.model;

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
@Table(name = "grupo_usuario")
public class GrupoUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public GrupoUsuario() {
    }
    
    public GrupoUsuario(GrupoUsuarioBuilder builder){
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
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final GrupoUsuario other = (GrupoUsuario) obj;
        return Objects.equals(this.id, other.getId());
    }

    public static class GrupoUsuarioBuilder {

        private Long id;
        private String nome;

        public GrupoUsuarioBuilder() {
        }

        public GrupoUsuarioBuilder whitId(Long value) {
            this.id = value;
            return this;
        }

        public GrupoUsuarioBuilder whitNome(String value) {
            this.nome = value;
            return this;
        }

        public GrupoUsuario build(){
         return new GrupoUsuario(this);
        }
    }
}
