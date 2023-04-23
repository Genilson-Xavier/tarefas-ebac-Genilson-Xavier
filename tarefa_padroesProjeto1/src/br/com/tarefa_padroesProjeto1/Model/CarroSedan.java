package br.com.tarefa_padroesProjeto1.Model;

import br.com.tarefa_padroesProjeto1.Localizacao;
import br.com.tarefa_padroesProjeto1.TipoCarro;

public class CarroSedan extends Carro{

	  public CarroSedan(Localizacao localizacao)
	  {
	    super(TipoCarro.SEDAN, localizacao);
	    construct();
	  }
	 
	  @Override
	  protected void construct() {
	    System.out.println("Construindo um carro Sedan");
	    
	  }

}
