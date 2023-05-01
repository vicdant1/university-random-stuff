package br.ufrn.imd.dao;

import java.util.ArrayList;
import br.ufrn.imd.modelo.Professor;
import br.ufrn.imd.modelo.ProfessorHorista;
import br.ufrn.imd.modelo.ProfessorIntegral;

public class ProfessorDAO {
	
	private ArrayList<Professor> professores;
	
	public ProfessorDAO() {
		this.professores = new ArrayList<Professor>();
	}
	
	// método add
	public void addProfessor(Professor p) {
		professores.add(p);
		System.out.println("Professor inserido!!!");
	}
		
	// método remove
	public void removeProfessor(Professor p) {
		professores.remove(p);
		System.out.println("Professor removido!!!");
	}
		
	// método para retornar a quantidade
	public int quantidadeDeProfessores() {
		return professores.size();
	}
		
	// método para retornar o maior salário
	public Professor maiorSalario() {
		Professor p = null;
		if (professores.size() > 0) {
			double maior = 0;
			for(int i = 0; i < professores.size(); i++) {
				if(professores.get(i).getSalario() >= maior) {
					p = professores.get(i);
					maior = p.getSalario();
				}
			}
		}
		return p;
	}
		
	// método para retornar a menor idade
	public Professor maisNovo(){ 
		if (professores.size() <= 0) {
			System.out.println("Nenhum professor cadastrado.");
			return null;
		}
		Professor mais_novo = (this.professores).get(0);
		for (Professor p : this.professores) {
			if (mais_novo.getDataNascimento().before(p.getDataNascimento())) {
				mais_novo = p;
			}
		} 
		return mais_novo; 
	}
	
	// método para retornar a maior idade
	public Professor maisVelho() {
		Professor aux = null;
		
		if (professores.size() <= 0) {
			System.out.println("Nenhum professor cadastrado.");
			return null;
		}
		
		for (Professor p : this.professores) {
			if (p instanceof ProfessorIntegral) {
				aux = p;
			}
		}
		
		Professor mais_velho = aux;
		for (Professor p : this.professores) {
			if (p instanceof ProfessorIntegral) { 
				if (((ProfessorIntegral) mais_velho).getDataInicio().after(((ProfessorIntegral)p).getDataInicio())) {
					mais_velho = p;
				}
			}
			
		} 
		return mais_velho; 
	}
	
	// Total de salários
	public String totalSalarios() {
	    double total = 0;
	    for (Professor professorIterador : this.professores) {
	      total = total + professorIterador.getSalario();
	    }
	    return "Total de Salarios a Serem Pagos: R$ " + total;
	}
	
	public String mediaHoristas() {
	    double total = 0;
	    int contador = 0;
	    for (Professor professorIterador : this.professores) {
	      if (professorIterador instanceof ProfessorHorista) {
	        contador += 1;
	        total = total + ((ProfessorHorista) professorIterador).getHorasTrabalhadas();
	      }
	    }
	    total = total / contador;
	    return "Média dos Professores Horistas: " + total;
	}
	
	// Professores que lecionam Português e Matemática
	public String professoresMaterias() {
	    String result = "\n";
	    for (Professor professorIterador : this.professores) {
	      if (professorIterador.getDisciplina().equals("Português")
	          || professorIterador.getDisciplina().equals("Matemática")) {
	        result += professorIterador.getNome() + " - " + professorIterador.getDisciplina() + " ("
	            + professorIterador.getMatricula() + ")\n";
	      }
	    }
	    return "Professores de Portugues e Matematica: " + result;
	}
	
	// Professores com nível superior
	public String professoresSuperior() {
	    String result = "\n";
	    for (Professor professorIterador : this.professores) {
	      if (professorIterador.getNivelEscolaridade().equals("Mestrado")
	          || professorIterador.getNivelEscolaridade().equals("Doutorado")) {
	        result += professorIterador.getNome() + " - " + professorIterador.getNivelEscolaridade() + " ("
	            + professorIterador.getMatricula() + ")\n";
	      }
	    }
	    return "Professores com Mestrado e Doutorado: " + result;
	}
}
