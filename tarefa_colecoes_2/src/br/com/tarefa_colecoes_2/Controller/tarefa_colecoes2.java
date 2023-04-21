package br.com.tarefa_colecoes_2.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.tarefa_colecoes_2.Model.Pessoa;

public class tarefa_colecoes2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		List<Pessoa> dtoPessoaM = new ArrayList<Pessoa>();
		List<Pessoa> dtoPessoaF = new ArrayList<Pessoa>();
		
		String resposta="";
		do {
			System.out.println(" Digite nome da pessoa - genero(M - masculino F - Feminino O - outro) ");
			String pessoas = s.next().trim();
			
			String[] listPessoa = pessoas.trim().split("-");
			String nome="";
			for(int y=0; y < listPessoa.length; y++) {
				switch(y) {
					case 0:
						nome = listPessoa[y];
						break;
					case 1:
						switch(listPessoa[y].charAt(0)) {
							case 'M':
								dtoPessoaM.add(new Pessoa(nome,'M'));
								break;
							case 'F':
								dtoPessoaF.add(new Pessoa(nome,'F'));
								break;
							default:
								break;
						}
						break;
					default:
						break;
				}
				
			}
			
			System.out.println(" Quer adicionar outra pessoa se sim digite S ");
			resposta = s.next();
		}while(resposta.equals("S"));
		
		if(dtoPessoaM != null && !dtoPessoaM.isEmpty()) {
			System.out.println(" genero Masculino: "+dtoPessoaM.toString());
		}
		if(dtoPessoaF != null && !dtoPessoaF.isEmpty()) {
			System.out.println(" genero Feminino: "+dtoPessoaF.toString());
		}

		s.close();
	}
}
