package br.com.tarefa_padroesProjeto1.Factory;

import br.com.tarefa_padroesProjeto1.Localizacao;
import br.com.tarefa_padroesProjeto1.TipoCarro;
import br.com.tarefa_padroesProjeto1.Model.Carro;
import br.com.tarefa_padroesProjeto1.Model.CarroLuxo;
import br.com.tarefa_padroesProjeto1.Model.CarroPequeno;
import br.com.tarefa_padroesProjeto1.Model.CarroSedan;

public class UsaCarroFactory {
	  public static Carro construirCarro(TipoCarro modelo)
	  {
	    Carro Carro = null;
	    switch (modelo)
	    {
	      case PASSEIO:
	      Carro = new CarroPequeno(Localizacao.USA);
	      break;
	 
	      case SEDAN:
	      Carro = new CarroSedan(Localizacao.USA);
	      break;
	 
	      case LUXO:
	      Carro = new CarroLuxo(Localizacao.USA);
	      break;
	 
	      default:
	      break;
	    }
	    return Carro;
	  }
}
