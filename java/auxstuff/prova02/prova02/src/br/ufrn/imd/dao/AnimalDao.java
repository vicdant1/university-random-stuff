package br.ufrn.imd.dao;

import java.util.ArrayList;

import br.ufrn.imd.modelo.Animal;
import br.ufrn.imd.modelo.Elefante;
import br.ufrn.imd.modelo.Girafa;
import br.ufrn.imd.modelo.Tigre;

public class AnimalDao {
	private ArrayList<Animal> animais;
	
	public AnimalDao() {
		this.animais = new ArrayList<Animal>();
	}
	
	public void adicionarAnimal(Animal animal) {
		this.animais.add(animal);
	}
	
	public String getInfoAnimais() {
		String output = "==================== LISTA DE ANIMAIS ====================\n";
		
		for(Animal animal : this.animais) {
			output += animal.getAnimalInfo();
		}
		
		return output;
	}
	
	public int getTotalComidaHerbivoros() {
		int totalComida = 0;
		
		for(Animal animal : this.animais) {
			if(animal instanceof Elefante) {
				totalComida += 0.15 * animal.getPeso();
			}
			
			if(animal instanceof Girafa) {
				totalComida += 0.15 * animal.getPeso();
			}
		}
		
		return totalComida;
	}
	
	public int getTotalComidaCarnivoros() {
		int totalComida = 0;
		
		for(Animal animal : this.animais) {
			if(animal instanceof Tigre) {
				totalComida += 0.04 * animal.getPeso();
			}
		}
		
		return totalComida;
	}
	
	public String getAnimaisConsulta() {
		String output = "";
		for(Animal animal : this.animais) {
			if(animal.precisaConsulta()) {
				output += "O animal " + animal.getNome() + " " + animal.getClass() + " " + "precisa de consulta\n";
			}
		}
		
		return output;
	}
	
	
	public String getListaAnimaisPorIdade() {
		
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
        

		return output;
	}
	
}
