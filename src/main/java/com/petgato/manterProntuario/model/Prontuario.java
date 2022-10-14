/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.model;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "prontuario")
public class Prontuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private String vacina;
    private String medicacao;
    private String observacao;
    private String condutaTomada;

    public Prontuario() {
    }

    public Prontuario(ProntuarioBuilder builder) {
        this.id = builder.id;
        this.data = builder.data;
        this.vacina = builder.vacina;
        this.medicacao = builder.medicacao;
        this.observacao = builder.observacao;
        this.condutaTomada = builder.condutaTomada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getCondutaTomada() {
        return condutaTomada;
    }

    public void setCondutaTomada(String condutaTomada) {
        this.condutaTomada = condutaTomada;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Prontuario other = (Prontuario) obj;
        return Objects.equals(this.id, other.getId());
    }

    public static class ProntuarioBuilder {

        private Long id;
        private LocalDate data;
        private String vacina;
        private String medicacao;
        private String observacao;
        private String condutaTomada;

        public ProntuarioBuilder() {

        }

        public ProntuarioBuilder whitId(Long value) {
            this.id = value;
            return this;
        }

        public ProntuarioBuilder whitData(LocalDate value) {
            this.data = value;
            return this;
        }

        public ProntuarioBuilder whitVacina(String value) {
            this.vacina = value;
            return this;
        }

        public ProntuarioBuilder whitMedicacao(String value) {
            this.medicacao = value;
            return this;
        }

        public ProntuarioBuilder whitObservacao(String value) {
            this.observacao = value;
            return this;
        }

        public ProntuarioBuilder whitCondutaTomada(String value) {
            this.condutaTomada = value;
            return this;
        }

        public Prontuario build() {
            return new Prontuario(this);
        }
    }
}
