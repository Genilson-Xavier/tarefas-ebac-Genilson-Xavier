package br.com.main;

/**
 * @author Genilson.Xavier
 *
 */
public interface ICalculadora {
	
	/**
	 * @param a
	 * @param b
	 * @return a+b
	 */
	int adicionar(int a,int b);
	/**
	 * @param a
	 * @param b
	 * @return a-b
	 */
	int subtrair(int a,int b);
	/**
	 * @param a
	 * @param b
	 * @return a*b
	 */
	int multiplicador(int a , int b);
	/**
	 * @param a
	 * @param b
	 * @return a/b
	 * Se for passado 0 na divis�o retorna ArithmeticException
	 */
	int dividir(int a ,int b);
}
