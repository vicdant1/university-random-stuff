#ifndef Conjunto_hpp
#define Conjunto_hpp

#include <vector>

class Conjunto 
{
  private:
    std::vector<double> elementos;

  
  public:
    Conjunto();

    bool verificaElemento(double elemento);
    void adicionaElemento(double elemento);
    std::vector<double> uniaoConjunto(Conjunto* conjunto);
    std::vector<double> intersecaoConjunto(Conjunto* conjunto);
    void imprimeConjunto();

};

#endif