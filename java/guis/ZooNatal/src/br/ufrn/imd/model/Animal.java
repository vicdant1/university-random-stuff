package br.ufrn.imd.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Animal {
	protected String nome;
	protected Date dataNascimento;
	protected double peso;
	protected String tipoAlimentacao;
	protected boolean alimentado;
	
	public Animal() {
		alimentado = false;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getTipoAlimentacao() {
		return tipoAlimentacao;
	}
	public void setTipoAlimentacao(String tipoAlimentacao) {
		this.tipoAlimentacao = tipoAlimentacao;
	}
	public boolean isAlimentado() {
		return alimentado;
	}
	public void setAlimentado(boolean alimentado) {
		this.alimentado = alimentado;
	}
	
	public void comer() {
		alimentado = true;
		peso += peso * 0.05;
		System.out.println("Animal comendo");
	}
	
	public int calcularIdade(Animal animal) {
		LocalDate nascimentoLocalDate = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return Period.between(nascimentoLocalDate, LocalDate.now()).getYears();
	}
	
	public String getAnimalInfo() {
		String output = "\n\nInformacao sobre o animal " + this.nome + "\n";
		
		output += "Nome: " + this.nome + "\n";
		output += "Idade: " + calcularIdade(this) + "\n";
		output += "Peso: " + this.peso + "\n";
		output += "Alimentado: " + this.alimentado + "\n";
		output += "Alimentacao: " + this.tipoAlimentacao + "\n";

		
		return output;
	}
	
}
