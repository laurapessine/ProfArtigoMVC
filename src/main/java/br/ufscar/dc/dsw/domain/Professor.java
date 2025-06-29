package br.ufscar.dc.dsw.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "Professor")
public class Professor extends AbstractEntity<Long> {

    @NotBlank(message = "{NotBlank.professor.nome}")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "{NotBlank.professor.email}")
    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String titulacao; // ex: "Mestrado", "Doutorado"

    @Column(unique = true)
    private String foto; // URL para a foto

    @Column(unique = true)
    private String lattes; // URL para o Lattes

    @ManyToMany
    @JoinTable(name = "Professor_Artigo", joinColumns = @JoinColumn(name = "professor_id"), inverseJoinColumns = @JoinColumn(name = "artigo_id"))
    private List<Artigo> artigos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLattes() {
        return lattes;
    }

    public void setLattes(String lattes) {
        this.lattes = lattes;
    }

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }
}