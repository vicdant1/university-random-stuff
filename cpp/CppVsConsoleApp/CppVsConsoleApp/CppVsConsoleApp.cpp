#include <iostream>
#include "PThreads.h"


int main()
{
	std::cout << "Creating main thread\n";

	PThreads* threadsManager = new PThreads();

	threadsManager->ThreadToString();
	threadsManager->SetThreadCounter(20);
	threadsManager->ThreadToString();

	std::cout << "Finishing main thread\n";
}
