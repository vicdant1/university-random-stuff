package br.ufrn.imd.modelo;

public class ProfessorHorista extends Professor {
	
	private static final double VALOR_HORA = 25.0;
	private double horasTrabalhadas;

	public static double getVALOR_HORA() {
		return VALOR_HORA;
	}

	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	@Override
	public void setSalario(double hh) {
		this.salario = hh * VALOR_HORA;
	}
	
	@Override
	public void lecionar() {
		System.out.println("Professor Horista lecionando " + this.getDisciplina());
	}

}
