package br.com.javaPro_modulo1.listaEncadeada;


public class Main {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insereInicio(2);
		linkedList.insereInicio(65);
		linkedList.insereInicio(87);
		linkedList.insereInicio(43);
		linkedList.insereInicio(22);
		linkedList.insereInicio(37);
		
		System.out.println(linkedList.printList());	
		System.out.println(" Tamanho da lista "+linkedList.size());
		System.out.println(" Elemento 2 da fila "+linkedList.elementAt(2).toString());

		// remove por indice removendo o dois
		// rever ao remover não atualiza posição
		linkedList.remove(2);
		System.out.println(linkedList.printList());
		
		// Adicionando no indice novo nó 
		linkedList.insert(3, 2345);
		
		// removendo nó do fim da lista
		linkedList.pop();
		System.out.println(linkedList.printList());
		
		// Adicionando nó no fim da lista 123
		linkedList.push(123);
		System.out.println(linkedList.printList());
	}
}
