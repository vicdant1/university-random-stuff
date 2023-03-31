import java.util.HashSet;
import java.util.Set;

public class Turma {
  private Set<Aluno> alunos;

  public Turma() {
    this.alunos = new HashSet<Aluno>();
  }

  public Set<Aluno> getAlunos() {
    return alunos;
  }

  public void setAlunos(Set<Aluno> alunos) {
    this.alunos = alunos;
  }

  public double calcularMedia(){
    double result = 0;

    for(Aluno aluno : alunos)
      result += aluno.calcularMedia();

    result = result / alunos.size();

    return result;
  }

  public void adicionarAluno(Aluno aluno){
    this.alunos.add(aluno);
  }
}
