package br.tre;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestCalculadoraComissao {

	private CalculadoraComissao calc;

	@Before 
	public void metodoRodaAntesDoTeste(){
		calc = new CalculadoraComissao();

	}
	
	@Test
	public void calculoDaComissaoVenda10000Comissao500() {
		double valorVenda = 10000;
		double esperado = 500;
		
		
		double retorno = calc.calculaComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
	}
	
	@Test
	public void calculoDaComissaoVenda200Comissao10() {
		double valorVenda = 200;
		double esperado = 10;

		double retorno = calc.calculaComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
	}
	
	@Test
	public void calculoDaComissaoVenda300Comissao15() {
		double valorVenda = 300;
		double esperado = 15;

		double retorno = calc.calculaComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
	}
	
	@Test
	public void calculoDaComissaoVenda100000Comissao6000() {
		double valorVenda = 100000;
		double esperado = 6000;

		double retorno = calc.calculaComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
	}
	@Test
	public void calculoDaComissaoVendaDecimal() {
		double valorVenda = 55.79;
		double esperado = 2.78;

		double retorno = calc.calculaComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
	}
	
	
	@Test(expected=RuntimeException.class)
	public void calculoDaComissaoVendaNegativo() {
		double valorVenda = -1000;
		
		calc.calculaComissao(valorVenda);
				
	}
}
