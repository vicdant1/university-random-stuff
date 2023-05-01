package br.ufrn.imd.modelo;

import java.util.Date;

public class ProfessorIntegral extends Professor{
	
	private Date dataInicio;
	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Override
	public void lecionar() {
		System.out.println("Professor Integral lecionando " + this.getDisciplina());
	}
}
