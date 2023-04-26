package br.com.tarefa_streams.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import br.com.tarefa_streams.Model.Pessoa;

public class tarefa_streams {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		String[] resp;
		
		String resposta="";
		do {
			System.out.println(" Digite nome da pessoa - genero(M - masculino F - Feminino O - outro) ");
			String dados = s.next().trim();
			resp = dados.trim().split("-");
			if(resp.length > 0) {
				pessoas.add(new Pessoa(resp[0],resp[1]));
			}
			
			System.out.println(" Quer adicionar outra pessoa se sim digite S ");
			resposta = s.next();
		}while(resposta.equalsIgnoreCase("S"));
		
		//separador
		System.out.println("**********************");
		System.out.println(" Só mulheres ");
		
		// imprime só as mulheres
		pessoas.stream()
			.filter(pessoa -> String.valueOf(pessoa.getSexo()).equals("F"))
			.forEach(System.out::println);
		
		//separador
		System.out.println("**********************");
		System.out.println(" Todos ");
		
		// imprime todos para comparar
		pessoas.stream()
		.forEach(System.out::println);
		s.close();
	}
}
