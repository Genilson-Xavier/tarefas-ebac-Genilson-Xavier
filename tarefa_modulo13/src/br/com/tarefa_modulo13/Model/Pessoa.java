package br.com.tarefa_modulo13.Model;

import java.util.Objects;

public abstract class Pessoa {
	private String nome;
	private int idade;
	private String logradouro;
	private String bairro;
	private int numero;
	private String complemento;
	private String cep;
	
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
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Pessoa(String nome, int idade, String logradouro, String bairro, int numero, String complemento,
			String cep) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}
	
	public Pessoa() {
		super();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, complemento, idade, logradouro, nome, numero);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(complemento, other.complemento) && idade == other.idade
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(nome, other.nome)
				&& numero == other.numero;
	}
	@Override
	public String toString() {
		return "nome=" + nome + ", idade=" + idade + ", logradouro=" + logradouro + ", bairro=" + bairro
				+ ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep + "";
	}
	
	
}
