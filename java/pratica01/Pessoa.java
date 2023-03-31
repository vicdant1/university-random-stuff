import java.lang.Math;

public class Pessoa 
{
    private double peso;
    private double altura;

    public Pessoa() { }
    
    public Pessoa(double peso, double altura)
    {
        this.peso = peso;
        this.altura = altura;
    }

    public double getPeso()
    {
        return this.peso;
    }

    public double getAltura()
    {
        return this.altura;
    }

    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    public void setAltura(double altura)
    {
        this.altura = altura;
    }

    public double calcularIMC()
    {
        double imc = this.peso / (Math.pow(this.altura, 2));

        return imc;
    }

    public String informarIMC(double imc)
    {
        if(imc < 18.5)
            return "Abaixo do peso";
        else if(imc >= 18.5 && imc <= 24.9)
            return "Peso normal";
        else if(imc >= 25.0 && imc <= 29.9)
            return "Pré-obesidade";
        else if(imc >= 30.0 && imc <= 34.9)
            return "Obesidade Grau 1";
        else if(imc >= 35 && imc <= 39.9)
            return "Obesidade Grau 2";
        else
            return "Obesidade Grau 3";
    }
}