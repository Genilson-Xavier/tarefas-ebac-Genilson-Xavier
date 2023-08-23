package br.com.ebac.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carro")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq",sequenceName = "seq_carro",initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(name = "NOME",length = 50, nullable = false)
    private String nome;

    @Column(name = "PLACA",length = 50, nullable = false)
    private String placa;

    @OneToOne(mappedBy = "carro")
    private Marca marca;

    @OneToMany(mappedBy = "carro")
    private List<Acessorio> acessorios;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
}
