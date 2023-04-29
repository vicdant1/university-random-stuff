package br.ufrn.imd.visao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufrn.imd.controle.ProfessorDAO;
import br.ufrn.imd.dominio.Professor;
import br.ufrn.imd.dominio.ProfessorHorista;
import br.ufrn.imd.dominio.ProfessorIntegral;

public class EscolaView {
	public static void main(String[] args) throws ParseException {
		ProfessorDAO db = new ProfessorDAO();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
		
		Professor prof1 = new ProfessorHorista("Jorge", "202032", formatter.parse("03-10-2001"), 20.00, "Mestrado", "Matemática", 20);
		Professor prof2 = new ProfessorHorista("João", "202332", formatter.parse("04-10-1998"), 25.00, "Mestrado", "Matemática", 20);
		Professor prof3 = new ProfessorHorista("Carlos", "202033", formatter.parse("04-04-1994"), 22.00, "Doutorado", "Física", 25);
		Professor prof4 = new ProfessorHorista("Tonho", "202039", formatter.parse("03-10-1985"), 26.00, "Superior", "Português", 10);
	
		Professor prof5 = new ProfessorIntegral("Jesus", "202011", formatter.parse("03-10-1992"), 2000.00, "Mestrado", "Geografia", formatter.parse("03-08-2015"));
		Professor prof6 = new ProfessorIntegral("Maomé", "202015", formatter.parse("03-10-1956"), 4500.00, "Especialização", "Biologia", formatter.parse("12-04-1995"));
		Professor prof7 = new ProfessorIntegral("Mister", "2020302", formatter.parse("03-10-1994"), 2650.00, "Mestrado", "Geografia", formatter.parse("05-03-2002"));
		Professor prof8 = new ProfessorIntegral("Tassio", "2020552", formatter.parse("03-11-1990"), 5000.00, "Doutorado", "Geografia", formatter.parse("08-04-2020"));
	
		
		db.adicionarProfessor(prof1);
		db.adicionarProfessor(prof2);
		db.adicionarProfessor(prof3);
		db.adicionarProfessor(prof4);
		db.adicionarProfessor(prof5);
		db.adicionarProfessor(prof6);
		db.adicionarProfessor(prof7);
		db.adicionarProfessor(prof8);

		db.informarQuantidadeProfessores();
		db.informarProfessorMaiorSalario();
		db.informarProfessorMaisJovem();
		db.informarProfessorMaisAntigo();
		db.listarTotalSalariosPagos();
		db.calcularMediaHorasTrabalhadas();
		db.listarProfessoresPortuguesMatematica();
		db.listarProfessoresMestradoDoutorado();
		
		db.removerProfessor(prof8);
		
		db.informarQuantidadeProfessores();
		
	}
	

}
