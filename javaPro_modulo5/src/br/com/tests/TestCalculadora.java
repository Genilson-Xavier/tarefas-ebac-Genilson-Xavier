package br.com.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.main.Calculadora;
import br.com.main.ICalculadora;

/**
 * @author Genilson.Xavier
 *
 */
public class TestCalculadora {
	
	@Test
	public void testandoAdicionarDaCalculadora() {
		ICalculadora calculadora = new Calculadora();
		int resultado = calculadora.adicionar(2, 4);
		
		Assert.assertEquals(6, resultado);
	}
	
	@Test
	public void testandoSubtracaoDaCalculadora() {
		ICalculadora calculadora = new Calculadora();
		int resultado = calculadora.subtrair(7, 1);
		
		Assert.assertEquals(6, resultado);
	}
	
	@Test
	public void testandoMultiplicacaoDaCalculadora() {
		ICalculadora calculadora = new Calculadora();
		int resultado = calculadora.multiplicador(3, 2);
		
		Assert.assertEquals(6, resultado);
	}
	
	@Test
	public void testandoDivisaoDaCalculadora() {
		ICalculadora calculadora = new Calculadora();
		int resultado = calculadora.dividir(12, 2);
		
		Assert.assertEquals(6, resultado);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testandoDivisaoDaCalculadoraPorZero() {
		ICalculadora calculadora = new Calculadora();
		int resultado = calculadora.dividir(2, 0);
		
		Assert.assertEquals(6, resultado);
	}
}
