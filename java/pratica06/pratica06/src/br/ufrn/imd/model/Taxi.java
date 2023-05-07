package br.ufrn.imd.model;

import br.ufrn.imd.model.Interfaces.ICarbonFootprint;

public class Taxi extends Veiculo implements ICarbonFootprint{
	private int quantidadePessoas;

	@Override
	public double getCarbonFootprint() {
		return this.quilometragemMensal * 1.10;
	}

	public Taxi(int quilometragemMensal, int quantidadePessoas) {
		super(quilometragemMensal);
		this.quantidadePessoas = quantidadePessoas;
	}

	public int getQuantidadePessoas() {
		return quantidadePessoas;
	}

	public void setQuantidadePessoas(int quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}
	
	
}
