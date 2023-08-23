package br.com.ebac.domain;

import javax.persistence.*;

@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marca_seq")
    @SequenceGenerator(name = "marca_seq",sequenceName = "seq_marca",initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(name = "NOME",length = 50, nullable = false)
    private String nome;

    @OneToOne
    @JoinColumn(name="id_carro_fk", foreignKey = @ForeignKey(name="fk_carro_marca"),referencedColumnName = "id", nullable = false)
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

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
