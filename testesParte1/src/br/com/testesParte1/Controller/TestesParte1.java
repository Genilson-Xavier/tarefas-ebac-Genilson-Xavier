package br.com.testesParte1.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import br.com.testesParte1.Model.Pessoa;

public class TestesParte1 {
	
	public List<Optional<Pessoa>> processaRetornaMulheres(){
		List<Optional<Pessoa>> retorno = new ArrayList<Optional<Pessoa>>();
		
		Scanner s = new Scanner(System.in);
		
		List<Optional<Pessoa>> pessoas = new ArrayList<Optional<Pessoa>>();
		Optional<Pessoa> pessoa;
		
		String[] resp;
		
		String resposta="";
		do {
			System.out.println(" Digite nome da pessoa - genero(M - masculino F - Feminino O - outro) ");
			String dados = s.next().trim();
			resp = dados.trim().split("-");
			if(resp.length > 0) {
				pessoa = Optional.ofNullable(new Pessoa(resp[0],resp[1]));
				pessoas.add(pessoa);
			}
			
			System.out.println(" Quer adicionar outra pessoa se sim digite S ");
			resposta = s.next();
		}while(resposta.equalsIgnoreCase("S"));
			
		// imprime só as mulheres
		retorno = pessoas.stream()
			.filter(p -> String.valueOf(p.get().getSexo()).equals("F")).toList();
		
		s.close();
		return retorno;
	}
	
	public List<Optional<Pessoa>> processaRetornaMulheresUsandoHashMAp(List<Pessoa> mapa){
		List<Optional<Pessoa>> pessoas = new ArrayList<Optional<Pessoa>>(); 
		 
		List<Pessoa> mulheres = mapa.stream().filter(p -> String.valueOf(p.getSexo()).equals("F")).toList();
		 
		mulheres.stream().forEach(p -> pessoas.add(Optional.ofNullable(p)));
		return pessoas;
	}
}
