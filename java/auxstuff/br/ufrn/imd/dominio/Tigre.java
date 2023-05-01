package br.ufrn.imd.dominio;

import java.time.LocalDate;

public class Tigre extends Animal{
    public String tipoTigre;

    public Tigre(String nome, String alimentacao, LocalDate dataNascimento, int peso, boolean alimentado, String tipoTigre) {
        super(nome, alimentacao, dataNascimento, peso, alimentado);
        this.tipoTigre = tipoTigre;
    }

    public void comer() {
        double peso_alimento = this.Peso * 0.04;
        this.Peso += peso_alimento;
        setAlimentado(true);
        System.out.println("Gasto de carne: "+peso_alimento+" kg");
    }
    public void precisaConsulta() {
        if (calcularIdade() % 3 == 0) {
            System.out.println("[Tigre] " + this.nome + " passou/passará por consulta este ano");
        }
    }

    public String toString() {
        String str;
        str = "Tigre "+ tipoTigre +" | Nome: " + this.nome + " Idade: " + calcularIdade() + " Alimentacao: " + this.alimentacao + " Peso: " + this.Peso + " kg, Alimentado? " + (this.alimentado ? "Sim" : "Não");
        return str;
    }
}
