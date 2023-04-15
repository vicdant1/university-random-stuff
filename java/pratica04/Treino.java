import java.util.Date;

public class Treino {
  private Date data;
  private String atividade;

  public Treino(Date data, String atividade) {
    this.data = data;
    this.atividade = atividade;
  }

  public Date getData() {
    return data;
  }
  public void setData(Date data) {
    this.data = data;
  }
  public String getAtividade() {
    return atividade;
  }
  public void setAtividade(String atividade) {
    this.atividade = atividade;
  }

  
}
