package br.ufrn.imd.model;

import br.ufrn.imd.exceptions.AcimaVelocidadeException;

public class Automovel {
	protected static final int velocidadeMaxima = 120;
	
	protected int velocidadeAtual;
	
	
	public void acelerar(int velocidade) throws AcimaVelocidadeException {
		this.velocidadeAtual += velocidade;
		
		if(this.velocidadeAtual > velocidadeMaxima) {
			throw new AcimaVelocidadeException("Excedeu a velocidade máxima.");
		}
	}
	

}
