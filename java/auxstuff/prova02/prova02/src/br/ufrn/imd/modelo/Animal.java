package br.ufrn.imd.modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Animal {
	protected String nome;
	protected Date dataNascimento;
	protected int peso;
	protected boolean alimentado;
	protected String alimentacao;
	protected Date ultimaConsulta;
	
	public Animal(String nome, Date dataNascimento, int peso, boolean alimentado, String alimentacao, Date ultimaConsulta) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.peso = peso;
		this.alimentado = false;
		this.alimentacao = alimentacao;
		this.ultimaConsulta = ultimaConsulta;
	}
	
	public Animal() {
		this.alimentado = false;
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
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public boolean isAlimentado() {
		return alimentado;
	}
	public void setAlimentado(boolean alimentado) {
		this.alimentado = alimentado;
	}
	public String getAlimentacao() {
		return alimentacao;
	}
	public void setAlimentacao(String alimentacao) {
		this.alimentacao = alimentacao;
	}
	
	public Date getUltimaConsulta() {
		return ultimaConsulta;
	}

	public void setUltimaConsulta(Date ultimaConsulta) {
		this.ultimaConsulta = ultimaConsulta;
	}

	public void comer() {
		this.alimentado = true;
		this.peso += 0.05 * this.peso;
		
		System.out.println("Animal comendo " + alimentacao);
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
		output += "Alimentacao: " + this.alimentacao + "\n";
		output += "Ultima Consulta: " + this.ultimaConsulta + "\n";
		
		return output;
	}
	
	public boolean precisaConsulta() {
		return false;
	}
}
