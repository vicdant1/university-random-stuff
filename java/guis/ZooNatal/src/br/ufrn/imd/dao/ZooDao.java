package br.ufrn.imd.dao;

import java.util.ArrayList;

import br.ufrn.imd.model.Animal;
import br.ufrn.imd.model.Elefante;
import br.ufrn.imd.model.Girafa;
import br.ufrn.imd.model.Tigre;

public class ZooDao {
	private static ZooDao zooDao;
	
	private ArrayList<Animal> animais;
	
	public ZooDao() {
		this.animais = new ArrayList<Animal>();
	}
	
	public static ZooDao getInstance() {
		if(zooDao == null)
			zooDao = new ZooDao();
		
		return zooDao;
	}
	
	public void adicionarAnimal(Animal animal) {
		this.animais.add(animal);
	}
	
	public void getInfoAnimais() {
		String output = "==================== LISTA DE ANIMAIS ====================\n";
		
		for(Animal animal : this.animais) {
			output += animal.getAnimalInfo();
		}
		
		System.out.println(output);
	}
	
	public void getTotalComidaHerbivoros() {
		int totalComida = 0;
		
		for(Animal animal : this.animais) {
			if(animal instanceof Elefante) {
				totalComida += 0.15 * animal.getPeso();
			}
			
			if(animal instanceof Girafa) {
				totalComida += 0.15 * animal.getPeso();
			}
		}

		System.out.println("Total comida de Herbívoros: " + totalComida + " Kg");
	}
	
	public void getTotalComidaCarnivoros() {
		int totalComida = 0;
		
		for(Animal animal : this.animais) {
			if(animal instanceof Tigre) {
				totalComida += 0.04 * animal.getPeso();
			}
		}
		
		System.out.println("Total comida de Carnívoros: " + totalComida + " Kg");
		
	}
	
	public void getAnimaisConsulta() {
		String output = "";
		for(Animal animal : this.animais) {
			if(animal instanceof Elefante) {
				if(animal.calcularIdade(animal) % 7 == 0) {
					output += "O animal " + animal.getNome() + " " + animal.getClass() + " " + "precisa de consulta\n";
					continue;
				}
			}
			if(animal instanceof Girafa) {
				if(animal.calcularIdade(animal) % 5 == 0) {
					output += "O animal " + animal.getNome() + " " + animal.getClass() + " " + "precisa de consulta\n";
					continue;
				}
			}
			if(animal instanceof Tigre) {
				if(animal.calcularIdade(animal) % 3 == 0) {
					output += "O animal " + animal.getNome() + " " + animal.getClass() + " " + "precisa de consulta\n";
					continue;
				}
			}
		}

		System.out.println(output);
	}
	
	
	public void getListaAnimaisPorIdade() {
		
		String output = "";
		
		Animal girafaMaisNova = null;
        Animal girafaMaisVelha = null;
        Animal tigreMaisNovo = null;
        Animal tigreMaisVelho = null;
        Animal elefanteMaisNovo = null;
        Animal elefanteMaisVelho = null;

        
        for(Animal animal : this.animais) {
        	if(animal instanceof Girafa) {
        		if(girafaMaisNova == null || animal.calcularIdade(animal) < animal.calcularIdade(girafaMaisNova))
        			girafaMaisNova = animal;
        		else if(girafaMaisVelha == null || animal.calcularIdade(animal) > animal.calcularIdade(girafaMaisVelha))
        			girafaMaisVelha = animal;
        	}
        	
        	if(animal instanceof Tigre) {
        		if(tigreMaisNovo == null ||animal.calcularIdade(animal) < animal.calcularIdade(tigreMaisNovo))
        			tigreMaisNovo = animal;
        		else if(tigreMaisVelho == null || animal.calcularIdade(animal) > animal.calcularIdade(tigreMaisVelho))
        			tigreMaisVelho = animal;
        	}
        	
        	if(animal instanceof Elefante) {
        		
        		if(elefanteMaisNovo == null ||animal.calcularIdade(animal) < animal.calcularIdade(elefanteMaisNovo))
        			elefanteMaisNovo = animal;
        		
        		else if(elefanteMaisVelho == null || animal.calcularIdade(animal) > animal.calcularIdade(elefanteMaisVelho))
        			elefanteMaisVelho = animal;
        		
        	}
        }
        output += "============ ANIMAIS MAIS NOVOS E MAIS VELHOS POR ESPECIE ============\n";
        output += "Elefante:\n";
        output += "Mais novo: " + elefanteMaisNovo.getNome() + " " + elefanteMaisNovo.calcularIdade(elefanteMaisNovo) + " anos\n";
        output += "Mais velho: " + elefanteMaisVelho.getNome() + " " + elefanteMaisVelho.calcularIdade(elefanteMaisVelho) + " anos\n";

        
        output += "Tigre:\n";
        output += "Mais novo: " + tigreMaisNovo.getNome() + " " + tigreMaisNovo.calcularIdade(tigreMaisNovo) + " anos\n";
        output += "Mais velho: " + tigreMaisVelho.getNome() + " " + tigreMaisVelho.calcularIdade(tigreMaisVelho) + " anos\n";
        
        
        output += "Girafa:\n";
        output += "Mais nova: " + girafaMaisNova.getNome() + " " + girafaMaisNova.calcularIdade(girafaMaisNova) + " anos\n";
        output += "Mais velha: " + girafaMaisVelha.getNome() + " " + girafaMaisVelha.calcularIdade(girafaMaisVelha) + " anos\n";
        

		System.out.println(output);
	}
	
	
	
	
	
}
