package br.ufrn.imd.model;

public class SeguroVida implements ITributavel {
	private int numero;
	private String beneficiado;
	private double valor;
	private double taxa;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBeneficiado() {
		return beneficiado;
	}
	public void setBeneficiado(String beneficiado) {
		this.beneficiado = beneficiado;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getTaxa() {
		return taxa;
	}
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	@Override
	public double calcularTributos() {
		return 31.50;
	}
	
	
	
}
