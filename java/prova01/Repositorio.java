import java.util.ArrayList;
import java.util.function.DoubleBinaryOperator;

public class Repositorio {
  private ArrayList<Veiculo> veiculos;

  public Repositorio() {
    this.veiculos = new ArrayList<Veiculo>();
  }

  public void adicionarVeiculo(Veiculo veiculo){
    this.veiculos.add(veiculo);
  }

  public void listarTodosVeiculos(){

    System.out.println("Veiculos cadastrados:");

    for(Veiculo v : this.veiculos){
      System.out.println(" Marca: " + v.getMarca() + " Placa: " + v.getPlaca() + " Quilometragem: " +  v.getQuilometragem() + " Valor Aluguel: " +  v.getValorAluguel());
    }

    System.out.println("Marca com maior numero: ");


  }

  public void listarVeiculosAlugados(){
    double totalAmount = 0;
    
    for(Veiculo v : this.veiculos) {
      if(v.alugado){
        System.out.println(" Marca: " + v.getMarca() + " Placa: " + v.getPlaca() + " Quilometragem: " +  v.getQuilometragem() + " Valor Aluguel: " +  v.getValorAluguel());

        totalAmount += v.getValorAluguel();
      }
    }

    System.out.println("Valor que a localisa vai receber: "+ totalAmount);
  }

  public void listarVeiculosDisponiveis(){
    double valorMaisBaixo = 1000000000;
    double valorMaisAlto = 0;
    for(Veiculo v : this.veiculos)
    {
      if(!v.alugado)
      {
        System.out.println("Marca: " + v.getMarca() + " Placa: " + v.getPlaca() + " Quilometragem: " +  v.getQuilometragem() + " Valor Aluguel: " +  v.getValorAluguel()); 

        if(v.getValorAluguel() > valorMaisAlto)
          valorMaisAlto = v.getValorAluguel();

        if(v.getValorAluguel() < valorMaisBaixo)
          valorMaisBaixo = v.getValorAluguel();
      }
    }

    System.out.println("Valor mais alto: " + valorMaisAlto);
    System.out.println("Valor mais Baixo: " + valorMaisBaixo);
  }
}
