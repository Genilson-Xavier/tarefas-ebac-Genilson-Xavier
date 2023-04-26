package br.com.tarefa_colecoes.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class tarefa_colecoes1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<String> pessoas = new ArrayList<String>();
		
		System.out.println("Digite o nome de pessoas com , para separar ");
		String nomes = s.next();
		
		String[] nome = nomes.split(",");
		for(int y=0; y<nome.length; y++) {
			pessoas.add(nome[y]);
		}
		
		Collections.sort(pessoas);
		System.out.println(pessoas);
		s.close();
	}
}
