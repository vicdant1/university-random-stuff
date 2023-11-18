package br.ufrn.imd.modelo;

import java.io.Serializable;

// Deve ser um Bean:

/*
 * Possuem um construtor sem argumentos;
 * Implementam java.io.Serializable;
 * Definem métodos get/set para acesso às suas propriedades;
 * Definem métodos add/remove para manipular listeners (detalhados adiante);
 * São thread-safe.
 * */
public class Contato implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String telefoneCelular;
	private String telefoneResidencial;
	private String email;
	private String dataNascimento;

	public Contato() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
