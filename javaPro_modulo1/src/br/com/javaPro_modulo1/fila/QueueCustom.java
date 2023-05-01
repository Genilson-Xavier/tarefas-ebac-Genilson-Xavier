/**
 * 
 */
package br.com.javaPro_modulo1.fila;

/**
 * @author Genilson.Xavier
 *
 */
public class QueueCustom {
    // fila
	private int queue[];
    // inicio
    private int start;
    // fim
    private int end;
    
    // vazia
    private boolean empty;
    
    public QueueCustom() {
        this.queue = new int[20];
        this.start = 0;
        this.end = 0;
        this.empty = true;
    }
    
    // verifica se a fila está cheia 
    public boolean isFull() {
        return this.start == this.end && !this.empty;
    }
    
    // adicionar
    public void enqueue(int valor) {
        if (isFull()) {
            throw new IllegalStateException(" Fila cheia ");
        }
        this.queue[this.end] = valor;
        this.end = (this.end + 1) % this.queue.length;
        this.empty = false;
    }
    
    // Remover
    public int dequeue() {
        if (this.empty) {
            throw new IllegalStateException("Fila vazia");
        }
        int value = this.queue[start];
        this.start = (this.start + 1) % this.queue.length;
        this.empty = this.start == this.end;
        return value;
    }
    
    // Tamanho
    public int size() {
        //System.out.println(this.start + ", " + this.end);
        if (this.empty)
            return 0;
        if (this.isFull())
            return this.queue.length;
        if (this.end > this.start)
            return this.end - this.start;

        return this.end + this.queue.length - this.start;
    }
    
    public Integer front() {
    	if(this.empty) {
    		throw new IllegalStateException("Fila vazia");
    	}else {
    		//System.out.println(this.queue[this.start]);
    		return this.queue[this.start];    		
    	}
    }
    
    public Integer rear() {
    	if(this.empty) {
    		throw new IllegalStateException("Fila vazia");
    	}else {
    		//System.out.println(this.queue[this.end]);
    		return this.queue[--this.end];
    	}	
    }
    
    public boolean isEmpty() {
    	return empty;
    }
}
