package br.tre;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCalculadora {
	

	@Test
	public void calculoDaComissaoVenda10000Comissao500() {
		double valorVenda = 10000;
		double esperado = 500;

		double retorno = Calculadora.calculaComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
	}
	
	@Test
	public void calculoDaComissaoVenda200Comissao10() {
		double valorVenda = 200;
		double esperado = 10;

		double retorno = Calculadora.calculaComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
	}
	
	@Test
	public void calculoDaComissaoVenda300Comissao15() {
		double valorVenda = 300;
		double esperado = 16;

		double retorno = Calculadora.calculaComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
	}
	
	@Test
	public void calculoDaComissaoVenda100000Comissao6000() {
		double valorVenda = 100000;
		double esperado = 6000;

		double retorno = Calculadora.calculaComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
	}
	@Test
	public void calculoDaComissaoVendaDecimal() {
		double valorVenda = 55.79;
		double esperado = 2.78;

		double retorno = Calculadora.calculaComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
	}
	
	
	@Test(expected=RuntimeException.class)
	public void calculoDaComissaoVendaNegativo() {
		double valorVenda = -1000;
		
		Calculadora.calculaComissao(valorVenda);
				
	}
}
