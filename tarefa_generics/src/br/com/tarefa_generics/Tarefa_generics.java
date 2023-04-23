package br.com.tarefa_generics;

import br.com.tarefa_generics.Factory.CarroFactory;
import br.com.tarefa_generics.Model.Carro;
import br.com.tarefa_generics.Util.ListaGenerica;

public class Tarefa_generics {
	public static void main(String[] args) {
		Carro onix = CarroFactory.construirCarro(Fabricante.CHEVROLET, Modelo.ONIX);
		Carro civic = CarroFactory.construirCarro(Fabricante.HONDA, Modelo.CIVIC);
		Carro fiat = CarroFactory.construirCarro(Fabricante.FIAT, Modelo.ARGO);
		Carro arrizo = CarroFactory.construirCarro(Fabricante.CAOACHERRY, Modelo.ARRIZO6);
		ListaGenerica lista = new ListaGenerica();
		lista.add(onix);
		lista.add(civic);
		lista.add(fiat);
		lista.add(arrizo);
		for(int i=0; i < lista.tamanho(); i++) {
			System.out.println(lista.imprimir(i));
		}
	}
}
