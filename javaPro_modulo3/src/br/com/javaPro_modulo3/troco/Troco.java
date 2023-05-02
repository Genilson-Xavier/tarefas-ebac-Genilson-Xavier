package br.com.javaPro_modulo3.troco;

import java.util.HashMap;

public class Troco {
	
	// Tipos de moedas disponiveis pro troco
	static int[] moedasDisponiveisTroco = new int[] {
			5,2,1	
	};
	
	
    private static HashMap<Integer, Integer> calculaMoedas (int[] moedasDisponiveis, double troco) {

        int[] moedas = sortReverse(moedasDisponiveis);

        int valor;
        int qtdMoedasNecessarias;

        int contadorMoeda = 0;

        HashMap<Integer, Integer> resultado = new HashMap<Integer, Integer>();

        valor = (int) Math.round(troco);
        while (valor != 0) {
            qtdMoedasNecessarias = valor / moedas[contadorMoeda];
            if (qtdMoedasNecessarias != 0) {
                resultado.put(moedas[contadorMoeda], qtdMoedasNecessarias);
                valor = valor % moedas[contadorMoeda]; // sobra
            }
            contadorMoeda++; // próxima moeda
        }
        
        // lógica para colocar zero quando não tiver moedas a serem usadas 
        valor = moedas.length;
        while(valor != 0) {
        	if(resultado.get(moedas[valor-1]) == null) {
        		resultado.put(moedas[valor-1], 0);
        	}
        	valor--;
        }
        
        return resultado;
    }
    
    private static int[] sortReverse(int[] vector) {

        java.util.Arrays.sort(vector); // sort

        int left = 0;
        int right = vector.length - 1;

        while (left < right) {
       
            int temp = vector[left];
            vector[left] = vector[right];
            vector[right] = temp;

            
            left++;
            right--;
        }
        return vector;
    }
    
	public static void main(String[] args) {
		int[] moedas = sortReverse(moedasDisponiveisTroco);
		
		// Teste do exercício
		HashMap<Integer, Integer> mapa = calculaMoedas(moedasDisponiveisTroco, 18);
		for(int i=0; i < moedas.length; i++) {
			System.out.println(mapa.get(moedas[i])+" moedas de "+moedas[i]);
		}
		
		System.out.println();
				
		// Teste do com valores que seriam nulos
		HashMap<Integer, Integer> mapa2 = calculaMoedas(moedasDisponiveisTroco, 10);
		for(int i=0; i < moedas.length; i++) {
			System.out.println(mapa2.get(moedas[i])+" moedas de "+moedas[i]);
		}
		
	}
}
