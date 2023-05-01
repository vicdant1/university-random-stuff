package br.ufrn.imd.dominio;

import java.time.Duration;
import java.time.Period;
import java.util.Date;
import java.time.LocalDate;

public class Animal {

    protected String nome;
    protected String alimentacao;
    protected LocalDate dataNascimento;
    protected int Peso;
    protected boolean alimentado;

    public Animal() {

    }
    public Animal(String nome, String alimentacao, LocalDate dataNascimento, int peso, boolean alimentado) {
        this.nome = nome;
        this.alimentacao = alimentacao;
        this.dataNascimento = dataNascimento;
        this.Peso = peso;
        this.alimentado = alimentado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int peso) {
        Peso = peso;
    }

    public boolean isAlimentado() {
        return alimentado;
    }

    public void setAlimentado(boolean alimentado) {
        this.alimentado = alimentado;
    }
    public void comer() {
        double peso_alimento = this.Peso * 0.05;
        this.Peso += peso_alimento;
        this.alimentado = true;
        System.out.println("Quantidade de alimentos gasta: "+peso_alimento+" kg");
    }

    public int calcularIdade(){
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
    public void precisaConsulta() {
        System.out.println("N/A");
    }

    public String toString() {
        String str;
        str = "Nome: " + this.nome + " Idade: " + calcularIdade() + " Alimentacao: " + this.alimentacao + " Peso: " + this.Peso + " kg, Alimentado? " + (this.alimentado ? "Sim" : "Não");
        return str;
    }
}
