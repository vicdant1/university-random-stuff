#include "Celula.hpp"

Celula::Celula(bool visible, bool bomb, int neighbors)
{
  this->visible = false;
  this->bomb = bomb;
  this->neighbors = neighbors;
}

void Celula::setBomb(bool bomb)
{
  this->bomb = bomb;
}

void Celula::setNeighbors(int neighbors)
{
  this->neighbors = neighbors;
}

bool Celula::getBomb()
{
  return this->bomb;
}

void Celula::setVisible(bool visible)
{
  this->visible = visible;
}