package br.com.ebac.meme.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Meme {
    @Id
    @SequenceGenerator(name = "SEQUENCEMEME", sequenceName = "SEQUENCE_MEME", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "SEQUENCEMEME")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "id_categoria", nullable = false)
    private Integer idCategoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Meme() {
    }

    public Meme(String nome, String url, String descricao, Date dataCadastro, Integer idUsuario, Integer idCategoria) {
        this.nome = nome;
        this.url = url;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
    }
}
