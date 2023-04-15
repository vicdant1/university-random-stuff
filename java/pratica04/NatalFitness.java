import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NatalFitness {
  public static void main(String[] args)  {

    Calendar c = Calendar.getInstance();

    Locale ptBr = new Locale("pt", "BR");
    SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd/MM/yyyy", ptBr);

    System.out.println(sdf.format(c.getTime())); 
  }
}
