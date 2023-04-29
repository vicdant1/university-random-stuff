public class Veiculo {
  protected String marca;
  protected String placa;
  protected double quilometragem;
  protected double valorAluguel;
  protected boolean alugado;


  public Veiculo(String marca, String placa, double quilometragem, double valorAluguel) {
    this.marca = marca;
    this.placa = placa;
    this.quilometragem = quilometragem;
    this.valorAluguel = valorAluguel;
    this.alugado = false;
  }


  public String getMarca() {
    return marca;
  }


  public void setMarca(String marca) {
    this.marca = marca;
  }


  public String getPlaca() {
    return placa;
  }


  public void setPlaca(String placa) {
    this.placa = placa;
  }


  public double getQuilometragem() {
    return quilometragem;
  }


  public void setQuilometragem(double quilometragem) {
    this.quilometragem = quilometragem;
  }


  public double getValorAluguel() {
    return valorAluguel;
  }


  public void setValorAluguel(double valorAluguel) {
    this.valorAluguel = valorAluguel;
  }

  public boolean deveTrocarOleo(){
    return this.quilometragem % 5000 == 0;
  }

  public void alugarVeiculo(){
    this.alugado = true;
  }

}