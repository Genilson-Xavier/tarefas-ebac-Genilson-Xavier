package br.com.tarefa_padroesProjeto1.Model;

import br.com.tarefa_padroesProjeto1.Localizacao;
import br.com.tarefa_padroesProjeto1.TipoCarro;

public abstract class Carro {
	public Carro(TipoCarro modelo, Localizacao localizacao){
		    this.modelo = modelo;
		    this.localizacao = localizacao;
		  }

	protected abstract void construct();

	private TipoCarro modelo = null;
	private Localizacao localizacao = null;

	

	@Override
	public String toString() {
		return "<--- Modelo - " + modelo + " construido na(no) " + localizacao+" --->";
	}
}
