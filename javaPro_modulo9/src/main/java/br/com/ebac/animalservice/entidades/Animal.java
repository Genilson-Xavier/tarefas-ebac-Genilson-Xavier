package br.com.ebac.animalservice.entidades;

import br.com.ebac.animalservice.model.Porte;
import br.com.ebac.animalservice.model.TipoAnimal;
import br.com.ebac.animalservice.repositorios.FuncionariosDto;
import jakarta.persistence.*;

import java.sql.Date;

@NamedNativeQuery(name = "Animal.findRecebidosPorFuncionarios",
        query = "SELECT a.nome_recebedor nome, count(*) quantidadeRebebida FROM animal a where a.data_entrada between current_date - 365 and current_date group by a.nome_recebedor",
        resultSetMapping = "Mapping.FuncionariosDto")
@SqlResultSetMapping(name = "Mapping.FuncionariosDto",
        classes = @ConstructorResult(targetClass = FuncionariosDto.class,
                columns = {@ColumnResult(name = "nome"),
                        @ColumnResult(name = "quantidadeRebebida")}))
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    @Column(nullable = false)
    private String nomeProvisorio;

    @Column(nullable = false)
    private Integer idadeEstimada;

    @Column(nullable = false)
    private String raca;

    @Column(nullable = false)
    private Date dataEntrada;

    @Column
    private Date dataAdocao;

    @Column(nullable = false)
    private String condicoesChegada;

    @Column(nullable = false)
    private String nomeRecebedor;

    @Column
    private Date dataObito;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Porte porte;

    @Enumerated(EnumType.STRING)
    private TipoAnimal tipoAnimal;

    public String getNomeProvisorio() {
        return nomeProvisorio;
    }

    public void setNomeProvisorio(String nomeProvisorio) {
        this.nomeProvisorio = nomeProvisorio;
    }

    public Integer getIdadeEstimada() {
        return idadeEstimada;
    }

    public void setIdadeEstimada(Integer idadeEstimada) {
        this.idadeEstimada = idadeEstimada;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(Date dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    public String getCondicoesChegada() {
        return condicoesChegada;
    }

    public void setCondicoesChegada(String condicoesChegada) {
        this.condicoesChegada = condicoesChegada;
    }

    public String getNomeRecebedor() {
        return nomeRecebedor;
    }

    public void setNomeRecebedor(String nomeRecebedor) {
        this.nomeRecebedor = nomeRecebedor;
    }

    public Date getDataObito() {
        return dataObito;
    }

    public void setDataObito(Date dataObito) {
        this.dataObito = dataObito;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = Porte.valueOf(porte.toUpperCase());
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = TipoAnimal.valueOf(tipoAnimal.toUpperCase());
    }

    public Animal(String nomeProvisorio, Integer idadeEstimada, String raca, Date dataEntrada, Date dataAdocao, String condicoesChegada, String nomeRecebedor, Date dataObito, Porte porte, TipoAnimal tipoAnimal) {
        this.nomeProvisorio = nomeProvisorio;
        this.idadeEstimada = idadeEstimada;
        this.raca = raca;
        this.dataEntrada = dataEntrada;
        this.dataAdocao = dataAdocao;
        this.condicoesChegada = condicoesChegada;
        this.nomeRecebedor = nomeRecebedor;
        this.dataObito = dataObito;
        this.porte = porte;
        this.tipoAnimal = tipoAnimal;
    }

    public Animal() {
    }
}
