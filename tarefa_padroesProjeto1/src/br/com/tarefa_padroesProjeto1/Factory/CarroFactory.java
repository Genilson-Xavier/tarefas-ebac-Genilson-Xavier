package br.com.tarefa_padroesProjeto1.Factory;

import br.com.tarefa_padroesProjeto1.Localizacao;
import br.com.tarefa_padroesProjeto1.TipoCarro;
import br.com.tarefa_padroesProjeto1.Model.Carro;

public class CarroFactory {
	private CarroFactory() {
	
	}

	public static Carro construirCarro(TipoCarro tipoCarro, Localizacao local) {
		Carro carro = null;
		// TODO localização fixa o certo e colocar pra ler de uma configuração
		Localizacao localizacao = local;
		
		switch (localizacao) {
		case USA:
			carro = UsaCarroFactory.construirCarro(tipoCarro);
			break;
		case ASIA:
			carro = AsiaCarroFactory.construirCarro(tipoCarro);
			break;
		default:
			carro = DefaultCarroFactory.construirCarro(tipoCarro);
		}
		return carro;
	}
}
