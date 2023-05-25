package br.ufrn.imd.model;

public class Girafa extends Animal {
	private int tamanhoLingua;

	public int getTamanhoLingua() {
		return tamanhoLingua;
	}

	public void setTamanhoLingua(int tamanhoLingua) {
		this.tamanhoLingua = tamanhoLingua;
	}
	
	@Override
	public void comer() {
		alimentado = true;
		peso += peso * 0.10;
		System.out.println("Girafa comeu");
	}
	
	@Override
	public String getAnimalInfo() {
		String output = super.getAnimalInfo();
		output += "Tamanho da lingua: " + this.tamanhoLingua + "\n";
		return output;
	}
	
}
