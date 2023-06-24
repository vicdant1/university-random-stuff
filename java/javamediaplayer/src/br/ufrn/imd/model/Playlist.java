package br.ufrn.imd.model;

import java.util.ArrayList;

public class Playlist {
	private String userId;
	private String nome;
	private ArrayList<String> musicas;
	
	
	public Playlist(String userId, String nome, ArrayList<String> musicas) {
		this.userId = userId;
		this.nome = nome;
		this.musicas = musicas;
	}
	
	public Playlist(String userId, String nome) {
		this.userId = userId;
		this.nome = nome;
		this.musicas = new ArrayList<String>();
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNome() {
		return nome;
	}
	
	public ArrayList<String> getMusicsName(){
		ArrayList<String> ret = new ArrayList<String>();
		
		for(String song : this.musicas) {
			
			ret.add(song.split(",")[0]);
		}
		
		return ret;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<String> getMusicas() {
		return musicas;
	}
	public void setMusicas(ArrayList<String> musicas) {
		this.musicas = musicas;
	}
}
