package br.com.ebac.categoria.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Categoria {
    @Id
    @SequenceGenerator(name = "SEQUENCECATEGORIAMEME", sequenceName = "SEQUENCE_CATEGORIA_MEME", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "SEQUENCECATEGORIAMEME")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    public Categoria() {}

    public Integer getId() {
        return id;
    }

    /*public void setId(Integer id) {
        this.id = id;
    }*/

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

    public Categoria(String nome, String descricao, Date dataCadastro, Integer idUsuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.idUsuario = idUsuario;
    }

}
