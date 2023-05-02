package br.ufrn.imd.modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Girafa extends Animal {
	private int tamanhoLingua;

	public Girafa(String nome, Date dataNascimento, int peso, boolean alimentado, String alimentacao, int tamanhoLingua, Date ultimaConsulta) {
		super(nome, dataNascimento, peso, alimentado, alimentacao, ultimaConsulta);
		this.tamanhoLingua = tamanhoLingua;
	}

	public int getTamanhoLingua() {
		return tamanhoLingua;
	}

	public void setTamanhoLingua(int tamanhoLingua) {
		this.tamanhoLingua = tamanhoLingua;
	}
	

	@Override
	public void comer() {
		this.alimentado = true;
		this.peso += 0.1 * this.peso;
		
		System.out.println("Girafa comendo " + alimentacao);
	}
	
	@Override
	public String getAnimalInfo() {
		String output = super.getAnimalInfo();
		output += "Tamanho da lingua: " + this.tamanhoLingua + "\n";
		return output;
	}
	
	@Override
	public boolean precisaConsulta() {
		
		LocalDate ultimaConsultaLocalDate = ultimaConsulta.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int anosSemConsulta = Period.between(ultimaConsultaLocalDate, LocalDate.now()).getYears();
		
		return anosSemConsulta >= 5;
	}
}
