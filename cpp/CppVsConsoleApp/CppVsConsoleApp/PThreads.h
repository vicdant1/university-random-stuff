#pragma once

#ifndef PThreads_hpp
#define PThreads_hpp

class PThreads
{
	private:
		int threadCounter;
	public:
		PThreads();
		int GetThreadCounter();
		void SetThreadCounter(int threadCounter);
		void ThreadToString();
};

#endif // !PThreads_hpp
