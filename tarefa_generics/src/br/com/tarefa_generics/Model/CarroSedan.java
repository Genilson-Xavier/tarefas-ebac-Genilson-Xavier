package br.com.tarefa_generics.Model;

import br.com.tarefa_generics.Fabricante;
import br.com.tarefa_generics.Modelo;

public class CarroSedan extends Carro{

	public CarroSedan(Fabricante fabricante, Modelo modelo) {
		super(fabricante, modelo, "Sedan");
	}

	@Override
	protected void construct() {
		System.out.println(" Construindo um carro Sedan ");
	}
}
