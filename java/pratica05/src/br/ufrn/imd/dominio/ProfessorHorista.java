package br.ufrn.imd.dominio;

import java.util.Date;

public class ProfessorHorista extends Professor{
	
	private int horasTrabalhadas;

	public ProfessorHorista(String nome, String matricula, Date dataNascimento, double salario,
			String nivelEscolaridade, String disciplina, int horasTrabalhadas) {
		super(nome, matricula, dataNascimento, salario, nivelEscolaridade, disciplina);
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	@Override
	public void lecionar() {
		System.out.println("Professor horista lecionando");
	}
}
