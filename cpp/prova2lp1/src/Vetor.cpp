#include "Vetor.hpp"
#include <iostream>

using namespace std;

Vetor::Vetor(int n, int x, int y, int z)
{
  this->n = n;
  this->x = x;
  this->y = y;
  this->z = z;
}

int Vetor::GetN()
{
  return this->n;
}

int Vetor::GetX()
{
  return this->x;
}

int Vetor::GetY()
{
  return this->y;
}

int Vetor::GetZ()
{
  return this->z;
}

bool Vetor::CompararVetores(Vetor vetorA, Vetor vetorB)
{
  if(vetorA.GetN() != vetorB.GetN())
  {
    if(vetorA.GetN() < vetorB.GetN()) return true;
    else return false;
  }
  else if(vetorA.GetN() == vetorB.GetN())
  {
    if(vetorA.GetX() <= vetorB.GetX() && 
       vetorA.GetY() <= vetorB.GetY() && 
       vetorA.GetZ() <= vetorB.GetZ())
       return true;
    else
      return false;
  }

  // vetores iguais
  return true;
}