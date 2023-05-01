package br.imd.ufrn.dao;

import java.util.ArrayList;

import br.imd.ufrn.modelo.Professor;
import br.imd.ufrn.modelo.ProfessorHorista;

public class ProfessorDAO {
	
	private ArrayList<Professor> professores;

	public ProfessorDAO() {
		this.professores = new ArrayList<Professor>();
	}
	
	public void addProfessor(Professor professor) {
		this.professores.add(professor);
	}
	
	public void removeProfessor(Professor professor) {
		this.professores.remove(professor);
	}
	
	public int getQuantidadeProfessores() {
		return this.professores.size();
	}
	
	public Professor getProfessorMaiorSalario() {
		if(this.professores.size() <= 0) {
			System.out.println("Nenhum professor cadastrado");
		}
		
		Professor profMaiorSalario = this.professores.get(0);
		
		for(Professor prof : this.professores) {
			if(profMaiorSalario.getSalario() < prof.getSalario()) {
				profMaiorSalario = prof;
			}
		}
		
		return profMaiorSalario;
	}
	
	public Professor getProfessorMaisNovo() {
		if(this.professores.size() <= 0) {
			System.out.println("Nenhum professor cadastrado");
		}
		
		Professor profMaisNovo = this.professores.get(0);
		
		for(Professor prof : this.professores) {
			if(profMaisNovo.getDataNascimento().before(prof.getDataNascimento())) {
				profMaisNovo = prof;
			}
		}
		
		return profMaisNovo;
	}
	
	public Professor getProfessorMaisVelho() {
		if(this.professores.size() <= 0) {
			System.out.println("Nenhum professor cadastrado");
		}
		
		Professor profMaisVelho = this.professores.get(0);
		
		for(Professor prof : this.professores) {
			if(profMaisVelho.getDataNascimento().after(prof.getDataNascimento())) {
				profMaisVelho = prof;
			}
		}
		
		return profMaisVelho;
	}
	
	public String getTotalSalarios() {
		double totalSalario = 0;
		for(Professor prof : this.professores) {
			totalSalario += prof.getSalario();
		}
		
		return "Total de salários a ser pago: R$ " + totalSalario;
	}
	
	public String getMediaHoristas() {
		int qtdHoristas = 0;
		double qtdHoras = 0;
		
		for(Professor prof : this.professores) {
			if(prof instanceof ProfessorHorista) {
				qtdHoristas++;
				qtdHoras = ((ProfessorHorista) prof).getHorasTrabalhadas();
			}
		}
		
		return "Média de horas trabalhadas " + qtdHoras/qtdHoristas;
		
	}
	
	public String getProfessoresMaterias() {
		String result = "Professores de português e matemática: ";
		
		for(Professor prof : this.professores) {
			if(prof.getDisciplina().toLowerCase().equals("matemática") || 
			   prof.getDisciplina().toLowerCase().equals("português")) {
				result += prof.getMatricula() + " " + prof.getNome() + "\n";
			}
		}
		
		return result;
	}
	
	public String getProfessoresMestradoDoutorado() {
		String result = "Professores com mestrado e doutorado: ";
		
		for(Professor prof : this.professores) {
			if(prof.getNivelEscolaridade().toLowerCase().equals("mestrado") || 
			   prof.getNivelEscolaridade().toLowerCase().equals("doutorado")) {
				result += prof.getMatricula() + " " + prof.getNome() + "\n";
			}
		}
		
		return result;
	}
	

}
