/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.model;

import com.petgato.padrao.model.Pessoa;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 *
 * @author alessandra
 */
@Entity
public class Usuario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String senha;
    private boolean bloqueado;
//  private String situacao;
    @ManyToOne
    private GrupoUsuario grupoUsuario;

    public Usuario() {
    }

    public Usuario(UsuarioBuilder builder) {
        super(builder);
        this.username = builder.username;
        this.senha = builder.senha;
        this.bloqueado = builder.bloqueado;
        this.grupoUsuario = builder.grupoUsuario;
    }
    
       public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public GrupoUsuario getGrupoUsuario() {
        return grupoUsuario;
    }

    public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
        this.grupoUsuario = grupoUsuario;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.getUsername());
        hash = 31 * hash + Objects.hashCode(this.getSenha());
        hash = 31 * hash + (this.isBloqueado() ? 1 : 0);
//        hash = 31 * hash + Objects.hashCode(this.getSituacao());
        hash = 31 * hash + Objects.hashCode(this.getGrupoUsuario());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.bloqueado != other.isBloqueado()) {
            return false;
        }
        if (!Objects.equals(this.username, other.getUsername())) {
            return false;
        }
        if (!Objects.equals(this.senha, other.getSenha())) {
            return false;
        }
//        if (!Objects.equals(this.situacao, other.getSenha())) {
//            return false;
//        }
        return Objects.equals(this.grupoUsuario, other.getGrupoUsuario());
    }

    public static class UsuarioBuilder extends PessoaBuilder {

        private Long id;
        private String username;
        private String senha;
        private boolean bloqueado;
//        private String situacao;
        private GrupoUsuario grupoUsuario;
        
         public UsuarioBuilder() {
        }

        public Usuario.UsuarioBuilder whitId(Long value) {
            this.id = value;
            return this;
        }
        
        public UsuarioBuilder whitUsername(String value) {
            this.username = value;
            return this;
        }

        public UsuarioBuilder whitSenha(String value) {
            this.senha = value;
            return this;
        }

        public UsuarioBuilder withBloqueado(boolean value) {
            this.bloqueado = value;
            return this;
        }

//        public UsuarioBuilder whitSituacao(String value) {
//            this.situacao = value;
//            return this;
//        }
        
         public UsuarioBuilder withGrupoUsuario(GrupoUsuario value) {
            this.grupoUsuario = value;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }
}
