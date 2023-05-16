package br.ufrn.imd.dao;

import java.util.ArrayList;

import br.ufrn.imd.controle.GeradorImpostoRenda;
import br.ufrn.imd.model.Pessoa;

public class PessoaDAO {
	
	private ArrayList<Pessoa> pessoas;
	private GeradorImpostoRenda gerador;

	public PessoaDAO() {
		this.pessoas = new ArrayList<Pessoa>();
		this.gerador = new GeradorImpostoRenda();
	}
	
	public void cadastrarPessoa(Pessoa p) {
		this.pessoas.add(p);
	}
	
	public void removerPessoa(Pessoa p) {
		this.pessoas.remove(p);
	}
	
	public void listarPessoas() {
		for(Pessoa p : this.pessoas) {
			System.out.println("************************************************************************");
			System.out.print("Nome...: " + p.getNome() + " ");
			System.out.println("Salário.: " + String.format("%.2f", p.getSalario()));
			System.out.print("Agencia: " + p.getConta().getAgencia() + " ");
			System.out.print("Conta.: " + p.getConta().getNumero() + " ");
			System.out.println("Saldo.: " + String.format("%.2f", p.getConta().getSaldo()));
			System.out.print("Seguro.: " + p.getSeguro().getNumero() + " ");
			System.out.println("Beneficiario.: " + p.getSeguro().getBeneficiado());
			System.out.println("Valor Seguro: " + String.format("%.2f", p.getSeguro().getValor()));
			System.out.println("************************************************************************");
		}
	}
	
	public void calcularTributosPessoas() {
		for(Pessoa p : this.pessoas)
		{
			
			System.out.println("************************************************************************");
			System.out.println("Nome...: " + p.getNome() + " IRPF...: " + String.format("%.2f", gerador.calculaValorTotalTributo(p)));
			System.out.println("************************************************************************");
		}
	}
	
	public void imprimeImpostoTotal() {
		
		double totalImposto = 0;
		Pessoa pessoaMaiorImposto = this.pessoas.get(0);
		Pessoa pessoaMaiorBeneficiado = this.pessoas.get(0);
		for(Pessoa p : this.pessoas) {
			double impostoPessoa = gerador.calculaValorTotalTributo(p);
			totalImposto += impostoPessoa;
			
			if(gerador.calculaValorTotalTributo(pessoaMaiorImposto) < impostoPessoa)
				pessoaMaiorImposto = p;
			
			if(pessoaMaiorBeneficiado.getSeguro().getValor() < p.getSeguro().getValor())
				pessoaMaiorBeneficiado = p;
				
		}
		System.out.println("************************************************************************");
		System.out.println("Total de Impostos recolhidos: " + String.format("%.2f", totalImposto));
		System.out.println("Total com maior IRRF a pagar: " + pessoaMaiorImposto.getNome());
		System.out.println("Valor: " + String.format("%.2f", gerador.calculaValorTotalTributo(pessoaMaiorImposto)));
		System.out.println("Maior Beneficiado (a): " + pessoaMaiorBeneficiado.getSeguro().getBeneficiado());
		System.out.println("Valor Benefício: " + String.format("%.2f", pessoaMaiorBeneficiado.getSeguro().getValor()));
		System.out.println("************************************************************************");
		
	}
}
