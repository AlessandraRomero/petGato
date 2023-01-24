/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.ManyToOne;

/**
 *
 * @author alessandra
 */
public class Adotado implements Serializable {

    private Long id;
    private LocalDate dataAdocao;
    private boolean adotado;
    @ManyToOne
    private Adocao adocao;

    public Adotado() {
    }

    public Adotado(AdotadoBuilder builder) {
        this.id = builder.id;
        this.dataAdocao = builder.dataAdocao;
        this.adotado = builder.adotado;
        this.adocao = builder.adocao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(LocalDate dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    public boolean isAdotado() {
        return adotado;
    }

    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }

    public Adocao getAdocao() {
        return adocao;
    }

    public void setAdocao(Adocao adocao) {
        this.adocao = adocao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.dataAdocao);
        hash = 83 * hash + (this.adotado ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.adocao);
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
        final Adotado other = (Adotado) obj;
        if (this.adotado != other.adotado) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataAdocao, other.dataAdocao)) {
            return false;
        }
        return Objects.equals(this.adocao, other.adocao);
    }
    
    

    public static class AdotadoBuilder {

        private Long id;
        private LocalDate dataAdocao;
        private boolean adotado;
        @ManyToOne
        private Adocao adocao;

        public AdotadoBuilder() {

        }

        public Adotado.AdotadoBuilder whitId(Long value) {
            this.id = value;
            return this;
        }

        public Adotado.AdotadoBuilder whitDataAdocao(LocalDate value) {
            this.dataAdocao = value;
            return this;
        }

        public Adotado.AdotadoBuilder whitAdotado(boolean value) {
            this.adotado = value;
            return this;
        }

        public Adotado.AdotadoBuilder whitAdocao(Adocao value) {
            this.adocao = value;
            return this;
        }

        public Adotado build() {
            return new Adotado(this);
        }
    }
}
