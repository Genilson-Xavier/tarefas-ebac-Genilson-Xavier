package br.com.tarefa_annotation.Model;

import br.com.tarefa_annotation.Tabela;

@Tabela(nomeDaTabela = "Cliente")
public class Cliente {
	
	private String nome;
	private int idade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
