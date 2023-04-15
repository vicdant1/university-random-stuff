import java.util.Date;
import java.util.Set;
public class NatalFitness {
  public static void main(String[] args)  {

    // Calendar c = Calendar.getInstance();

    // Locale ptBr = new Locale("pt", "BR");
    // SimpleDateFormat sdf = new SimpleDateFormat("EEEE HH:mm:ss", ptBr);

    // System.out.println(sdf.format(c.getTime())); 


    // ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    // Aluno novAluno = new Aluno("joao", "null");

    // alunos.add(novAluno);

    // Professor prof = new Professor("123", "jorge", "nata", alunos);

    Funcionario professor1 = new Professor("202301", "Paul", "Natação");
    Funcionario professor2 = new Professor("202302", "John", "Musculação");

    Funcionario recepcionista1 = new Recepcionista("202303", "George");
    ((Recepcionista)recepcionista1).addHorarioTrabalho(new Date(2023, 04, 11, 15, 0, 0));
    ((Recepcionista)recepcionista1).addHorarioTrabalho(new Date(2023, 04, 10, 7, 0, 0));


    Funcionario recepcionista2 = new Recepcionista("202304", "Ringo");
    ((Recepcionista)recepcionista2).addHorarioTrabalho(new Date(2023, 04, 14, 12, 0, 0));
    ((Recepcionista)recepcionista2).addHorarioTrabalho(new Date(2023, 04, 12, 12, 0, 0));
    

    Aluno aluno1 = new Aluno("Damiano", "012.131.123-22", new Date(2001, 10, 03));
    aluno1.addTreino(new Treino(new Date(2023, 11, 04), "Musculação"));
    aluno1.addTreino(new Treino(new Date(2023, 12, 04), "Musculação"));
    aluno1.addTreino(new Treino(new Date(2023, 13, 04), "Natação"));
    
    Aluno aluno2 = new Aluno("Vic Angelis", "001.123.423-22", new Date(1995, 20, 04));
    aluno2.addTreino(new Treino(new Date(2023, 10, 04), "Natação"));
    aluno2.addTreino(new Treino(new Date(2023, 11, 04), "Natação"));
    aluno2.addTreino(new Treino(new Date(2023, 12, 04), "Musculação"));

    
    Database db = new Database();
    db.addFuncionario(recepcionista1);
    db.addFuncionario(recepcionista2);
    db.addFuncionario(professor1);
    db.addFuncionario(professor2);

    Set<Funcionario> funcionarios = db.getFuncionarios();
    System.out.println("###################################### Funcionários ######################################");
    for(Funcionario funcionario : funcionarios){
      System.out.println(funcionario.getInformation());
    }  
    System.out.println("##########################################################################################");

  }
}
