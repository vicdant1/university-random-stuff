#include "Dimensao.hpp"
#include "Vetor.hpp"
#include <fstream>

Dimensao::Dimensao(int dimensao)
{
  this->dimensao = dimensao;
}

void Dimensao::CriarVetor(int n, int x, int y, int z)
{
  Vetor* vetorCriado = new Vetor(n, x, y, z);

  this->vetores.push_back(vetorCriado);
}

void Dimensao::LerArquivo(std::string filePath)
{
  std::fstream file;
  file.open(filePath);

  if(!file.is_open()) EXIT_FAILURE;

  int rowCounter = 0;
  std::string nTmp;
  std::string xTmp;
  std::string yTmp;
  std::string zTmp;
  
  while(
    std::getline(file, nTmp, ' ') &&
    std::getline(file, xTmp, ' ') &&
    std::getline(file, yTmp, ' ') &&
    std::getline(file, zTmp, ' ')
  )
  {
    if(rowCounter == 0)  
    {
      rowCounter++;
      continue;
    }

    CriarVetor(stoi(nTmp), stoi(xTmp), stoi(yTmp), stoi(zTmp));

    rowCounter++;
  }

}

std::vector<Vetor*> Dimensao::GetVetores()
{
  return this->vetores;
}