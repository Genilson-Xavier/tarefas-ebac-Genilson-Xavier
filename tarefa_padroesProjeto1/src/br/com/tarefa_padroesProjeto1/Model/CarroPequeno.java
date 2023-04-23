package br.com.tarefa_padroesProjeto1.Model;

import br.com.tarefa_padroesProjeto1.Localizacao;
import br.com.tarefa_padroesProjeto1.TipoCarro;

public class CarroPequeno extends Carro{
	  public CarroPequeno(Localizacao localizacao)
	  {
	    super(TipoCarro.PASSEIO, localizacao);
	    construct();
	  }
	 
	  @Override
	  protected void construct() {
	    System.out.println("Construindo um carro de passeio");
	    
	  }
}
