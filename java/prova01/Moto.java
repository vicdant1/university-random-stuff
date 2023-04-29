public class Moto extends Veiculo{
  private String tipoPartida;
  private int cilindradas;

  public Moto(String marca, String placa, double quilometragem, double valorAluguel, String tipoPartida, int cilindradas) {
    super(marca, placa, quilometragem, valorAluguel);
    this.tipoPartida = tipoPartida;
    this.cilindradas = cilindradas;
  }

  public String getTipoPartida() {
    return tipoPartida;
  }

  public void setTipoPartida(String tipoPartida) {
    this.tipoPartida = tipoPartida;
  }

  public int getCilindradas() {
    return cilindradas;
  }

  public void setCilindradas(int cilindradas) {
    this.cilindradas = cilindradas;
  }

  
}
