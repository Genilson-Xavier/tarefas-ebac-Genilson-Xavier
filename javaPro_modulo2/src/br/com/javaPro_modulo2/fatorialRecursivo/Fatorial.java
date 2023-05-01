/**
 * 
 */
package br.com.javaPro_modulo2.fatorialRecursivo;

import java.math.BigInteger;

/**
 * @author Genilson.Xavier
 *
 */
public class Fatorial {
	
	public static void main(String[] args) {
	    
		int numero = 4;
		// Maneira simples e direta na saída
		BigInteger resp = fatorialBigInteger(numero);
	    System.out.println(resp+"\n");
	    
		// Maneira simples e direta na saída
		int resp2 = fatorial(numero);
	    System.out.println(resp2+"\n");
        
		// Maneira mais bonita na saída  
		for ( int i = 0; i <= numero; i++ ) {
            System.out.printf( "%d! = %d\n", i, fatorial(i) );
        }
	}
	
	public static BigInteger fatorialBigInteger(int x) {
		// Se x for igual a 0 (zero) então retorna 1.
		if (x == 0) {
			return BigInteger.valueOf(1);
		}
			
		/*
		 * Para qualquer outro número, calcula o seu valor multiplicado pelo fatorial de
		 * seu antecessor.
		 */
		return fatorialBigInteger(x - 1).multiply(BigInteger.valueOf(x));
	}
	
	public static int fatorial(int x) {
		// Se x for igual a 0 (zero) então retorna 1.
		if (x == 0)
			return 1;

		/*
		 * Para qualquer outro número, calcula o seu valor multiplicado pelo fatorial de
		 * seu antecessor.
		 */
		return x * fatorial(x - 1);
	}
}
