package tarefa_controleFluxo.Controller;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class tarefa_controleFluxo {
	// formatação pradeixar com duas casas após a virgula
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int notasDigtadas = 0;
		double soma = 0;
		double media = 0;
		
		try {
			do {
				System.out.println(" digite uma a "+(notasDigtadas+1)+"° nota ");
				double nota = s.nextDouble();
				soma = soma +nota;
				notasDigtadas++;
			}while(notasDigtadas <= 3);
			media = soma/4;
			System.out.println(" A média das notas são "+df.format(media));
			processamentoDaMedia(media);
		}catch(InputMismatchException e) {
			e.getMessage();
			System.out.println(" nota não é numerica ");
		}
		s.close();
	}
	
	public static void processamentoDaMedia(double media) {
		if(media >= 7) {
			System.out.println(" Aprovado ");
		}else if(media >= 5){
			System.out.println(" Recuperação ");
		}else {
			System.out.println(" Reprovado ");
		}
		
	}
}
