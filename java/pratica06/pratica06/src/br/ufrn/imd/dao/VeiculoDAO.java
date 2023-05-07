package br.ufrn.imd.dao;

import java.util.ArrayList;

import br.ufrn.imd.model.Carro;
import br.ufrn.imd.model.Moto;
import br.ufrn.imd.model.Taxi;
import br.ufrn.imd.model.Veiculo;

public class VeiculoDAO {
	
	private ArrayList<Veiculo> veiculos;

	public VeiculoDAO() {
		this.veiculos = new ArrayList<Veiculo>();
	}
	
	public void adicionarVeiculo(Veiculo veiculo) {
		this.veiculos.add(veiculo);
	}
	
	public void removerVeiculo(Veiculo veiculo) {
		this.veiculos.remove(veiculo);
	}
	
	public String getCarbonFootprint() {
		String output = "================= CarbonFootprint =================\n";
		for(Veiculo veiculo : this.veiculos) {
			if(veiculo instanceof Carro) {
				output += veiculo.getClass() + " " + ((Carro)veiculo).getCarbonFootprint() + "\n";
			}
			else if(veiculo instanceof Moto) {
				output += veiculo.getClass() + " " + ((Moto)veiculo).getCarbonFootprint() + "\n";
			}
			else {
				output += veiculo.getClass() + " " + ((Taxi)veiculo).getCarbonFootprint() + "\n";
			}
		}
		
		output += "===================================================\n";
		
		return output;
	}
}
