package br.ufrn.imd.modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Tigre extends Animal {
	private String tipoTigre;
	
	public Tigre(String nome, Date dataNascimento, int peso, boolean alimentado, String alimentacao, String tipoTigre, Date ultimaConsulta) {
		super(nome, dataNascimento, peso, alimentado, alimentacao, ultimaConsulta);
		this.tipoTigre = tipoTigre;
	}
	
	

	public String getTipoTigre() {
		return tipoTigre;
	}



	public void setTipoTigre(String tipoTigre) {
		this.tipoTigre = tipoTigre;
	}



	@Override
	public void comer() {
		this.alimentado = true;
		this.peso += 0.04 * this.peso;
		
		System.out.println("Girafa comendo " + alimentacao);
	}
	
	@Override
	public String getAnimalInfo() {
		String output = super.getAnimalInfo();
		output += "Tipo do tigre: " + this.tipoTigre + "\n";
		return output;
	}

	@Override
	public boolean precisaConsulta() {
		
		LocalDate ultimaConsultaLocalDate = ultimaConsulta.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int anosSemConsulta = Period.between(ultimaConsultaLocalDate, LocalDate.now()).getYears();
		
		return anosSemConsulta >= 3;
	}
	
}
