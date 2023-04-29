
public class LocaLisa {
  
  public static void main(String[] args) {
    Veiculo veiculo1 = new Carro("honda", "r13er", 123.11, 123.11, 12, 1);
    Veiculo veiculo2 = new Carro("honda", "r53er", 123.11, 123.11, 12, 1);
    Veiculo veiculo3 = new Carro("honda", "rw3er", 123.11, 123.11, 12, 1);

    Veiculo veiculo4 = new Moto("honda", "214csx", 123, 11111.00, "Eletrica", 11);
    Veiculo veiculo5 = new Moto("yamaha", "2t4csx", 123, 11111.00, "Eletrica", 11);
    Veiculo veiculo6 = new Moto("honda", "254csx", 123, 11111.00, "manual", 11);

    Repositorio Db = new Repositorio();

    Db.adicionarVeiculo(veiculo1);
    Db.adicionarVeiculo(veiculo2);
    Db.adicionarVeiculo(veiculo3);
    Db.adicionarVeiculo(veiculo4);
    Db.adicionarVeiculo(veiculo5);
    Db.adicionarVeiculo(veiculo6);


    Db.listarTodosVeiculos();

    Db.listarVeiculosAlugados();

    Db.listarVeiculosDisponiveis();

  }
}
