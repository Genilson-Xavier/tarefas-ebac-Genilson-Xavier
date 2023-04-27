package br.com.testesParte1.Model;

import java.util.Objects;

public class Pessoa {
	
	private String nome;
	
	private char sexo;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, sexo);
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
		return Objects.equals(nome, other.nome) && sexo == other.sexo;
	}

	public Pessoa(String nome, String sexo) {
		super();
		this.nome = nome;
		this.sexo = sexo.charAt(0);
	}

	public Pessoa() {
		super();
	}
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", sexo=" + sexo + "]";
	}
	
}
