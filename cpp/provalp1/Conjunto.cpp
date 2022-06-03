#include "Conjunto.hpp"




Conjunto::Conjunto(){ }

bool Conjunto::verificaElemento(double elemento)
{
  for(auto elementoConjunto : elementos)
  {
    if(elemento == elementoConjunto)
      return true;

    return false;
  }
}


void Conjunto::adicionaElemento(double elemento)
{
  if(!verificaElemento(elemento))
    elementos.push_back(elemento);
}


std::vector<double> Conjunto::uniaoConjunto(Conjunto* conjunto)
{
  std::vector<double> uniao;

  for(auto elementoConjunto : elementos)
  {
    uniao.push_back(elementoConjunto);
  }

  for(auto elementoConjunto : conjunto->elementos)
  {
    if(!verificaElemento(elementoConjunto))
      uniao.push_back(elementoConjunto);
  }

  return uniao;
}

void Conjunto::intersecaoConjunto(Conjunto* conjunto)
{
  std::vector<double> intersecao;

  for(auto elementoConjunto : elementos)
  {
    for(auto elementoConjunto2 : conjunto->elementos)
    {
      if(elementoConjunto == elementoConjunto2)
        intersecao.push_back(elementoConjunto);
    }
  }

  return intersecao;
}

void Conjunto::imprimeConjunto()
{
  std::cout << "["
  for(auto elementoConjunto : elementos)
  {
    std::cout << elementoConjunto << std::endl;
  }
  std::cout << "]" << std::endl;
}