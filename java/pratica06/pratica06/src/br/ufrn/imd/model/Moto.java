package br.ufrn.imd.model;

import br.ufrn.imd.model.Interfaces.ICarbonFootprint;

public class Moto extends Veiculo implements ICarbonFootprint {
	private int cilindrada;

	@Override
	public double getCarbonFootprint() {
		if(this.cilindrada > 650) {
			return this.quilometragemMensal * 0.65;
		}
		else if (this.cilindrada < 150) {
			return this.quilometragemMensal * 0.2;
		}
		else {
			return this.quilometragemMensal * 0.5;
		}
	}

	public Moto(int quilometragemMensal, int cilindrada) {
		super(quilometragemMensal);
		this.cilindrada = cilindrada;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	
}
