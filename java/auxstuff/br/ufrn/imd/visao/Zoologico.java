package br.ufrn.imd.visao;

import br.ufrn.imd.dominio.Animal;
import br.ufrn.imd.dominio.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class Zoologico {
    public static void main(String[] args) {
        ArrayList<Animal> jaulas = new ArrayList<Animal>();
        Animal a1 = new Elefante("Godofredo","Herbivoro",LocalDate.of(2002,4,2),320,false,50);
        Animal a2 = new Elefante("Gigafante","Herbivoro",LocalDate.of(2002,6,2),320,false,120);
        Animal a3 = new Tigre("Diego","Carnívoro",LocalDate.of(1920,9,2),270,false,"Dentes de sabre");
        Animal a4 = new Tigre("Fernando","Carnívoro",LocalDate.of(1996,9,10),300,false,"Siberiano");
        Animal a5 = new Girafa("Melman","Herbivoro",LocalDate.of(2004,3,2),320,false,15);
        Animal a6 = new Girafa("Godofredo","Herbivoro",LocalDate.of(2007,4,2),150,false,30);

        jaulas.add(a1);
        jaulas.add(a2);
        jaulas.add(a3);
        jaulas.add(a4);
        jaulas.add(a5);
        jaulas.add(a6);

        // Alimentação
        System.out.println("||   Alimentação    ||");
        for (Animal a : jaulas) {
            System.out.println("Alimentando o: " + a.getNome());
            a.comer();
        }

        System.out.print("\n\n");

        //Consultas
        System.out.println("||   Consultas    ||");
        for (Animal a : jaulas) {
            a.precisaConsulta();
        }

        System.out.print("\n\n");

        // Metódo de listagem
        System.out.println("||   Listagem    ||");
        for (Animal a : jaulas) {
            System.out.println(a.toString());
        }

        // Listagem de menor e maior idade por espécie
        Animal girafa_nova = new Animal();
        Animal girafa_velha = new Animal();
        Animal tigre_novo = new Animal();
        Animal tigre_velho = new Animal();
        Animal elefante_novo = new Animal();
        Animal elefante_velho = new Animal();
        Animal animal_velho = new Animal();
        Animal animal_novo = new Animal();
        for (Animal a : jaulas) {
            if (a instanceof Girafa) {
                if (a.calcularIdade() > girafa_velha.calcularIdade()) {
                    girafa_velha = a;
                } else if (a.calcularIdade() < girafa_nova.calcularIdade() || girafa_nova.getDataNascimento() == null) {
                    girafa_nova = a;
                }
            } else if (a instanceof Elefante) {
                if (a.calcularIdade() > elefante_velho.calcularIdade()) {
                    elefante_velho = a;
                } else if (a.calcularIdade() < elefante_novo.calcularIdade() || elefante_novo.getDataNascimento() == null) {
                    elefante_novo = a;
                }
            } else if (a instanceof Tigre) {
                if (a.calcularIdade() > tigre_velho.calcularIdade()) {
                    tigre_velho = a;
                } else if (a.calcularIdade() < tigre_novo.calcularIdade() || tigre_novo.getDataNascimento() == null) {
                    tigre_novo = a;
                }
            } else {
                if (a.calcularIdade() > animal_velho.calcularIdade()){
                    animal_velho = a;
                } else if (a.calcularIdade() < animal_novo.calcularIdade() || animal_novo.getDataNascimento() == null){
                    animal_novo = a;
                }
            }
        }
        System.out.println("Animal [Sem espécie] mais velho: " + animal_velho.getNome());
        System.out.println("Animal [Sem espécie] mais novo: " + animal_novo.getNome());
        System.out.println("Animal [Elefante] mais velho: " + elefante_velho.getNome());
        System.out.println("Animal [Elefante] mais novo: " + elefante_novo.getNome());
        System.out.println("Animal [Girafa] mais velho: " + girafa_velha.getNome());
        System.out.println("Animal [Girafa] mais novo: " + girafa_nova.getNome());
        System.out.println("Animal [Tigre] mais velho: " + tigre_velho.getNome());
        System.out.println("Animal [Tigre] mais novo: " + tigre_novo.getNome());
    }
}