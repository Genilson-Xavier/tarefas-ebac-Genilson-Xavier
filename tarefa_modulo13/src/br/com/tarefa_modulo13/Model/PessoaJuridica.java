package br.com.tarefa_modulo13.Model;

import java.util.Objects;

public class PessoaJuridica extends Pessoa{
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public PessoaJuridica(String nome, int idade, String logradouro, String bairro, int numero, String complemento,
			String cep, String cnpj) {
		super(nome, idade, logradouro, bairro, numero, complemento, cep);
		this.cnpj = cnpj;
	}

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, int idade, String logradouro, String bairro, int numero, String complemento,
			String cep) {
		super(nome, idade, logradouro, bairro, numero, complemento, cep);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cnpj);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaJuridica other = (PessoaJuridica) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

	@Override
	public String toString() {
		return "PessoaJuridica [ " + super.toString() + " , cnpj=" + cnpj + "]";
	}


}
