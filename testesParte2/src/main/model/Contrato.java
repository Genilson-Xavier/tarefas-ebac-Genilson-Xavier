package main.model;

import java.util.Objects;

public class Contrato {
	
	private Long id;
	
	private String NomeContratante;
	
	private Long cnpj;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeContratante() {
		return NomeContratante;
	}
	public void setNomeContratante(String nomeContratante) {
		NomeContratante = nomeContratante;
	}
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cnpj, id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrato other = (Contrato) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Contrato [id=" + id + ", NomeContratante=" + NomeContratante + ", cnpj=" + cnpj + "]";
	}
	
	public Contrato(Long id, String nomeContratante, Long cnpj) {
		super();
		this.id = id;
		NomeContratante = nomeContratante;
		this.cnpj = cnpj;
	}
	
	public Contrato() {
		super();
	}
	
}
