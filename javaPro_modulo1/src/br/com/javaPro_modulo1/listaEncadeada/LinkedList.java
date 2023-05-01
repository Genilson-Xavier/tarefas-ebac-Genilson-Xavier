package br.com.javaPro_modulo1.listaEncadeada;

public class LinkedList {
	public static class Node {
		public Node prox; // próximo nó na lista
		public int valor; // elemento (valor) armazenado na lista
		public int posicao; // para conseguir retornar tamanho

		public Node(int val,Node node, int posicao) { 
			valor = val;
			prox = node;
			this.posicao = posicao;
		}
		
		public Node(int val) { // construtor do nó da lista
			valor = val;
			prox = null;
			posicao = 0;
		}

		@Override
		public String toString() {
			return "Node [prox=" + prox + ", valor=" + valor + ", posicao=" + posicao + "]";
		}
		
	}

	private Node inicio; // representa a cabeça (início) da lista

	public LinkedList(){   // construtor da lista
        inicio = null;
    }

	public boolean isEmpty() {
		return inicio == null;
	}

	public Node elementAt(int elem) {
		for (Node nodo = inicio; nodo != null; nodo = nodo.prox) {
			if (elem == nodo.posicao) {
				return nodo;
			}
		}
		return null;
	}
	
    void remove(int elem) {

        if (inicio.posicao == elem) {
            removeInicio();
            return;
        }

        remove(null, inicio, elem);
    }
    
    void remove(Node anterior, Node atual, int elem) {
        if (elem == atual.posicao) {
            anterior.prox = atual.prox;
            anterior.posicao = atual.posicao;
            //anterior.posicao = elem;
            return;
        }

        remove(atual, atual.prox, elem);
        if(atual.prox.prox == null) {
        	realinhaPosicao();
        }
    }
    
    void realinhaPosicao() {
		if (!isEmpty()) {
			int referencia = inicio.posicao;
			for (Node nodo = inicio; nodo != null; nodo = nodo.prox) {
				if(nodo.posicao != referencia) {
					nodo.posicao = referencia;
				}
				referencia = referencia-1;
			}
		}
    }
    
    // rever
    void insert(int elem, int valor) {

        if (inicio.posicao == elem) {
            removeInicio();
            return;
        }

        insert(inicio,valor, elem);
    }
    
    // rever
	void insert(Node atual, int valor/*Node novo*/, int elem) {
		for (Node nodo = atual; nodo != null; nodo = nodo.prox) {
			if (elem == nodo.posicao) {
				Node novo = new Node(valor,atual.prox,elem);
				nodo.valor = novo.valor;
				return;
			}
		}
				
 /*   	if (elem == atual.posicao) {
            //atual.prox = novo.prox;
    		Node novo = new Node(valor,atual.prox,elem);
    		novo.prox = atual.prox;
        	atual = novo;
            return;
        }

        insert(novo, novo.prox, elem);*/
    }
	
	public boolean search(int elem) {
		for (Node nodo = inicio; nodo != null; nodo = nodo.prox)
			if (elem == nodo.valor)
				return true; // econtrou o elemento
		return false; // não encontrou o elemento

	}

	public void insereInicio(int elem) { // insere no início da lista
		Node novoNo = new Node(elem);
		novoNo.prox = inicio; // novoNo -> inicio antigo
		if(!isEmpty()) {
			novoNo.posicao = ++inicio.posicao;
		}
		inicio = novoNo; // inicio -> novoNo
	}

	public void removeInicio() { // elimina o primiro item da lista
		inicio = inicio.prox; // elimina o elemento e reposiciona o início
		inicio.posicao = --inicio.prox.posicao;
	}

	public String printList() {
		if (isEmpty())
			return "Lista vazia\n"; // teste de lista vazia
		String str = "Lista Encadeada: \n";
		for (Node nodo = inicio; nodo != null; nodo = nodo.prox)
			str += " " + nodo.valor+"\n";
		return str;
	}
	
	public int size() {
		//Node nodo = inicio;
		if(inicio == null) {
			return 0;
		}
		return inicio.posicao+1;
	}
	
    void pop() {
        if (isEmpty()) {
            System.out.println("Nao ha elementos na lista");
        }
        pop(null, inicio); 
    }

    void pop(Node anterior, Node atual) { 
        if (atual.prox == null) {
            anterior = atual;
            return;
        }

        pop(atual, atual.prox);
    }
    
    void push(int chave) {

        if (isEmpty()) {
            new Node(chave);
            return;
        }

        push(null, inicio, chave);
    }

    void push(Node anterior, Node atual, int chave) { 
        if (atual == null) {
            anterior.prox = new Node(chave);
            return;
        }

        push(atual, atual.prox, chave);
    }
}
