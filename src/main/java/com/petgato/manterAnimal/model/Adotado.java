/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alessandra
 */
@Entity
@Table(name = "adotado")
public class Adotado implements Serializable {

    @EmbeddedId
    private AdotadoId id;
    private LocalDate dataAdocao;
    private Boolean isAdotado;

    @OneToMany(mappedBy = "adotado",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Animal> animais;

    @MapsId("adocao_id")
    @ManyToOne
    private Adocao adocao;

    public Adotado() {
    }

    public Adotado(AdotadoBuilder builder) {
        this.id = builder.id;
        this.dataAdocao = builder.dataAdocao;
        this.isAdotado = builder.isAdotado;
        this.animais = builder.animais;
    }

    public AdotadoId getId() {
        return id;
    }

    public void setId(AdotadoId id) {
        this.id = id;
    }

    public LocalDate getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(LocalDate dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    public boolean isAdotado() {
        return isAdotado;
    }

    public void setAdotado(Boolean isAdotado) {
        this.isAdotado = isAdotado;
    }

    public Boolean getIsAdotado() {
        return isAdotado;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public Adocao getAdocao() {
        return adocao;
    }

    public void setAdocao(Adocao adocao) {
        this.adocao = adocao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.dataAdocao);
        hash = 41 * hash + Objects.hashCode(this.isAdotado);
        hash = 41 * hash + Objects.hashCode(this.animais);
        hash = 41 * hash + Objects.hashCode(this.adocao);
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
        if (!Objects.equals(this.id, other.getId())) {
            return false;
        }
        if (!Objects.equals(this.dataAdocao, other.getDataAdocao())) {
            return false;
        }
        if (!Objects.equals(this.isAdotado, other.isAdotado)) {
            return false;
        }
        if (!Objects.equals(this.animais, other.animais)) {
            return false;
        }
        return Objects.equals(this.adocao, other.adocao);
    }

    public static class AdotadoBuilder {

        private AdotadoId id;
        private LocalDate dataAdocao;
        private boolean isAdotado;
        @OneToMany(mappedBy = "Adotado",
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                orphanRemoval = true)
        private List<Animal> animais;

        @MapsId("adocao_id")
        @ManyToOne
        private Adocao adocao;
//        
//        @ManyToOne
//        private Adocao adocao;

        public AdotadoBuilder() {

        }

        public Adotado.AdotadoBuilder withId(AdotadoId value) {
            this.id = value;
            return this;
        }

        public Adotado.AdotadoBuilder withDataAdocao(LocalDate value) {
            this.dataAdocao = value;
            return this;
        }

        public Adotado.AdotadoBuilder withIsAdotado(boolean value) {
            this.isAdotado = value;
            return this;
        }

        public Adotado.AdotadoBuilder withAdocao(Adocao value) {
            this.adocao = value;
            return this;
        }

        public Adotado.AdotadoBuilder withAnimais(List value) {
//          this.id.setAnimais(value);
            this.animais = value;
            return this;
        }

        public Adotado build() {
            return new Adotado(this);
        }
    }
}
