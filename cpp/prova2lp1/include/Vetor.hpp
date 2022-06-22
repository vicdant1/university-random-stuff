#ifndef Vetor_hpp
#define Vetor_hpp

class Vetor
{
private:
  int n;
  int x;
  int y;
  int z;
public:
  Vetor(int n, int x, int y, int z);
  bool CompararVetores(Vetor vetorA, Vetor vetorB);

  int GetN();
  int GetX();
  int GetY();
  int GetZ();
};

#endif