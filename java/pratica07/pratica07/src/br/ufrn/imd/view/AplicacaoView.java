package br.ufrn.imd.view;

import br.ufrn.imd.exceptions.PistaException;
import br.ufrn.imd.model.Pista;

public class AplicacaoView {
	public static void main(String[] args) {
		Pista pista = new Pista();
		
		try {
			pista.iniciar();			
		}
		catch(PistaException pe) {
			//pe.printStackTrace();
			System.out.println("Pista bloqueada");
		}
	}
}
