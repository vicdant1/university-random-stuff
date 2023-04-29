package br.ufrn.imd.controle;

import java.util.ArrayList;

import br.ufrn.imd.dominio.Professor;
import br.ufrn.imd.dominio.ProfessorHorista;
import br.ufrn.imd.dominio.ProfessorIntegral;

public class ProfessorDAO {
	private ArrayList<Professor> professores;
	
	public ProfessorDAO() {
		this.professores = new ArrayList<Professor>();
		// TODO Auto-generated constructor stub
	}
	
	public void adicionarProfessor(Professor professor) {
		this.professores.add(professor);
	}
	
	public void removerProfessor(Professor professor) {
		this.professores.remove(professor);
	}
	
	public void informarQuantidadeProfessores() {
		System.out.println("Quantidade de professores na escola: " + this.professores.size());
	}
	
	public void informarProfessorMaiorSalario() {
		Professor profMaiorSalario = new Professor();
		for(Professor prof : this.professores) {
			if(profMaiorSalario.getSalario() < prof.getSalario())
				profMaiorSalario = prof;
		}
		
		System.out.println("O professor de maior salário é " + profMaiorSalario.getNome() + " e tem um salário de R$" + profMaiorSalario.getSalario());
	}
	
	public void informarProfessorMaisJovem() {
		Professor profMaisJovem = new Professor();
		for(Professor prof : this.professores) {
			if(prof.getDataNascimento().after(profMaisJovem.getDataNascimento()))
				profMaisJovem = prof;
		}
		
		System.out.println("O professor mais jovem é " + profMaisJovem.getNome());
	}
	
	public void informarProfessorMaisAntigo() {
		Professor profMaisAntigo = new Professor();
		for(Professor prof : this.professores) {
			if(prof instanceof ProfessorHorista)
				continue;
			
			if(((ProfessorIntegral)prof).getDataInicio().before(((ProfessorIntegral)profMaisAntigo).getDataInicio())) {
				profMaisAntigo = prof;
			}
		}
		
		System.out.println("O professor mais antigo é " + profMaisAntigo.getNome());
	}
	
	// ajustar salario professores horistas
	public void listarTotalSalariosPagos() {
		System.out.println("Salários a serem pagos");
		for(Professor prof : this.professores) {
			System.out.println(prof.getMatricula() + " " + prof.getNome() + " R$ " + prof.getSalario());
		}
		
		System.out.println();
	}
	
	public void calcularMediaHorasTrabalhadas() {
		int totalHoras = 0;
		int totalProfHorista = 0;
		
		for(Professor prof : this.professores) {
			if(prof instanceof ProfessorIntegral) {
				continue;
			}
			
			totalHoras += ((ProfessorHorista)prof).getHorasTrabalhadas();
			totalProfHorista++;
		}
		
		System.out.println("Média de horas trabalhadas pelos horistas: " + totalHoras/totalProfHorista);
	}
	
	public void listarProfessoresPortuguesMatematica() {
		
		for(Professor prof : this.professores) {
			String disciplina = prof.getDisciplina().toLowerCase();
			if(disciplina.equals("português") || disciplina.equals("matemática")) {
				System.out.println(prof.getMatricula() + " " + prof.getNome());
			}
		}
	}
	
	public void listarProfessoresMestradoDoutorado() {
		
		for(Professor prof : this.professores) {
			String nivelEscolaridade = prof.getDisciplina().toLowerCase();
			if(nivelEscolaridade.equals("mestrado") || nivelEscolaridade.equals("doutorado")) {
				System.out.println(prof.getMatricula() + " " + prof.getNome());
			}
		}
	}
	
}
