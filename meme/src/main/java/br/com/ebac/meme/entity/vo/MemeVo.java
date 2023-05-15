package br.com.ebac.meme.entity.vo;


import java.sql.Date;

public class MemeVo {
    private String nome;

    private String url;

    private String descricao;

    private Date dataCadastro;

    private String nomeUsuario;

    private Integer idUsuario;

    private String nomeCategoria;

    private Integer idCategoria;

    public MemeVo() {
    }

    public MemeVo(String nome, String url, String descricao, Date dataCadastro, Integer idUsuario, Integer idCategoria) {
        this.nome = nome;
        this.url = url;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
    }

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

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
