package br.com.tarefa_padroesProjeto1;

import br.com.tarefa_padroesProjeto1.Factory.CarroFactory;

public class Tarefa_padroesProjeto1 {
	public static void main(String[] args) {
		System.out.println(CarroFactory.construirCarro(TipoCarro.PASSEIO, Localizacao.USA));
		System.out.println(CarroFactory.construirCarro(TipoCarro.SEDAN, Localizacao.DEFAULT));
		System.out.println(CarroFactory.construirCarro(TipoCarro.LUXO, Localizacao.ASIA));
	}
}
