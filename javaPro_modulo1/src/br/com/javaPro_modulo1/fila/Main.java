package br.com.javaPro_modulo1.fila;

public class Main {
	
	public static void main(String[] args) {
		QueueCustom queueCustom = new QueueCustom();
		System.out.println(" fila vazia antes "+queueCustom.isEmpty());
		// Adiciona 
		queueCustom.enqueue(10);
		queueCustom.enqueue(7);
		queueCustom.enqueue(9);
		queueCustom.enqueue(67);
		queueCustom.enqueue(98);
		
		System.out.println(" fila vazia depois "+queueCustom.isEmpty());
		System.out.println(" Tamanho da lista "+ queueCustom.size());
		System.out.println(" Primeiro da lista "+queueCustom.front());
		System.out.println(" Ultimo da lista "+queueCustom.rear());
		
		// Remove 
		System.out.println(" removendo da lista "+queueCustom.dequeue()); 
	}
}
