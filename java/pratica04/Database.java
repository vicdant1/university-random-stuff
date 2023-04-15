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
