package br.ufrn.imd.model;

import br.ufrn.imd.model.Interfaces.ICarbonFootprint;

public class Carro extends Veiculo implements ICarbonFootprint {
	private double motor;

	@Override
	public double getCarbonFootprint() {
		if(this.motor > 2.0) {
			return this.quilometragemMensal * 1.85;
		}
		else if (this.motor < 1.0){
			return this.quilometragemMensal * 0.13;
		}
		else {
			return this.quilometragemMensal * 1.22;
		}
	}

	public Carro(int quilometragemMensal, double motor) {
		super(quilometragemMensal);
		this.motor = motor;
		// TODO Auto-generated constructor stub
	}

	public double getMotor() {
		return motor;
	}

	public void setMotor(double motor) {
		this.motor = motor;
	} 
}
