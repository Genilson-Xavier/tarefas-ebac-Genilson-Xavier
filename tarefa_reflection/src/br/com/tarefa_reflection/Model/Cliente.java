package br.com.tarefa_reflection.Model;

import br.com.tarefa_reflection.Tabela;

@Tabela(nomeDaTabela = "Cliente")
public class Cliente {
	@Tabela(nomeDaTabela = "Cliente", nomeDaColuna = "nome")
	private String nome;
	@Tabela(nomeDaTabela = "Cliente", nomeDaColuna = "idade")
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
