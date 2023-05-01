package br.ufrn.imd.visao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufrn.imd.dao.ProfessorDAO;
import br.ufrn.imd.modelo.Professor;
import br.ufrn.imd.modelo.ProfessorHorista;
import br.ufrn.imd.modelo.ProfessorIntegral;

public class EscolaView {
	
	public static void main(String[] args) throws ParseException {
		
		ProfessorDAO bd = new ProfessorDAO();
		
		Date dt = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		Date dt2 = new Date();
		
		ProfessorHorista prof1 = new ProfessorHorista();
		prof1.setMatricula("20150234");
		prof1.setNome("Joao da Hora");
		dt = formato.parse("16-06-1975");
		prof1.setDataNascimento(dt);
		prof1.setHorasTrabalhadas(200);
		prof1.setSalario(prof1.getHorasTrabalhadas());
		prof1.setDisciplina("Português");
		prof1.setNivelEscolaridade("Mestrado");
		
		ProfessorIntegral prof2 = new ProfessorIntegral();
		dt = formato.parse("05-02-2001");
		prof2.setDataNascimento(dt);
		dt2 = formato.parse("15-10-2019");
		prof2.setDataInicio(dt2);
		prof2.setMatricula("20110001");
		prof2.setNome("Francisco Lopes");
		prof2.setSalario(4800);
		prof2.setDisciplina("Física");
		prof2.setNivelEscolaridade("Doutorado");
		
		ProfessorHorista prof3 = new ProfessorHorista();
		dt = formato.parse("05-03-1999");
		prof3.setDataNascimento(dt);
		prof3.setMatricula("20161254");
		prof3.setNome("Maria das Virtudes");
		prof3.setHorasTrabalhadas(150);
		prof3.setSalario(prof3.getHorasTrabalhadas());
		prof3.setDisciplina("Matemática");
		prof3.setNivelEscolaridade("Mestrado");
		
		ProfessorIntegral prof4 = new ProfessorIntegral();
		dt = formato.parse("10-05-1989");
		dt2 = formato.parse("30-09-2015");
		prof4.setDataNascimento(dt);
		prof4.setDataInicio(dt2);
		prof4.setMatricula("20180102");
		prof4.setNome("Ana Maria dos Santos");
		prof4.setSalario(4800);
		prof4.setDisciplina("Português");
		prof4.setNivelEscolaridade("Mestrado");
		
		ProfessorIntegral prof5 = new ProfessorIntegral();
		dt = formato.parse("25-05-1971");
		dt2 = formato.parse("25-05-2018");
		prof5.setDataNascimento(dt);
		prof5.setDataInicio(dt2);
		prof5.setMatricula("19800001");
		prof5.setNome("Zé Lezin");
		prof5.setSalario(11500);
		prof5.setDisciplina("Física");
		prof5.setNivelEscolaridade("Doutorado");
		
		bd.addProfessor(prof1);
		bd.addProfessor(prof2);
		bd.addProfessor(prof3);
		bd.addProfessor(prof4);
		bd.addProfessor(prof5);
		
		System.out.println("Professores na escola: " + bd.quantidadeDeProfessores());
		System.out.println();
		
		Professor p = bd.maiorSalario();
		System.out.println("Professor com maior salário: " + p.getNome());
		System.out.println("salário dele: " + p.getSalario());
		System.out.println();
		
		p = bd.maisNovo();
		System.out.println("Professor mais Novo: " + p.getNome() + "\tDt. Nascimento: " + p.getDataNascimento());
		System.out.println();
		
		p = bd.maisVelho();
		System.out.println("Professor mais Antigo: " + p.getNome() + "\tDt. Inicio: " + ((ProfessorIntegral)p).getDataInicio());
		System.out.println();
		
		System.out.println("");
		System.out.println(bd.totalSalarios());
		
		System.out.println("");
		System.out.println(bd.mediaHoristas());
		
		System.out.println("");
		System.out.println(bd.professoresMaterias());
		
		System.out.println("");
		System.out.println(bd.professoresSuperior());
	}
}
