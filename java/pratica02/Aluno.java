import java.util.HashSet;
import java.util.Set;

public class Aluno {
  private Set<Prova> provas;

  public Aluno() {
    this.provas = new HashSet<Prova>();
  }

  public Set<Prova> getProvas() {
    return provas;
  }

  public void setProvas(Set<Prova> provas) {
    this.provas = provas;
  }
  
  public double calcularMedia(){
    double result = 0;

    for(Prova prova : provas)
      result += prova.calcularNotaTotal();

    result = result / provas.size();

    return result;
  }

  public void adicionarProva(Prova prova){
    this.provas.add(prova);
  }
}
