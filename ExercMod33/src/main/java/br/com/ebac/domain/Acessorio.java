package br.com.ebac.domain;

import javax.persistence.*;

@Entity
@Table(name = "acessorio")
public class Acessorio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio_seq")
    @SequenceGenerator(name = "acessorio_seq",sequenceName = "seq_acessorio",initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(name = "NOME",length = 50, nullable = false)
    private String nome;

    @Column(name = "DESCRICAO",length = 300, nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name="id_carro_fk", foreignKey = @ForeignKey(name="fk_carro_acessorio"),referencedColumnName = "id", nullable = false)
    private Carro carro;

    public Long getId() {
        return id;
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

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
