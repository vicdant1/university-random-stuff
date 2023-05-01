package br.imd.ufrn.modelo;

import java.util.Date;

public class ProfessorHorista extends Professor {

	private double horasTrabalhadas;
	private static final double VALOR_HORA = 25.0;
	

	public ProfessorHorista(String nome, String matricula, Date dataNascimento, String nivelEscolaridade,
			String disciplina, double horasTrabalhadas, double salario) {
		super(nome, matricula, dataNascimento, nivelEscolaridade, disciplina, salario);
		setSalario(horasTrabalhadas);
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public static double getValorHora() {
		return VALOR_HORA;
	}
	
	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	@Override
	public void setSalario(double horasTrabalhadas) {
		this.salario = horasTrabalhadas * VALOR_HORA;
	}
	
	@Override
	public void lecionar() {
		System.out.println("Professor horista lecionando " + disciplina);
	}
}
