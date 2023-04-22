package br.com.tarefa_modulo13.Controller;

import br.com.tarefa_modulo13.Model.PessoaFisica;
import br.com.tarefa_modulo13.Model.PessoaJuridica;

public class Tarefa_Modulo13 {
	public static void main(String[] args) {
		// Testando a orientação
		
		PessoaFisica Joao = new PessoaFisica("João",28," Rua teste","Lagoa Nova",345,"proximo ao mercado sobradinho","11111111","11111111111");
		PessoaJuridica Vult = new PessoaJuridica("Vult SA",0,"Rua evaristo Gomes","Pedrinhas",1987,"","22222222","63488800000113");
		
		System.out.println(" PF -> "+ Joao.toString());
		System.out.println(" PJ -> "+Vult.toString());
	}
}
