package br.ufrn.imd.model;

public class ContaCorrente implements ITributavel {
	private String agencia;
	private String numero;
	private double saldo;
	
	public void sacar(double valor) {

		if(valor > this.saldo){
			System.out.println("Saldo insuficiente ou valor menor que 0!");
			return;
		}
		
		this.saldo -= valor;
		
		System.out.println("Saque de R$ " + valor + " em [" + this.numero + "]" + " efetuado com sucesso!");
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
		System.out.println("Depósito de R$ " + valor + " em [" + this.numero + "]" + " efetuado com sucesso!");
	}
	
	public boolean transferir(double valor, ContaCorrente cc) {
		if(this.saldo >= valor) {
			System.out.println("Transferindo R$ " + valor + " para [" + cc.getNumero() + "]");
			sacar(valor);
			cc.depositar(valor);
			
			return true;
		}
		return false;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public double calcularTributos() {
		return this.saldo * 0.0038;
	}
	
	
	
}
