/**
 * 
 */
package br.com.javaPro_modulo1.pilha;

/**
 * @author Genilson.Xavier
 *
 */
public class StackCustom {
	
	// Estou com as variáveis em ingles porque os metodos foram pedidos em ingles 
	// mas costumo nomear tudo em português nos projetos que costumo fazeer
	public Object[] stack;
	
	// variável para posição da Pilha
	public int stackposition;
	
	// Limitador da pilha
	public int limit=500;
	
	// Construtor setando valor de parametro posicao da pilha para nulo 
	// levando em consideração -1 para nulo 
	// setando limite da pilha para 500
	public StackCustom() throws UnsupportedOperationException{
		this.stackposition = -1;
		this.stack = new Object[limit];
	}
	
	// Verifica se a pilha está vazia
	public boolean isEmpty() {
		if(stackposition == -1) {
			return true;
		}
		return false;
	}
	
	// Tamanho da Pilha
	public int size() {
		if(this.isEmpty()) {
			return 0;
		}
		return this.stackposition+1;
	}
	
	// Exibe Ultimo Valor
	public Integer/*Object*/ top() {
		if(this.isEmpty()) {
			return null;
		}
		return (Integer) this.stack[this.stackposition];
	}
	
	// Desempilhar
	public Object pop() {
		if(this.isEmpty()) {
			return null;
		}
		return this.stack[this.stackposition--];
	}
	
	
	// Empilhar
	public void push(Integer /* Object */ object) throws UnsupportedOperationException{
		if(this.stackposition < this.stack.length-1) {
			this.stack[++stackposition] = object;
		}else {
			// retorno em portuês da exception mas poderia ser "stack exceeded limit"
			throw new UnsupportedOperationException(" Pilha excedeu o limite ");
		}
	}
	
}
