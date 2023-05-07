package br.ufrn.imd.view;

import br.ufrn.imd.dao.VeiculoDAO;
import br.ufrn.imd.model.Carro;
import br.ufrn.imd.model.Moto;
import br.ufrn.imd.model.Taxi;
import br.ufrn.imd.model.Veiculo;

public class VeiculoView {
	public static void main(String[] args) {
		VeiculoDAO db = new VeiculoDAO();
		
		
		Veiculo carro1 = new Carro(100, 2.5);
		Veiculo carro2 = new Carro(120, 0.9);
		
		Veiculo taxi1 = new Taxi(100, 3);
		Veiculo taxi2 = new Taxi(130, 4);
		
		Veiculo moto1 = new Moto(200, 2);
		Veiculo moto2 = new Moto(160, 1);
		
		db.adicionarVeiculo(carro1);
		db.adicionarVeiculo(carro2);
		db.adicionarVeiculo(taxi1);
		db.adicionarVeiculo(taxi2);
		db.adicionarVeiculo(moto1);
		db.adicionarVeiculo(moto2);
		
		System.out.println(db.getCarbonFootprint());
		
	}
}
