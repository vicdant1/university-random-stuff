package br.ufrn.imd.model;

public class Tigre extends Animal {
	private String tipoTigre;

	public String getTipoTigre() {
		return tipoTigre;
	}

	public void setTipoTigre(String tipoTigre) {
		this.tipoTigre = tipoTigre;
	}
	
	@Override
	public void comer() {
		alimentado = true;
		peso += peso * 0.04;
		
		System.out.println("Tigre comeu");
	}
	
	@Override
	public String getAnimalInfo() {
		String output = super.getAnimalInfo();
		output += "Tipo do tigre: " + this.tipoTigre + "\n";
		return output;
	}
	
}
