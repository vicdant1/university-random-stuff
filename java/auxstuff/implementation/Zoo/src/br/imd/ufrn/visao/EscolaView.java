package br.imd.ufrn.visao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.imd.ufrn.dao.ProfessorDAO;
import br.imd.ufrn.modelo.Professor;
import br.imd.ufrn.modelo.ProfessorHorista;
import br.imd.ufrn.modelo.ProfessorIntegral;

public class EscolaView {
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		ProfessorDAO db = new ProfessorDAO();
		
		Professor prof1 = new ProfessorIntegral("João Antônio", "202301", formatter.parse("01-01-1980"), "Mestrado", "Matemática", 4000, formatter.parse("05-08-2020"));
		Professor prof2 = new ProfessorIntegral("João Alberto", "202302", formatter.parse("02-05-1988"), "Graduação", "Física", 3000, formatter.parse("05-08-2020"));
		Professor prof3 = new ProfessorIntegral("Carlos Alberto", "202303", formatter.parse("06-10-1955"), "Graduação", "Informática", 4000, formatter.parse("01-05-2022"));
		Professor prof4 = new ProfessorIntegral("Clovis de Barros", "202304", formatter.parse("03-01-1988"), "Mestrado", "Português", 3000, formatter.parse("15-01-2019"));
		
		Professor prof5 = new ProfessorHorista("Marta", "202202", formatter.parse("05-02-2001"), "Graduação", "História", 20, 0);
		Professor prof6 = new ProfessorHorista("Thaina", "202204", formatter.parse("20-04-1995"), "Graduação", "História", 25, 0);
		Professor prof7 = new ProfessorHorista("Caio", "202205", formatter.parse("05-02-1990"), "Mestrado", "Filosofia", 30, 0);
		Professor prof8 = new ProfessorHorista("Suzana", "202208", formatter.parse("20-05-1973"), "Especialização", "Metalografia", 40, 0);
		
		db.addProfessor(prof8);
		db.addProfessor(prof7);
		db.addProfessor(prof6);
		db.addProfessor(prof5);
		db.addProfessor(prof4);
		db.addProfessor(prof3);
		db.addProfessor(prof2);
		db.addProfessor(prof1);
		
		System.out.println("Quantidade de professores na escola: " + db.getQuantidadeProfessores());
		System.out.println("Professor com maior salário: " + db.getProfessorMaiorSalario().getNome());
		System.out.println("Professor mais novo: " + db.getProfessorMaisNovo().getNome());
		System.out.println("Professor mais velho: " + db.getProfessorMaisVelho().getNome());
		System.out.println("Total salários: " + db.getTotalSalarios());
		System.out.println("Média horistas: " + db.getMediaHoristas());
		System.out.println("Professores de português e matemática: " + db.getProfessoresMaterias());
		System.out.println("Professores com mestrado e doutorado: " + db.getProfessoresMestradoDoutorado());
		
		
		
		db.removeProfessor(prof5);

		System.out.println("Quantidade de professores na escola: " + db.getQuantidadeProfessores());
	}

}
