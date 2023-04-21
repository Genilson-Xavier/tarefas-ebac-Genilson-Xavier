package br.com.tarefa_classes.Controller;

import br.com.tarefa_classes.model.Carro;

public class Tarefa {
	// Método principal para testar a classe carro
	public static void main(String[] args) {

		// criar um carro baseado na classe carro
		Carro corsa = new Carro("Corsa","Chevrolet","ABC123","Chevrolet");
		
		// exibindo atributo nome do carro e hashcode
		System.out.println(" Nome do carro "+corsa.getModelo()+" hash "+corsa.hashCode());
		
		// Testando métodos
		// ligando o carro
		corsa.ligar();
		
		// acelerando o carro
		corsa.acelerar();
		
		// freiando o caroo 
		corsa.frear();
		
		// desligando o carro
		corsa.desligar();

		
		Carro gol = new Carro("Gol","Volkswagen","DEF456","Volkswagen");
		
		// exibindo atributo nome do carro e hashcode
		System.out.println(" Nome do carro "+gol.getModelo()+" hash "+gol.hashCode());
		
		// ligando o carro
		gol.ligar();
		
		// acelerando o carro
		gol.acelerar();
		
		// freiando o caroo 
		gol.frear();
		
		// desligando o carro
		gol.desligar();

		// Usando equal do objeto
		System.out.println(averigacao(corsa,gol," O objeto corsa é igual ao objeto gol "+resposta(corsa,gol))); 

		// Usando equal do objeto
		System.out.println(averigacao(corsa,corsa," O objeto corsa é igual ao objeto corsa  "+resposta(corsa,corsa))); 
	}
	
	// criando resposta 
	private static String resposta(Carro a, Carro b) {
		String resposta ="";
		if(a.equals(b)) {
			resposta="SIM";
		}else{
			resposta="NÃO";
		}
		return resposta;
	} 
	
	private static String averigacao(Carro a, Carro b, String s) {
		System.out.println(s);
		if(s.contains("NÃO")) {
			// nesse caso exibe os atributos dos objetos para comprovação
			System.out.println("	"+a.toString());
			System.out.println("	"+b.toString());
		}
		return "";
	}
}
