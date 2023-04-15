import java.util.Set;
import java.util.Date;
import java.util.HashSet;

public class Aluno {
  private String nome;
  private String cpf;
  private Date dataNascimento;
  private Set<Treino> treinos;

  public Aluno(String nome, String cpf, Date dataNascimento) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
    this.treinos = new HashSet<Treino>();
  }

  public Aluno(String nome, String cpf, Date dataNascimento, Set<Treino> treinos) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
    this.treinos = new HashSet<Treino>(treinos);
  }

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Set<Treino> getTreinos() {
    return treinos;
  }

  public void setTreinos(Set<Treino> treinos) {
    this.treinos = treinos;
  }

  public void addTreino(Treino treino){
    this.treinos.add(treino);
  }

  public void removeTreino(Treino treino){
    this.treinos.remove(treino);
  }
}
