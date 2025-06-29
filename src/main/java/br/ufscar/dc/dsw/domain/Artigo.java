package br.ufscar.dc.dsw.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "Artigo")
public class Artigo extends AbstractEntity<Long> {

    @NotBlank(message = "{NotBlank.artigo.titulo}")
    @Column(nullable = false)
    private String titulo;

    @Column
    private String resumo;

    @Column
    private String palavrasChave;

    @NotNull(message = "{NotNull.artigo.ano}")
    @Column(nullable = false)
    private Integer anoPublicacao;

    @Column
    private String linkPublicacao;

    @ManyToMany(mappedBy = "artigos")
    private List<Professor> autores;

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
}