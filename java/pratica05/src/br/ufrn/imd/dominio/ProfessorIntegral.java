package br.ufrn.imd.dominio;

import java.util.Date;

public class ProfessorIntegral extends Professor {
	private Date dataInicio;

	public ProfessorIntegral(String nome, String matricula, Date dataNascimento, double salario,
			String nivelEscolaridade, String disciplina, Date dataInicio) {
		super(nome, matricula, dataNascimento, salario, nivelEscolaridade, disciplina);
		this.dataInicio = dataInicio;		
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Override
	public void lecionar() {
		System.out.println("Professor integral lecionando");
	}
}
