package br.com.tarefa_calculoMedia.Controller;

import java.text.DecimalFormat;

public class tarefa_calculoMedia {
	// formata��o pradeixar com duas casas ap�s a virgula
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public static void main(String[] args) {
		media4Notas(7,6,5,7);
		
		double[] numeros = {7,6,5,7};
		media4NotasArray(numeros);
	}
	
	// forma simples de fazer m�dia limitado a 4 parametros
	private static void media4Notas(double n1, double n2, double n3,double n4) {
		try {
			double soma = n1+n2+n3+n4;
			double resultado = soma /4; 
			System.out.println(" A media � "+df.format(resultado));
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	// forma dinamica de fazer a m�dia sem limites de parametros
	private static void media4NotasArray(double[] numeros) {
		try {
			double soma = 0;
			for(int y=0; y < numeros.length; y++) {
				soma = soma+numeros[y];
			}
			double resultado = soma / numeros.length;
			System.out.println(" A media � "+df.format(resultado)+" usando array ");
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
