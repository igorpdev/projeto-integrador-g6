package com.egaliteSiX.beequalite.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 255)
    private String nome;

    @NotNull
    @Size(max = 255)
    private String email;

    @NotNull
    private String senha;

    private String foto;

    private String tipo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
    private List<Postagem> postagem;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
      return this.foto;
    }

    public void setFoto(String foto) {
      this.foto = foto;
    }

    public String getTipo() {
      return this.tipo;
    }

    public void setTipo(String tipo) {
      this.tipo = tipo;
    }

    public List<Postagem> getPostagem() {
      return this.postagem;
    }

    public void setPostagem(List<Postagem> postagem) {
      this.postagem = postagem;
    }

}
