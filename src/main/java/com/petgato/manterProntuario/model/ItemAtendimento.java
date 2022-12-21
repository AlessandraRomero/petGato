/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.model;

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
@Table(name = "item_atendimento")
public class ItemAtendimento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    
    public ItemAtendimento(){
    }
    
    public ItemAtendimento(ItemAtendimentoBuilder builder){
        this.id = builder.id;
        this.quantidade = builder.quantidade;
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final ItemAtendimento other = (ItemAtendimento) obj;
        return Objects.equals(this.id, other.getId());
    }
    
     public static class ItemAtendimentoBuilder {

        private Long id;
        private int quantidade;

        public ItemAtendimentoBuilder() {
        }

        public ItemAtendimentoBuilder whitId(Long value) {
            this.id = value;
            return this;
        }

        public ItemAtendimentoBuilder whitQuantidade(int value) {
            this.quantidade = value;
            return this;
        }

        public ItemAtendimento build(){
         return new ItemAtendimento(this);
        }
    }
}
