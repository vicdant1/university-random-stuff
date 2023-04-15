public class Professor extends Funcionario{
  private String tipo;

  public Professor(String matricula, String nome, String tipo) {
    super(matricula, nome);

    this.tipo = tipo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  
}
