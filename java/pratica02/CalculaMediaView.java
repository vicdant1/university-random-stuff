public class CalculaMediaView {

  public static void main(String[] args){
    Turma turma1 = new Turma();

    //#region Aluno 01
    Aluno aluno01 = new Aluno();
    Prova p1A1 = new Prova();
    Prova p2A1 = new Prova();

    p1A1.adicionarNota(5.0);
    p1A1.adicionarNota(5.0);

    p2A1.adicionarNota(0.0);
    p2A1.adicionarNota(0.0);

    aluno01.adicionarProva(p1A1);
    aluno01.adicionarProva(p2A1);
    //#endregion

    //#region Aluno 02

    Aluno aluno02 = new Aluno();
    Prova p1A2 = new Prova();
    Prova p2A2 = new Prova();

    p1A2.adicionarNota(6.0);
    p1A2.adicionarNota(2.1);

    p2A2.adicionarNota(4.0);
    p2A2.adicionarNota(3.0);

    aluno02.adicionarProva(p1A2);
    aluno02.adicionarProva(p2A2);

    //#endregion

    //#region Aluno 03

    Aluno aluno03 = new Aluno();
    Prova p1A3 = new Prova();
    Prova p2A3 = new Prova();

    p1A3.adicionarNota(2.0);
    p1A3.adicionarNota(4.0);

    p2A3.adicionarNota(6.0);
    p2A3.adicionarNota(1.0);

    aluno03.adicionarProva(p1A3);
    aluno03.adicionarProva(p2A3);

    //#endregion

    turma1.adicionarAluno(aluno01);
    turma1.adicionarAluno(aluno02);
    turma1.adicionarAluno(aluno03);

    mostrarInformacaoTurma(turma1);
  }

  private static void mostrarInformacaoTurma(Turma turma){
    System.out.println("===================== INFORMAÇÕES DA TURMA =====================");
    System.out.println("MÉDIA GERAL DA TURMA: " + turma.calcularMedia());

    int counter = 1;
    for(Aluno aluno : turma.getAlunos()){
      System.out.println("MÉDIA DO ALUNO " + counter + ": " + aluno.calcularMedia());
      counter++;
    }

    System.out.println("================================================================");
  }
}