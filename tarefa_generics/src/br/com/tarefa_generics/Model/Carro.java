package br.com.tarefa_generics.Model;

import br.com.tarefa_generics.Fabricante;
import br.com.tarefa_generics.Modelo;

public abstract class Carro {
	public Carro(Fabricante fabricante, Modelo modelo, String categoria) {
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.categoria = categoria;
	}
	
	protected abstract void construct();

	private Fabricante fabricante = null;
	private Modelo modelo = null;
	private String categoria = "";
	
	@Override
	public String toString() {
		return "<--- Modelo - " + modelo + " Fabricante " + fabricante+" categoria "+ categoria +" --->";
	}

	public String getCategoria() {
		return categoria;
	}
	
	
}
