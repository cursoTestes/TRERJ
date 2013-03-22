package br.scrumban;

import junit.framework.Assert;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;

public class CadastroDeUmaVendaInterfaceTest extends FluentTest {

	@Test
	public void teste_cadastra_uma_venda_Sem_preencher_campos_obrigatorios() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("");
		fill("#DataVenda").with("");
		fill("#Valor").with("");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("O campo Id Vendedor � obrigat�rio.", findFirst("#validacaoVendedor").getText()); 
		Assert.assertEquals("O campo Valor � obrigat�rio.", findFirst("#validacaoValor").getText()); 
		Assert.assertEquals("O campo Data Venda � obrigat�rio.", findFirst("#validacaoDataVenda").getText());
					
	}
	@Test
	public void testeVendaComIdTexto() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("A");
		fill("#DataVenda").with("D");
		fill("#Valor").with("V");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("Valor do campo invalido. Coloque um numero.", findFirst("#validacaoVendedor").getText()); 
		Assert.assertEquals("Valor do campo invalido. Coloque um numero.", findFirst("#validacaoValor").getText()); 
		Assert.assertEquals("Valor do campo invalido. Coloque uma data valida no formato dd/mm/aaaa.", findFirst("#validacaoDataVenda").getText());
					
	}	
}
