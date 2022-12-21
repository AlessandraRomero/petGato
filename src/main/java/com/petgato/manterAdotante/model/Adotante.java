 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAdotante.model;

import com.petgato.manterBairro.model.Bairro;
import com.petgato.manterCidade.model.Cidade;
import com.petgato.manterLogradouro.model.Logradouro;
import com.petgato.padrao.model.Pessoa;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author alessandra
 */
@Entity
@Table(name = "adotante")
@SequenceGenerator(name = "adotanteSequence", sequenceName = "pessoaSequence", allocationSize = 1)
public class Adotante extends Pessoa {

    private String rg;
    private String cpf;
    private String telefone;
    private String referencia;
    private String complemento;
    private String numero;
    @ManyToOne
    private Cidade cidade;
    @ManyToOne
    private Logradouro logradouro;
    @ManyToOne
    private Bairro bairro;

    public Adotante() {

    }

    public Adotante(AdotanteBuilder builder) {
        super(builder);
        this.rg = builder.rg;
        this.cpf = builder.cpf;
        this.telefone = builder.telefone;
        this.referencia = builder.referencia;
        this.complemento = builder.complemento;
        this.numero = builder.numero;
        this.cidade = builder.cidade;
        this.bairro = builder.bairro;
        this.logradouro = builder.logradouro;

    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.rg);
        hash = 47 * hash + Objects.hashCode(this.cpf);
        hash = 47 * hash + Objects.hashCode(this.telefone);
        hash = 47 * hash + Objects.hashCode(this.referencia);
        hash = 47 * hash + Objects.hashCode(this.complemento);
        hash = 47 * hash + Objects.hashCode(this.numero);
        hash = 47 * hash + Objects.hashCode(this.cidade);
        hash = 47 * hash + Objects.hashCode(this.logradouro);
        hash = 47 * hash + Objects.hashCode(this.bairro);
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
        final Adotante other = (Adotante) obj;
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.referencia, other.referencia)) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.logradouro, other.logradouro)) {
            return false;
        }
        return Objects.equals(this.bairro, other.bairro);
    }

    
    

    public static class AdotanteBuilder extends PessoaBuilder {

        private Long id;
        private String rg;
        private String cpf;
        private String telefone;
        private String referencia;
        private String complemento;
        private String numero;
        @ManyToOne
        private Cidade cidade;
        @ManyToOne
        private Logradouro logradouro;
        @ManyToOne
        private Bairro bairro;

        public AdotanteBuilder() {
        }

        public AdotanteBuilder whitId(Long value) {
            this.id = value;
            return this;
        }

        public AdotanteBuilder whitRg(String value) {
            this.rg = value;
            return this;
        }

        public AdotanteBuilder whitCpf(String value) {
            this.cpf = value;
            return this;
        }
        
        public AdotanteBuilder whitTelefone(String value) {
            this.telefone = value;
            return this;
        }
        
        public AdotanteBuilder whitReferencia(String value) {
            this.referencia = value;
            return this;
        }
        
        public AdotanteBuilder whitComplemento(String value) {
            this.complemento = value;
            return this;
        }
        
        public AdotanteBuilder whitNumero(String value) {
            this.numero = value;
            return this;
        }
        
        public AdotanteBuilder whitCidade(Cidade value) {
            this.cidade = value;
            return this;
        }
        
        public AdotanteBuilder whitLogradouro(Logradouro value) {
            this.logradouro = value;
            return this;
        }
        
        public AdotanteBuilder whitBairro(Bairro value) {
            this.bairro = value;
            return this;
        }

        public Adotante build() {
            return new Adotante(this);
        }
    }
}
