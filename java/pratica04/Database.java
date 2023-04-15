import java.util.HashSet;
import java.util.Set;

public class Database {
  private Set<Funcionario> funcionarios;
  
  public Database() {
    this.funcionarios = new HashSet<Funcionario>();
  }
  
  public Database(Set<Funcionario> funcionarios) {
    this.funcionarios = new HashSet<Funcionario>(funcionarios);
  }

  public Set<Funcionario> getFuncionarios() {
    return funcionarios;
  }

  public Set<Funcionario> getProfessores() {
    Set<Funcionario> professores = new HashSet<Funcionario>();

    for(Funcionario funcionario : this.funcionarios){
      if(funcionario instanceof Professor)
        professores.add(funcionario);
    }

    return professores;
  }

  public Set<Funcionario> getRecepcionistas() {
    Set<Funcionario> recepcionistas = new HashSet<Funcionario>();

    for(Funcionario funcionario : this.funcionarios){
      if(funcionario instanceof Recepcionista)
        recepcionistas.add(funcionario);
    }

    return recepcionistas;
  }

  public Set<Aluno> getAlunos() {
    Set<Aluno> alunos = new HashSet<Aluno>();
    for(Funcionario funcionario : this.funcionarios){
      if(funcionario instanceof Professor)
        alunos.addAll(((Professor)funcionario).getAlunos());
    }

    return alunos;
  }

  public void setFuncionarios(Set<Funcionario> funcionarios) {
    this.funcionarios = funcionarios;
  }

  public void addFuncionario(Funcionario funcionario){
    try{

       this.funcionarios.add(funcionario);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void removeFuncionario(Funcionario funcionario){
    this.funcionarios.remove(funcionario);
  }


  
}
