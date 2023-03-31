import java.util.ArrayList;
import java.util.List;

public class Prova {
  private List<Double> notas;
  
  public Prova() {
    this.notas = new ArrayList<Double>();
  }

  public List<Double> getNotas() {
    return notas;
  }

  public void setNotas(List<Double> notas) {
    this.notas = notas;
  }

  public double calcularNotaTotal(){
    double result = 0;

    for(Double nota : notas)
      result += nota;

    if(result > 10)
      result = 10;

    return result;
  }

  public void adicionarNota(Double nota){
    this.notas.add(nota);
  }
}
