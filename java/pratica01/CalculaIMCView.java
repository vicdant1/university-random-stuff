import java.util.Scanner;

public class CalculaIMCView
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o peso: ");
        double peso = scanner.nextDouble();

        System.out.print("Digite a altura: ");
        double altura = scanner.nextDouble();

        Pessoa pessoa = new Pessoa();
        pessoa.setPeso(peso);
        pessoa.setAltura(altura);
        double imc = pessoa.calcularIMC();

        System.out.print("Peso    => ");
        System.out.println(pessoa.getPeso());

        System.out.print("Altura  => ");
        System.out.println(pessoa.getAltura());

        System.out.print("IMC = ");
        System.out.println(String.format("%.2f", imc));

        System.out.print("Pessoa com ");
        System.out.println(pessoa.informarIMC(imc));

        scanner.close();
    }
}