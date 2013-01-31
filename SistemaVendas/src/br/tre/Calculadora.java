package br.tre;

public class Calculadora {

	public static double calculaComissao(double valorVenda) {
		double valorComissao ;
		
		if (valorVenda < 0)
			throw new RuntimeException("Valor Negativo !!!");
		
		if (valorVenda <= 10000)
			valorComissao = valorVenda * 0.05;
		else
			valorComissao = valorVenda * 0.06;
		
		return Math.floor( valorComissao * 100 ) / 100;
	}

}
