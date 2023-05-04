package br.com.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.main.fibonacci.Fibonacci;

public class TestFibonacci {
	
	int resposta = 0;
	
	@Test
	public void testandoNumerosDeFibonacci0() {
		resposta = Fibonacci.findElementDP(0);
		
		Assert.assertEquals(0, resposta);
	}
	
	@Test
	public void testandoNumerosDeFibonacci1() {
		resposta = Fibonacci.findElementDP(1);
		
		Assert.assertEquals(1, resposta);
	}
	
	@Test
	public void testandoNumerosDeFibonacci10() {
		resposta = Fibonacci.findElementDP(10);
		
		Assert.assertEquals(55, resposta);
	}
	
	@Test
	public void testandoNumerosDeFibonacci30() {
		resposta = Fibonacci.findElementDP(30);
		
		Assert.assertEquals(832040, resposta);
	}
}
