public class Funcionario {
  protected String matricula;
  protected String nome;

  public Funcionario(String matricula, String nome) {
    this.matricula = matricula;
    this.nome = nome;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getInformation(){
    return "Matricula.: " + matricula + " Nome.: " + nome + " Tipo.: " + getClass();
  }
  
}