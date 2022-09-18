#include "PThreads.h"
#include <iostream>

PThreads::PThreads()
{
	std::cout << "Inicializando classe PThreads" << std::endl;
	this->threadCounter = 0;
}

int PThreads::GetThreadCounter()
{
	return this->threadCounter;
}

void PThreads::SetThreadCounter(int threadCounter)
{
	this->threadCounter = threadCounter;
}

void PThreads::ThreadToString()
{
	std::cout << "ThreadsAtivas: " << this->threadCounter << std::endl;
}