/**
 * 
 */
package br.com.javaPro_modulo2.fatorialPD;

import java.math.BigInteger;

/**
 * @author Genilson.Xavier
 *
 */
public class Fatorial {
	
	static int numero = 100;
	static BigInteger[] fat ;
	
	public static void main(String[] args) {
		
		BigInteger[] resp = fatorial(numero);
        
		for ( int i = 0; i < resp.length; i++ ) {
            System.out.printf( "%d! = %d\n", i, resp[i] );
        }
	}
	
	public static BigInteger[] fatorial(int x) {
		fat = new BigInteger[x+1];
		fat[0] = BigInteger.ONE;
		
        for ( int i = 1; i < fat.length; i++ ) {
            fat[i] = fat[i-1].multiply( BigInteger.valueOf( i ) );
        }
        
        return fat;
	}
}
