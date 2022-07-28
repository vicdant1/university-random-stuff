#include "Game.hpp"
#include <random>

Game::Game(std::vector<std::vector<Celula*>> board, int m, int n)
{
  this->board = board;
  this->m = m;
  this->n = n;

  fillCells();
  spawnBombs();
  fillNeighbors();
}

void Game::fillCells()
{
  for(int i = 0; i < m; i++)
  {
    std::vector<Celula*> row;
    for(int j = 0; j < n; j++)
      row.push_back(new Celula(false, false, 0));
    
    board.push_back(row);
  }
}

void Game::spawnBombs()
{

  std::mt19937 generator;
  generator.seed(1);
  std::uniform_int_distribution<int> uniform_m(0,m);
  std::uniform_int_distribution<int> uniform_n(0,n);

  int bombAmount = m * n * 0.15;

  std::vector<std::pair<int, int>> bombCoordinates;

  for(int i = 0; i < bombAmount; i++)
  {
    int x = uniform_m(generator);
    int y = uniform_n(generator);
    bombCoordinates.push_back(std::make_pair(x, y));
  }

  for(auto bombCoordinate : bombCoordinates)
    board[bombCoordinate.first][bombCoordinate.second]->setBomb(true);
}

void Game::fillNeighbors()
{
  for(int i = 0; i < m; i++)
  {
    for(int j = 0; j < n; j++)
    {
      int neighbors = 0;
      if(i > 0 && j > 0 && board[i-1][j-1]->getBomb())
        neighbors++;
      if(i > 0 && board[i-1][j]->getBomb())
        neighbors++;
      if(i > 0 && j < n-1 && board[i-1][j+1]->getBomb())
        neighbors++;
      if(j > 0 && board[i][j-1]->getBomb())
        neighbors++;
      if(j < n-1 && board[i][j+1]->getBomb())
        neighbors++;
      if(i < m-1 && j > 0 && board[i+1][j-1]->getBomb())
        neighbors++;
      if(i < m-1 && board[i+1][j]->getBomb())
        neighbors++;
      if(i < m-1 && j < n-1 && board[i+1][j+1]->getBomb())
        neighbors++;
      board[i][j]->setNeighbors(neighbors);
    }
  }
}

void Game::revealCell(int i, int j)
{
  auto cell = board[i][j]; 

  if(cell->getBomb())
  {
    cell->setVisible(true);
    return;
  }
}