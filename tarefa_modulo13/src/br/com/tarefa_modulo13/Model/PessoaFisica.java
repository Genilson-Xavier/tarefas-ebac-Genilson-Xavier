package br.com.tarefa_modulo13.Model;

import java.util.Objects;

public class PessoaFisica extends Pessoa{
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public PessoaFisica(String nome, int idade, String logradouro, String bairro, int numero, String complemento,
			String cep, String cpf) {
		super(nome, idade, logradouro, bairro, numero, complemento, cep);
		this.cpf = cpf;
	}

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, int idade, String logradouro, String bairro, int numero, String complemento,
			String cep) {
		super(nome, idade, logradouro, bairro, numero, complemento, cep);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpf);
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
		PessoaFisica other = (PessoaFisica) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "PessoaFisica [" + super.toString() + " , cpf=" + cpf + "]";
	}


	
	
}
