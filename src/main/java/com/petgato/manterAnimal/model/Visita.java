/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.model;

import com.petgato.manterAnimal.model.enums.Status;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author alessandra
 */
@Entity
@Table(name = "visita")
public class Visita implements Serializable {

    @EmbeddedId
    private VisitaId id;
    private LocalDate dataVisita;
    private String observacao;
    private Status status;

    public Visita() {
    }

    public Visita(VisitaBuilder builder) {
        this.id = builder.id;
        this.dataVisita = builder.dataVisita;
        this.observacao = builder.observacao;
        this.status = builder.status;

    }

    public VisitaId getId() {
        return id;
    }

    public void setId(VisitaId id) {
        this.id = id;
    }

    public LocalDate getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(LocalDate dataVisita) {
        this.dataVisita = dataVisita;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Adocao getAdocao() {
        return id.getAdocao();
    }

    public void setAdocao(Adocao adocao) {
        this.id.setAdocao(adocao);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.dataVisita);
        hash = 73 * hash + Objects.hashCode(this.observacao);
        hash = 73 * hash + Objects.hashCode(this.status);
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Visita other = (Visita) obj;
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataVisita, other.dataVisita)) {
            return false;
        }
        return Objects.equals(this.status, other.status);
    }

    public static class VisitaBuilder {

        private VisitaId id;
        private LocalDate dataVisita;
        private String observacao;
        private Status status;

        public VisitaBuilder() {
        }

        public Visita.VisitaBuilder whitId(VisitaId value) {
            this.id = value;
            return this;
        }

        public Visita.VisitaBuilder whitDataVisita(LocalDate value) {
            this.dataVisita = value;
            return this;
        }

        public Visita.VisitaBuilder whitObservacao(String value) {
            this.observacao = value;
            return this;
        }

        public Visita.VisitaBuilder whitStatus(Status value) {
            this.status = value;
            return this;
        }

        public Visita.VisitaBuilder whitAdocao(Adocao value) {
            this.id.setAdocao(value);
            return this;
        }

        public Visita build() {
            return new Visita(this);
        }
    }
}
