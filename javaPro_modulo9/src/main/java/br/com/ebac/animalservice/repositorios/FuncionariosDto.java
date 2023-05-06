package br.com.ebac.animalservice.repositorios;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FuncionariosDto {
    @JsonProperty(value = "Nome do Funcionario")
    private String nome;
    @JsonProperty(value = "Quantidade de animais Recebidos")
    private long quantidadeRebebida;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getQuantidadeRebebida() {
        return quantidadeRebebida;
    }

    public void setQuantidadeRebebida(long quantidadeRebebida) {
        this.quantidadeRebebida = quantidadeRebebida;
    }

    public FuncionariosDto(String nome, long quantidadeRebebida) {
        this.nome = nome;
        this.quantidadeRebebida = quantidadeRebebida;
    }

    public FuncionariosDto() {
    }
}
