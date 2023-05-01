/**
 * 
 */
package br.com.javaPro_modulo1.pilha;

/**
 * @author Genilson.Xavier
 *
 */
public class Main {
	public static void main(String[] args) throws UnsupportedOperationException{
		StackCustom stackCustom = new StackCustom();
		// Adiciona inteiro
		stackCustom.push(12);
		stackCustom.push(17);
		stackCustom.push(19);
		stackCustom.push(45);
		stackCustom.push(78);
		
		// Inteiro do topo
		System.out.println(" Inteiro do topo da pilha "+stackCustom.top());
		System.out.println(" Pilha vazia "+stackCustom.isEmpty());
		System.out.println(" Tamanho da pilha "+stackCustom.size());
		
		while(stackCustom.isEmpty() == false) {
			// Removendo
			System.out.println(stackCustom.pop());
		}


	}
}
