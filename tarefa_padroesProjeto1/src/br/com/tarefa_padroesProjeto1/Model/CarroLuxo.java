package br.com.tarefa_padroesProjeto1.Model;

import br.com.tarefa_padroesProjeto1.Localizacao;
import br.com.tarefa_padroesProjeto1.TipoCarro;

public class CarroLuxo extends Carro{
	  public CarroLuxo(Localizacao localizacao)
	  {
	    super(TipoCarro.LUXO, localizacao);
	    construct();
	  }
	 
	  @Override
	  protected void construct() {
	    System.out.println("Construindo um carro de luxo");
	    
	  }
}
