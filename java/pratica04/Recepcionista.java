import java.util.Date;

public class Recepcionista extends Funcionario {
  private Date horarioTrabalho;

  public Recepcionista(String matricula, String nome, Date horarioTrabalho) {
    super(matricula, nome);

    this.horarioTrabalho = horarioTrabalho;
  }

  public Date getHorarioTrabalho() {
    return horarioTrabalho;
  }

  public void setHorarioTrabalho(Date horarioTrabalho) {
    this.horarioTrabalho = horarioTrabalho;
  }

  

}
