package br.ufrn.imd.model;

public class Elefante extends Animal {
	private int tamanhoTromba;

	public int getTamanhoTromba() {
		return tamanhoTromba;
	}

	public void setTamanhoTromba(int tamanhoTromba) {
		this.tamanhoTromba = tamanhoTromba;
	}
	
	@Override
	public void comer() {
		alimentado = true;
		peso += peso * 0.15;
		
		System.out.println("Elefante comeu");
	}
	
	@Override
	public String getAnimalInfo() {
		String output = super.getAnimalInfo();
		output += "Tamanho da tromba: " + this.tamanhoTromba + "\n";
		return output;
	}
}
