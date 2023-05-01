package br.ufrn.imd.dominio;

import java.time.LocalDate;

public class Girafa extends Animal {
    private int tamanhoLingua;


    public Girafa(String nome, String alimentacao, LocalDate dataNascimento, int peso, boolean alimentado, int tamanhoLingua) {
        super(nome, alimentacao, dataNascimento, peso, alimentado);
        this.tamanhoLingua = tamanhoLingua;
    }

    public void comer() {
        double peso_alimento = this.Peso * 0.1;
        this.Peso += peso_alimento;
        this.alimentado = true;
        System.out.println("Gasto de Frutas/Legumes: "+peso_alimento+" kg");
    }

    public void precisaConsulta() {
        if (calcularIdade() % 5 == 0) {
            System.out.println("[Girafa] " + this.nome + " passou/passará por consulta este ano");
        }
    }

    public String toString() {
        String str;
        str = "Girafa | Nome: " + this.nome + " Idade: " + calcularIdade() + " Alimentacao: " + this.alimentacao + " Peso: " + this.Peso + " kg, Alimentado? " + (this.alimentado ? "Sim" : "Não") + " Tamanho Lingua: " + tamanhoLingua;
        return str;
    }
}
