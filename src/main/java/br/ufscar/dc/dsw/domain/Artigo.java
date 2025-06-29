package br.ufscar.dc.dsw.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "Artigo")
public class Artigo extends AbstractEntity<Long> {

    @NotBlank(message = "{NotBlank.artigo.titulo}")
    @Column(nullable = false)
    private String titulo;

    @Column(length = 2000)
    private String resumo;

    @Column
    private String palavrasChave;

    @NotNull(message = "{NotNull.artigo.anoPublicacao}")
    @Column(nullable = false)
    private Integer anoPublicacao;

    @Column
    private String linkPublicacao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Professor_Artigo", joinColumns = @JoinColumn(name = "artigo_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<Professor> autores = new ArrayList<>();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getLinkPublicacao() {
        return linkPublicacao;
    }

    public void setLinkPublicacao(String linkPublicacao) {
        this.linkPublicacao = linkPublicacao;
    }

    public List<Professor> getAutores() {
        return autores;
    }

    public void setAutores(List<Professor> autores) {
        this.autores = autores;
    }

    public void addAutor(Professor autor) {
        this.autores.add(autor);
        autor.getArtigos().add(this);
    }
}