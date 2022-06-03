#include <iostream>
#include "Conjunto.hpp"

using namespace std;
int main() 
{

  Conjunto conjuntoA;
  Conjunto conjuntoB;

  cout << "========== Iniciando rotina de testes ==========" << endl;

  cout << "Inserindo elementos nos conjuntos" << endl;
  conjuntoA.adicionaElemento(1);
  conjuntoA.adicionaElemento(4);
  conjuntoA.adicionaElemento(5);
  conjuntoA.adicionaElemento(7);
  conjuntoA.adicionaElemento(1);

  cout << "Conjunto A: ";
  conjuntoA.imprimeConjunto();

  conjuntoB.adicionaElemento(2);
  conjuntoB.adicionaElemento(1);
  conjuntoB.adicionaElemento(4);
  conjuntoB.adicionaElemento(45);
  conjuntoB.adicionaElemento(7);
  conjuntoB.adicionaElemento(9);
  conjuntoB.adicionaElemento(81);

  cout << "Conjunto B: ";
  conjuntoB.imprimeConjunto();

  cout << "Verificando se elementos pertencem aos conjuntos" << endl;

  
  // Conjunto A

  if(conjuntoA.verificaElemento(1))
    cout << "Elemento 1 pertence ao conjunto A" << endl;
  else
    cout << "Elemento 1 nao pertence ao conjunto A" << endl;

  if(conjuntoA.verificaElemento(4))
    cout << "Elemento 4 pertence ao conjunto A" << endl;
  else
    cout << "Elemento 4 nao pertence ao conjunto A" << endl;


  if(conjuntoA.verificaElemento(98))
    cout << "Elemento 98 pertence ao conjunto A" << endl;
  else
    cout << "Elemento 98 nao pertence ao conjunto A" << endl;

  // Conjunto B

  if(conjuntoB.verificaElemento(1))
    cout << "Elemento 1 pertence ao conjunto A" << endl;
  else
    cout << "Elemento 1 nao pertence ao conjunto A" << endl;

  if(conjuntoB.verificaElemento(4))
    cout << "Elemento 4 pertence ao conjunto A" << endl;
  else
    cout << "Elemento 4 nao pertence ao conjunto A" << endl;


  if(conjuntoB.verificaElemento(98))
    cout << "Elemento 98 pertence ao conjunto A" << endl;
  else
    cout << "Elemento 98 nao pertence ao conjunto A" << endl;


  cout << "Realizando união entre conjuntos" << endl; 
  

  auto uniaoAB = conjuntoA.uniaoConjunto(&conjuntoB);
  
  for(auto elemento : uniaoAB)
  {
    cout << elemento;
  }
  cout << endl;


  cout << "Realizando intesrseção entre conjuntos" << endl;

  auto intersecaoAB = conjuntoA.intersecaoConjunto(&conjuntoB);

  for(auto elemento : intersecaoAB)
  {
    cout << elemento;
  }

  cout << endl;


  cout << "========== Fim da rotina de testes ==========" << endl;



  return 0;
}