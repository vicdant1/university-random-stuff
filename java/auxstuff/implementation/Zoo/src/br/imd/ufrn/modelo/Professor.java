package br.imd.ufrn.modelo;

import java.util.Date;

public class Professor {
	protected String nome;
	protected String matricula;
	protected Date dataNascimento;
	protected String nivelEscolaridade;
	protected String disciplina;
	protected double salario;
	
	
	public Professor(String nome, String matricula, Date dataNascimento, String nivelEscolaridade, String disciplina, double salario) {
		this.nome = nome;
		this.matricula = matricula;
		this.dataNascimento = dataNascimento;
		this.nivelEscolaridade = nivelEscolaridade;
		this.disciplina = disciplina;
		this.salario = salario;
	}
	
	
	
	public double getSalario() {
		return salario;
	}



	public void setSalario(double salario) {
		this.salario = salario;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNivelEscolaridade() {
		return nivelEscolaridade;
	}
	public void setNivelEscolaridade(String nivelEscolaridade) {
		this.nivelEscolaridade = nivelEscolaridade;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public void lecionar() {
		System.out.println("Professor lecionando " + disciplina);
	}

}
