public class Carro extends Veiculo{
  private int potenciaMotor;
  private int quantidadePortas;

  public Carro(String marca, String placa, double quilometragem, double valorAluguel, int potenciaMotor, int quantidadePortas) {
    super(marca, placa, quilometragem, valorAluguel);
    this.potenciaMotor = potenciaMotor;
    this.quantidadePortas = quantidadePortas;
  }

  public int getPotenciaMotor() {
    return potenciaMotor;
  }

  public void setPotenciaMotor(int potenciaMotor) {
    this.potenciaMotor = potenciaMotor;
  }

  public int getQuantidadePortas() {
    return quantidadePortas;
  }

  public void setQuantidadePortas(int quantidadePortas) {
    this.quantidadePortas = quantidadePortas;
  }

  @Override
  public boolean deveTrocarOleo(){
    return this.quilometragem % 10000 == 0;
  }
}
