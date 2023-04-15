import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Recepcionista extends Funcionario {
  private Set<Date> horariosTrabalho;

  public Recepcionista(String matricula, String nome) {
    super(matricula, nome);
    this.horariosTrabalho = new HashSet<Date>();
  }

  public Recepcionista(String matricula, String nome, Set<Date> horariosTrabalho) {
    super(matricula, nome);
    this.horariosTrabalho = new HashSet<Date>(horariosTrabalho);
  }

  public Set<Date> getHorariosTrabalho() {
    return horariosTrabalho;
  }

  public void setHorariosTrabalho(Set<Date> horariosTrabalho) {
    this.horariosTrabalho = horariosTrabalho;
  }

  public void addHorarioTrabalho(Date horariosTrabalho){
    this.horariosTrabalho.add(horariosTrabalho);
  }

  public void removeHorarioTrabalho(Date horarioTrabalho){
    this.horariosTrabalho.remove(horarioTrabalho);
  }

  public String getScheduleInformation(){
    return "Nome.: " + nome + " " + getFormattedSchedule();
  }
  
  public String getFormattedSchedule(){
    String ret = "{";

    SimpleDateFormat sdf = new SimpleDateFormat("EEEE=HH:mm, ");
    for(Date horarioTrabalho : this.horariosTrabalho){
      ret += sdf.format(horarioTrabalho);
    }

    ret += "}";

    ret = ret.replace(", }", "}");

    return ret;
  }

}
