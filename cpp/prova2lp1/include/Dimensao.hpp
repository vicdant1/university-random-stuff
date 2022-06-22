#ifndef Dimensao_hpp
#define Dimensao_hpp

#include "Vetor.hpp"
#include "vector"
#include "string"

class Dimensao
{
private:
  int dimensao;
  std::vector<Vetor*> vetores;

public:
  Dimensao(int dimensao);
  void CriarVetor(int n, int x, int y, int z);
  void LerArquivo(std::string filePath);
  std::vector<Vetor*> GetVetores();
};

#endif