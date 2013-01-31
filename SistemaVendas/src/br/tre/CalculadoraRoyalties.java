package br.tre;

import java.util.List;

import br.tre.dao.VendaRepository;
import br.tre.modelo.Venda;

public class CalculadoraRoyalties {

	private CalculadoraComissao calculadoraComissao;
	private VendaRepository vendaRepository;
	
	public CalculadoraRoyalties(CalculadoraComissao calculadoraComissao,
			VendaRepository vendaRepository) {
		this.calculadoraComissao = calculadoraComissao;
		this.vendaRepository = vendaRepository;
	}

	public double calcularRoyalties(int mes, int ano) {
		List<Venda> vendas = this.vendaRepository.obterVendasPorMesEAno(ano, mes);
		
		Venda venda = vendas.get(0);
		
		double valorVenda = venda.getValor();
		
		return 0.2* (valorVenda-this.calculadoraComissao.calculaComissao(valorVenda));
		
	}

}
