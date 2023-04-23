package br.com.tarefa_generics.Factory;

import br.com.tarefa_generics.Fabricante;
import br.com.tarefa_generics.Modelo;
import br.com.tarefa_generics.Model.Carro;
import br.com.tarefa_generics.Model.CarroPasseio;
import br.com.tarefa_generics.Model.CarroSedan;

public class CarroFactory {

	public CarroFactory() {
		
	}

	public static Carro construirCarro(Fabricante fabricante, Modelo modelo){
		Carro carro = null;
		switch(modelo) {
			case PEUGEOUT208:
			case VOYAGE:
			case CRONOS:
			case KWID:
			case ARGO:
			case GOL:
			case MOBI:
			case ONIX:
			case HB20:
				carro = new CarroPasseio(fabricante, modelo);
				break;
			default:
				carro = new CarroSedan(fabricante, modelo);
				break;
		}
		return carro;
	}
}
