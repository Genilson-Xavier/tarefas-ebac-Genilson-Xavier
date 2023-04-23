package br.com.tarefa_generics.Model;

import br.com.tarefa_generics.Fabricante;
import br.com.tarefa_generics.Modelo;

public class CarroPasseio extends Carro {

	public CarroPasseio(Fabricante fabricante, Modelo modelo) {
		super(fabricante, modelo, "Passeio");
	}

	@Override
	protected void construct() {
		System.out.println(" Construindo um carro de Paasseio ");
	}
}
