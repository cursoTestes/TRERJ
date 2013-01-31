package br.tre;

public class Calculadora {

	public double calcular(double entrada) {
		
		double faixaComissao = 10000;
		double comissao = 0.0;
		
		if(entrada > faixaComissao)
		{
			comissao = entrada * 0.06;
		}else{
			comissao = entrada * 0.05; 
		}
		
		return Math.floor(comissao * 100)/100.0;
	}


}
