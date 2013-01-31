package br.tre;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.tre.dao.VendaRepository;
import br.tre.modelo.Venda;


public class TestCalculadoraRoyalties {
	
	private VendaRepository vendaRepositoryMock;
	private CalculadoraComissao calculadoraComissaoMock;

	@Before
	public void inicializaMocks() {
		vendaRepositoryMock = mock(VendaRepository.class);
		calculadoraComissaoMock = mock(CalculadoraComissao.class);
	}
	
	@Test
	public void calcularValorRoyatiesParaVendaUnicaDe100() {
		double valorVenda = 100;
		double valorRoyateEsperado = 20;
		double valorComissaoEsperado = 0;
		int idVenda = 1;
		int idVendedor = 1;
		int ano = 2012;
		int mes = 1;
		List<Venda> listaEntrada = new ArrayList<Venda>();
		listaEntrada.add(new Venda(idVenda, idVendedor, ano, mes, valorVenda));
		
		when(vendaRepositoryMock.obterVendasPorMesEAno(ano,mes)).thenReturn(listaEntrada);
		
		when(calculadoraComissaoMock.calculaComissao(valorVenda)).thenReturn(valorComissaoEsperado);
		
		//act
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties(calculadoraComissaoMock , vendaRepositoryMock);
		double valorRetorno = calculadoraRoyalties.calcularRoyalties(mes, ano );
		
		//assert
		Assert.assertEquals(valorRoyateEsperado, valorRetorno,0);
		
	}
	
	@Test
	public void calcularValorRoyatiesParaVendaUnicaDe200() {
		double valorVenda = 200;
		double valorRoyateEsperado = 40;
		double valorComissaoEsperado = 0;
		int idVenda = 1;
		int idVendedor = 1;
		int ano = 2012;
		int mes = 1;

		List<Venda> listaEntrada = new ArrayList<Venda>();
		listaEntrada.add(new Venda(idVenda, idVendedor, ano, mes, valorVenda));

		when(vendaRepositoryMock.obterVendasPorMesEAno(ano,mes)).thenReturn(listaEntrada);

		when(calculadoraComissaoMock.calculaComissao(valorVenda)).thenReturn(valorComissaoEsperado);
		
		//act
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties(calculadoraComissaoMock , vendaRepositoryMock);
		double valorRetorno = calculadoraRoyalties.calcularRoyalties(mes, ano );
		
		//assert
		Assert.assertEquals(valorRoyateEsperado, valorRetorno,0);
		verify(calculadoraComissaoMock).calculaComissao(valorVenda);
		
	}

	
}
