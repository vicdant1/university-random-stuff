import java.util.ArrayList;

public class Professor extends Funcionario{
  private ArrayList<Aluno> alunos;
  private String tipo;


  public Professor(String matricula, String nome, String tipo) {
    super(matricula, nome);
    this.tipo = tipo;
    this.alunos = new ArrayList<Aluno>();
  }

  public Professor(String matricula, String nome, String tipo, ArrayList<Aluno> alunos) {
    super(matricula, nome);
    this.tipo = tipo;
    this.alunos = new ArrayList<Aluno>(alunos);
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public ArrayList<Aluno> getAlunos() {
    return alunos;
  }

  public void setAlunos(ArrayList<Aluno> alunos) {
    this.alunos = alunos;
  }

  public void addAluno(Aluno Aluno){
    this.alunos.add(Aluno);
  }

  public void removeAluno(Aluno Aluno){
    this.alunos.remove(Aluno);
  }
  
  @Override
  public String getInformation(){
    return "Matrícula.: " + matricula + " Nome.: " + nome + " Tipo.: " + getClass() + " [" + tipo + "]";
  }
}
