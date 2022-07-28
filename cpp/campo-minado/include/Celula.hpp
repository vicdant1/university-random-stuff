#ifndef Celula_hpp
#define Celula_hpp

class Celula
{
private:
  bool visible;
  bool bomb;
  int neighbors;

public:
  Celula(bool visible, bool bomb, int neighbors);

  bool getBomb();

  void setBomb(bool bomb);
  void setNeighbors(int neighbors);
  void setVisible(bool visible);
};

#endif /* Celula_hpp */