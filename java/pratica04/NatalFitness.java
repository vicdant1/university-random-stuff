import java.util.Date;
import java.util.Set;
public class NatalFitness {
  public static void main(String[] args)  {
    Funcionario professor1 = new Professor("202301", "Paul", "Natacao");
    Funcionario professor2 = new Professor("202302", "John", "Musculacao");

    Funcionario recepcionista1 = new Recepcionista("202303", "George");
    ((Recepcionista)recepcionista1).addHorarioTrabalho(new Date(2023, 04, 11, 15, 0, 0));
    ((Recepcionista)recepcionista1).addHorarioTrabalho(new Date(2023, 04, 10, 7, 0, 0));


    Funcionario recepcionista2 = new Recepcionista("202304", "Ringo");
    ((Recepcionista)recepcionista2).addHorarioTrabalho(new Date(2023, 04, 14, 12, 0, 0));
    ((Recepcionista)recepcionista2).addHorarioTrabalho(new Date(2023, 04, 12, 12, 0, 0));
    

    Aluno aluno1 = new Aluno("Damiano", "012.131.123-22", new Date(2001, 10, 03));
    aluno1.addTreino(new Treino(new Date(2023, 11, 04, 10, 00, 00), "Musculacao"));
    aluno1.addTreino(new Treino(new Date(2023, 12, 04, 12, 10, 00), "Musculacao"));
    aluno1.addTreino(new Treino(new Date(2023, 13, 04, 15, 00, 00), "Natacao"));
    
    Aluno aluno2 = new Aluno("Vic Angelis", "001.123.423-22", new Date(1995, 20, 04));
    aluno2.addTreino(new Treino(new Date(2023, 10, 04, 11, 15, 00), "Natacao"));
    aluno2.addTreino(new Treino(new Date(2023, 11, 04, 14, 15, 00), "Natacao"));
    aluno2.addTreino(new Treino(new Date(2023, 12, 04, 16, 15, 00), "Musculacao"));

    ((Professor)professor1).addAluno(aluno1);
    ((Professor)professor1).addAluno(aluno2);

    ((Professor)professor2).addAluno(aluno1);
    ((Professor)professor2).addAluno(aluno2);

    Database db = new Database();
    db.addFuncionario(recepcionista1);
    db.addFuncionario(recepcionista2);
    db.addFuncionario(professor1);
    db.addFuncionario(professor2);

    Set<Funcionario> funcionarios = db.getFuncionarios();
    System.out.println("###################################### Funcionarios ######################################");
    for(Funcionario funcionario : funcionarios){
      System.out.println(funcionario.getInformation() + "\n");
    }  
    System.out.println("##########################################################################################");


    Set<Funcionario> professores = db.getProfessores();
    System.out.println("###################################### Professores ######################################");
    for(Funcionario professor : professores){
      System.out.println(((Professor)professor).getLessonInformation());
    }  
    System.out.println("##########################################################################################");

    Set<Funcionario> recepcionistas = db.getRecepcionistas();
    System.out.println("##################################### Recepcionistas #####################################");
    for(Funcionario recepcionista : recepcionistas){
      System.out.println(((Recepcionista)recepcionista).getScheduleInformation());
    }  
    System.out.println("##########################################################################################");

    Set<Aluno> alunos = db.getAlunos();
    System.out.println("########################################## Alunos ########################################");
    for(Aluno aluno : alunos){
      System.out.println(aluno.getInformation());
    }  
    System.out.println("##########################################################################################");
  }
}
