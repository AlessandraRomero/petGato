/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author alessandra
 */
@Embeddable
public class VisitaId implements Serializable {

    private Long id;

    @Column(name = "adocao_id")
    private Long adocao_id;

    public VisitaId() {
    }

    public VisitaId(Long id, Long adocao_id) {
        this.id = id;
        this.adocao_id = adocao_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdocao_id() {
        return adocao_id;
    }

    public void setAdocao_id(Long adocao_id) {
        this.adocao_id = adocao_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.adocao_id);
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
        final VisitaId other = (VisitaId) obj;
        if (!Objects.equals(this.id, other.getId())) {
            return false;
        }
        return Objects.equals(this.adocao_id, other.getAdocao_id());
    }

   
}
