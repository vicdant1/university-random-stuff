package br.ufrn.imd.model;

import br.ufrn.imd.exceptions.AcimaVelocidadeException;
import br.ufrn.imd.exceptions.PistaException;

public class Pista {
	public Pista() {}
	
	public void iniciar() throws PistaException {
		try {
			Automovel automovel = new Automovel();
			
			automovel.acelerar(100);
		}
		catch(AcimaVelocidadeException ave) {
			throw new PistaException("Pista com problemas: ", ave);
		}
	}
	
	
}
