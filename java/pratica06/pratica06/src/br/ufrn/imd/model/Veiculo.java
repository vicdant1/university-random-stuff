package br.ufrn.imd.model;

public class Veiculo {
	public static final double PRECO_GASOLINA = 5.17;
	
	protected int quilometragemMensal;
	
	public Veiculo(int quilometragemMensal) {
		this.quilometragemMensal = quilometragemMensal;
	}

	public int getQuilometragemMensal() {
		return quilometragemMensal;
	}

	public void setQuilometragemMensal(int quilometragemMensal) {
		this.quilometragemMensal = quilometragemMensal;
	}
	
	public double calcularCustoMensal() {
		// Naturalmente o cálculo depende da autonomia do carro
		double autonomia = 17.00; // Km/L
		return (this.quilometragemMensal)/autonomia * PRECO_GASOLINA;
	}

}
