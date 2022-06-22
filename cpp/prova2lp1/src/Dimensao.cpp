#include "Dimensao.hpp"
#include "Vetor.hpp"

Dimensao::Dimensao(int dimensao)
{
  this->dimensao = dimensao;
}

void Dimensao::CriarVetor(int n, int x, int y, int z)
{
  Vetor* vetorCriado = new Vetor(n, x, y, z);

  this->vetores.push_back(vetorCriado);
}