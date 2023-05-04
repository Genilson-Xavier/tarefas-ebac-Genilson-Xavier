package br.com.main;

/**
 * @author Genilson.Xavier
 *
 */
public class Calculadora implements ICalculadora {

	/**
	 * Comentário explicando operação na Interface
	 * Adicionei na interface pois todos que a implementarem saberam o que fazer olhando nela 
	 */
	@Override
	public int adicionar(int a, int b) {
		return a+b;
	}

	@Override
	public int subtrair(int a, int b) {
		return a-b;
	}

	@Override
	public int multiplicador(int a, int b) {
		return a*b;
	}

	@Override
	public int dividir(int a, int b) {
		return a/b;
	}

}
