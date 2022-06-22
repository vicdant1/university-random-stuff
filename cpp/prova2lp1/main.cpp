#include <iostream>
#include "Dimensao.hpp"
#include "Vetor.hpp"
#include "algorithm"

int main(int argc, char* argv[])
{
  Dimensao* dimensao = new Dimensao(3);

  auto vetoresLidos = dimensao->LerRetornarArquivo(argv[1]);

  std::sort(vetoresLidos.begin(), vetoresLidos.end(), [](Vetor vetorA, Vetor vetorB){
    Vetor::CompararVetores(vetorA, vetorB);
  });

  for(auto vetor : vetoresLidos)
    std::cout << "n: " << vetor->GetN() << " x: " << vetor->GetX() << " y: " << vetor->GetY() << " z: " << vetor->GetZ() << std::endl;

  return 0;
}