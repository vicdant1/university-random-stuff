package br.ufrn.imd.dados;

import java.util.ArrayList;

import br.ufrn.imd.modelo.Contato;

public class BancoContatos {
	private static BancoContatos instance;
	private ArrayList<Contato> contatos;

	public BancoContatos() {
		this.contatos = new ArrayList<Contato>();
	}
	
	public static BancoContatos getInstance() {
		if(instance == null) {
			instance = new BancoContatos();
		}
		
		return instance;
	}
	
	
	public void addContato(Contato contato) {
		this.contatos.add(contato);
	}
	
	public ArrayList<Contato> getContatos(){
		return this.contatos;
	}
	
	public Contato getContatoByNome(String nome) {
		for(Contato contato : this.contatos) {
			if(contato.getNome().toLowerCase().equals(nome.toLowerCase())) {
				return contato;
			}
		}
		
		return null;
	}
	
	public boolean excluirContato(Contato contato) {
		return this.contatos.remove(contato);
	}
	
	
	
}
