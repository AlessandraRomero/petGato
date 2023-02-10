/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.model;

import com.petgato.manterAdotante.model.Adotante;
import com.petgato.manterAnimal.model.enums.Status;
import com.petgato.manterUsuario.model.Usuario;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alessandra
 */
@Entity
@Table(name = "adocao")
public class Adocao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataEmissao;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Adotante adotante;
    @ManyToOne
    private Usuario atendente;
    @OneToMany(mappedBy = "id.adocao",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Adotado> adotados;
    @OneToMany(mappedBy = "id.adocao",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Visita> visitas;

    public Adocao() {
        visitas = new ArrayList();
        adotados = new ArrayList();
    }

    public Adocao(AdocaoBuilder builder) {
        this.id = builder.id;
        this.dataEmissao = builder.dataEmissao;
        this.status = builder.status;
        this.adotante = builder.adotante;
        this.atendente = builder.atendente;
        this.adotados = builder.adotados;
        this.visitas = builder.visitas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
    }

    public Usuario getAtendente() {
        return atendente;
    }

    public void setAtendente(Usuario atendente) {
        this.atendente = atendente;
    }

    public List<Adotado> getAdotados() {
        return adotados;
    }

    public void setAdotados(List<Adotado> adotados) {
        this.adotados = adotados;
    }

    public List<Visita> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<Visita> visitas) {
        this.visitas = visitas;
    }

    public void adicionar(Adotado adotado) {
        adotados.add(adotado);
    }

    public void remover(Adotado adotado) {
        adotados.remove(adotado);
    }

    public void adicionar(Visita visita) {
        visitas.add(visita);
    }

    public void remover(Visita visita) {
        visitas.remove(visita);
    }

    public Long proximoSequenciaVisita() {

        if (visitas.isEmpty()) {
            return 1L;
        } else {
            Long idVisita;
            int indice = visitas.size() - 1;

            Visita visita = visitas.get(indice);
            idVisita = visita.getId().getId();

            return idVisita + 1;
        }
    }

    public Long proximaSequenciaAdotado() {

        if (adotados.isEmpty()) {
            return 1L;
        } else {
            Long idAdotado;
            int indice = adotados.size() - 1;

            Adotado adotado = adotados.get(indice);
            idAdotado = adotado.getId().getId();

            return idAdotado + 1;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.dataEmissao);
        hash = 71 * hash + Objects.hashCode(this.status);
        hash = 71 * hash + Objects.hashCode(this.adotante);
        hash = 71 * hash + Objects.hashCode(this.atendente);
        hash = 71 * hash + Objects.hashCode(this.adotados);
        hash = 71 * hash + Objects.hashCode(this.visitas);
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
        final Adocao other = (Adocao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataEmissao, other.dataEmissao)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.adotante, other.adotante)) {
            return false;
        }
        if (!Objects.equals(this.atendente, other.atendente)) {
            return false;
        }
        if (!Objects.equals(this.adotados, other.adotados)) {
            return false;
        }
        return Objects.equals(this.visitas, other.visitas);
    }

    public static class AdocaoBuilder {

        private Long id;
        private LocalDate dataEmissao;
        private Status status;
        @ManyToOne
        private Adotante adotante;
        @ManyToOne
        private Usuario atendente;
        @OneToMany(mappedBy = "adocao",
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                orphanRemoval = true)
        private List<Adotado> adotados;
        @OneToMany(mappedBy = "adocao",
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                orphanRemoval = true)
        private List<Visita> visitas;

        public AdocaoBuilder() {
            visitas = new ArrayList();
            adotados = new ArrayList();
        }

        public Adocao.AdocaoBuilder whitId(Long value) {
            this.id = value;
            return this;
        }

        public Adocao.AdocaoBuilder whitDataEmissao(LocalDate value) {
            this.dataEmissao = value;
            return this;
        }

        public Adocao.AdocaoBuilder whitStatus(Status value) {
            this.status = value;
            return this;
        }

        public Adocao.AdocaoBuilder whitAdotante(Adotante value) {
            this.adotante = value;
            return this;
        }

        public Adocao.AdocaoBuilder whitAtendente(Usuario value) {
            this.atendente = value;
            return this;
        }

        public Adocao.AdocaoBuilder whitAdotados(List<Adotado> value) {
            this.adotados = value;
            return this;
        }

        public Adocao.AdocaoBuilder whitVisitas(List<Visita> value) {        
            this.visitas = value;
            return this;
        }
        

        public Adocao build() {
            return new Adocao(this);
        }
    }
}
