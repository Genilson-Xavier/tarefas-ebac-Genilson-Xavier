package br.com.tarefa_generics.Util;

import java.util.ArrayList;
import java.util.List;

import br.com.tarefa_generics.Model.Carro;

public class ListaGenerica {
	private int tamanho=0;
	List<Carro> retorno = new ArrayList<Carro>();
	
	public ListaGenerica() {
		
	}
	
	public <T extends Carro> List<T> add(T lista){
		
		boolean comp =  retorno.add(lista);
		if(comp) {
			System.out.println(" Adicionado na lista de carros a categoria "+ lista.getCategoria());
			tamanho = tamanho+1;
		}else {
			System.out.println(" Não adicionou na lista de carros ");
		}
		return (List<T>) retorno;
	}
	
	public int tamanho() {
		return this.tamanho;
	}

	public String imprimir(int i) {
		return this.retorno.get(i).toString();
	}
	
}
