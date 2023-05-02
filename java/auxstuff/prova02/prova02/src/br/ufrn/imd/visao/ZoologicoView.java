package br.ufrn.imd.visao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.ufrn.imd.dao.AnimalDao;
import br.ufrn.imd.modelo.Animal;
import br.ufrn.imd.modelo.Elefante;
import br.ufrn.imd.modelo.Girafa;
import br.ufrn.imd.modelo.Tigre;

public class ZoologicoView {
	
	public static void main(String[] args) throws ParseException {
		AnimalDao db = new AnimalDao();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		
		Animal elefante1 = new Elefante("Jorge", formatter.parse("03-10-2001"), 1000, false, "Folhas", 20, formatter.parse("01-05-2022"));
		Animal elefante2 = new Elefante("Tonho", formatter.parse("03-10-1990"), 1250, false, "Legumes", 25, formatter.parse("01-05-2010"));
		
		Animal girafa1 = new Girafa("Nelman", formatter.parse("02-01-2000"), 500, false, "Folhas", 30, formatter.parse("10-10-2010"));
		Animal girafa2 = new Girafa("Selma", formatter.parse("02-06-1992"), 505, false, "Folhas", 38, formatter.parse("10-10-2020"));
		
		Animal tigre1 = new Tigre("Diego", formatter.parse("02-01-2000"), 200, false, "Carninha", "Branco", formatter.parse("05-05-2022"));
		Animal tigre2 = new Tigre("Toggas", formatter.parse("02-11-1992"), 250, false, "Carne", "Generalista", formatter.parse("05-10-2019"));
		
		tigre1.comer();
		girafa1.comer();
		elefante1.comer();
		
		db.adicionarAnimal(elefante1);
		db.adicionarAnimal(elefante2);
		db.adicionarAnimal(tigre1);
		db.adicionarAnimal(tigre2);
		db.adicionarAnimal(girafa1);
		db.adicionarAnimal(girafa2);
		
		System.out.println(db.getInfoAnimais());
		System.out.println("Total de comida herbivoros: " + db.getTotalComidaHerbivoros());
		System.out.println("Total de comida canivoros: " + db.getTotalComidaCarnivoros());
		System.out.println(db.getAnimaisConsulta());
		System.out.println(db.getListaAnimaisPorIdade());
	}

}
