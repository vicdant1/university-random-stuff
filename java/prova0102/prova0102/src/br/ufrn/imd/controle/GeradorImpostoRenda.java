package br.ufrn.imd.controle;

import br.ufrn.imd.model.Pessoa;

public class GeradorImpostoRenda {
	
	private double totalTributo;
	
	public double calculaValorTotalTributo(Pessoa p) {
		double tributos = 0;
		tributos += p.calcularImpostoSalario();
		tributos += p.getConta().calcularTributos();
		tributos += p.getSeguro().calcularTributos();
		
		setTotalTributo(tributos);
		
		return totalTributo;
	}

	public double getTotalTributo() {
		return totalTributo;
	}

	public void setTotalTributo(double totalTributo) {
		this.totalTributo = totalTributo;
	}

}
