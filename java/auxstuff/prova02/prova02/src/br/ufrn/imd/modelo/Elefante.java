package br.ufrn.imd.modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Elefante extends Animal {
	private int tamanhoTromba;

	public Elefante(String nome, Date dataNascimento, int peso, boolean alimentado, String alimentacao, int tamanhoTromba, Date ultimaConsulta) {
		super(nome, dataNascimento, peso, alimentado, alimentacao, ultimaConsulta);
		this.tamanhoTromba = tamanhoTromba;
	}

	public int getTamanhoTromba() {
		return tamanhoTromba;
	}

	public void setTamanhoTromba(int tamanhoTromba) {
		this.tamanhoTromba = tamanhoTromba;
	}
	
	@Override
	public void comer() {
		this.alimentado = true;
		this.peso += 0.15 * this.peso;
		
		System.out.println("Elefante comendo " + alimentacao);
	}
	
	@Override
	public String getAnimalInfo() {
		String output = super.getAnimalInfo();
		output += "Tamanho da tromba: " + this.tamanhoTromba + "\n";
		return output;
	}
	
	@Override
	public boolean precisaConsulta() {
		
		LocalDate ultimaConsultaLocalDate = ultimaConsulta.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int anosSemConsulta = Period.between(ultimaConsultaLocalDate, LocalDate.now()).getYears();
		
		return anosSemConsulta >= 7;
	}
}
