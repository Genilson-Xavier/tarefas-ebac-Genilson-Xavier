package br.com.ebac.usuario.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Usuario {
    @Id
    @SequenceGenerator(name = "SEQUENCEUSUARIO", sequenceName = "SEQUENCE_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "SEQUENCEUSUARIO")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    public Usuario() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Usuario(String nome, String email, Date dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

}
