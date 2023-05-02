package br.com.javaPro_modulo3.subconjuntos;

import java.util.Arrays;

public class Subconjuntos {
	
	public static void subconjuntosN(int[] sub, int elem) {
		if(sub != null && elem > 0) {
			Arrays.sort(sub);
			for(int i =0; i < sub.length; i++) {
				if(elem == 1) {
					System.out.println("[" +sub[i]+"]");
				}else if(elem == 2){
					for(int j=0; j < sub.length; j++) {
						if (i != j && j > i) {
							System.out.print("[" + sub[i] + "," + sub[j] + "]\n");
						}
					}
				}else {
					System.out.println(" não implementado tem 1 ou 2 elementos ");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// Testando 1° caso Entrada: S = [1, 2, 3], n = 2
		int[] sub = new int[] {
				1, 2, 3	
		};
		subconjuntosN(sub, 2);
		
		System.out.println();
		// Testando 2° caso Entrada: S= [1, 2, 3, 4], n = 1
		int[] sub2 = new int[] {
				1, 2, 3, 4
		};
		subconjuntosN(sub2, 1);
	}
}
