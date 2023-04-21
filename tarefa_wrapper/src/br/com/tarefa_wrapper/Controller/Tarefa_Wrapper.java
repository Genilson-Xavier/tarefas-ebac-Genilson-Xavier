package br.com.tarefa_wrapper.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Tarefa_Wrapper {
	// pattern regex para validar se o valor digitado é numerico
	private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	
	public static void main(String[] args) throws IOException {
		System.out.println(" Digite um valor ");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String valorDigitado = reader.readLine();
			if(isNumeric(valorDigitado)) {
				double valor = Double.parseDouble(valorDigitado);
				imprimeValor(valor);
			}else {
				System.out.println(" valor digitado não é um numero ");
			}

		}catch(IOException e) {
			e.getMessage();
		}
	}
	

	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false; 
	    }
	    return pattern.matcher(strNum).matches();
	}
	
	public static void imprimeValor(double valor) {
		System.out.println(" valor digitado variavel primitiva "+valor);
		Double valorNovo = valor;
		System.out.println(" valor digitado variavel tipo Wrapper "+valorNovo);
	}
}
