#include <iostream>
using namespace std;

class Pessoa
{
private:
    string nome;
    int idade;
    char genero;

public:
    void printNome();
    void printInfo();

    // Pessoa();
    // Pessoa(string _nome);
    Pessoa(string _nome, int _idade);
    Pessoa(string _nome, int _idade, char _genero);

    ~Pessoa();
};

// Implementação métodos de Pessoa:

void Pessoa::printNome()
{
    cout << nome << endl;
}

void Pessoa::printInfo()
{
    cout << "Nome: " << nome << " Idade: " << idade << " Gênero: " << genero << endl;
}

Pessoa::Pessoa(string _nome, int _idade, char _genero)
{
    nome = _nome;
    idade = _idade;
    genero = _genero;
}

Pessoa::Pessoa(string _nome, int _idade)
{
    nome = _nome;
    idade = _idade;
}

Pessoa::~Pessoa()
{
    cout << "Destrutor do objeto referente ao nome: '" << nome << "' foi chamado" << endl;
}

int main()
{
    Pessoa p1 = Pessoa("JV", 21, 'M');
    auto p2 = Pessoa("John", 19);
    p1.printNome();
    p2.printNome();

    p1.printInfo();

    p1.~Pessoa();
    p2.~Pessoa();
    return 0;
}