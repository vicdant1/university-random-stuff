#ifndef Game_hpp
#define Game_hpp

#include <vector>
#include "Celula.hpp"

class Game
{
private:
  std::vector<std::vector<Celula*>> board;
  int m;
  int n;
public:
  Game(std::vector<std::vector<Celula*>> board, int m, int n);
  void fillCells();
  void spawnBombs();
  void fillNeighbors();
  void revealCell(int i, int j);
};

#endif /* Game_hpp */