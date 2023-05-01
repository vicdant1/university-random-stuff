package br.ufrn.imd.dominio;

import java.time.LocalDate;

public class Elefante extends Animal{
    private int tamanhoTromba;

    public Elefante(String nome, String alimentacao, LocalDate dataNascimento, int peso, boolean alimentado, int tamanhoTromba) {
        super(nome, alimentacao, dataNascimento, peso, alimentado);
        this.tamanhoTromba = tamanhoTromba;
    }

    public void comer() {
        double peso_alimento = this.Peso * 0.15;
        this.Peso += peso_alimento;
        this.alimentado = true;
        System.out.println("Gasto de frutas/legumes: "+peso_alimento+" kg");
    }
    public void precisaConsulta() {
        if (calcularIdade() % 7 == 0) {
            System.out.println("[Elefante] " + this.nome + " passou/passará por consulta este ano");
        }
    }

    public String toString() {
        String str;
        str = "Elefante | Nome: " + this.nome + " Idade: " + calcularIdade() + " Alimentacao: " + this.alimentacao + " Peso: " + this.Peso + " kg, Alimentado? " + (this.alimentado ? "Sim" : "Não") + " Tamanho tromba: " + tamanhoTromba;
        return str;
    }
}
