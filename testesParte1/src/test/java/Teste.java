package test.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;


import br.com.testesParte1.Controller.TestesParte1;
import br.com.testesParte1.Model.Pessoa;

public class Teste {
	TestesParte1 testes = new TestesParte1();
	
	// Esse teste chama um loop perguntando um nome
	@Test 
	public void testandoGrupoDePessoasSePossuiSoMulheres() {
				
		List<Optional<Pessoa>> retorno =  testes.processaRetornaMulheres();

		if(retorno.stream().count() <= 0) {
			// passou no teste porque está nulo
			Assert.assertEquals(1, 1);
		}else {
			// caso não esteja nulo ver se contem só mulheres 
			// Se a lista contiver 0 significa que só tem mulheres e passa o teste
			Assert.assertEquals(0l,retorno.stream().filter(p ->  !String.valueOf(p.get().getSexo()).equals("F")).count());
		}
	}
	
	// Esse teste passa mockado uma lista 
	@Test
	public void testandoGrupoDePessoasSePossuiSoMulheresUsandoLista() {
		// Criando lista só com mulheres
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(new Pessoa("Ana","F"));
		pessoas.add(new Pessoa("Fernanda","F"));
		pessoas.add(new Pessoa("Maria","F"));
		
		List<Optional<Pessoa>> retorno = testes.processaRetornaMulheresUsandoHashMAp(pessoas);
		
		if(retorno.stream().count() <= 0) {
			// passou no teste porque está nulo
			Assert.assertEquals(1, 1);
		}else {
			// caso não esteja nulo ver se contem só mulheres 
			// Se a lista contiver 0 significa que só tem mulheres e passa o teste
			Assert.assertEquals(0l,retorno.stream().filter(p ->  !String.valueOf(p.get().getSexo()).equals("F")).count());
		}
	}
	
	// Esse teste passa Mockado uma lista só com Homens
	@Test
	public void testandoGrupoDePessoasSePossuiSoMulheresUsandoListaSoComHomens() {
		// Criando lista só com Homens
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(new Pessoa("Joao","M"));
		pessoas.add(new Pessoa("Fernando","M"));
		pessoas.add(new Pessoa("Mario","M"));
		
		List<Optional<Pessoa>> retorno = testes.processaRetornaMulheresUsandoHashMAp(pessoas);
		
		if(retorno.stream().count() <= 0) {
			// passou no teste porque está nulo
			Assert.assertEquals(1, 1);
		}else {
			// caso não esteja nulo ver se contem só mulheres 
			// Se a lista contiver 0 significa que só tem mulheres e passa o teste
			Assert.assertEquals(0l,retorno.stream().filter(p ->  !String.valueOf(p.get().getSexo()).equals("F")).count());
		}
	}
	
}
