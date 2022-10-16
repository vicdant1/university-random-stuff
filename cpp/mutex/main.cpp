#include <iostream>
#include <pthread.h>
#include <vector>

// global variables
pthread_mutex_t mutex;
std::vector<std::vector<int>> matrix;


// mutex - accessed through pthreads lib
// using mutex is purely using a variable
// it provides two main functions to us -> lock/unlock (wich make sense since we are working with mutual exclusion)

void printMatrix()
{
    for(auto row : matrix)
    {
        for(auto element : row)
            std::cout << element << " ";

        std::cout << "\n";
    }
}

void* accessMatrix(void* tid)
{
    int index = (int)(size_t) tid;

    pthread_mutex_lock(&mutex);
    for(int j = 0; j < 5; j++)
        matrix[index].push_back(rand()%100);
    pthread_mutex_unlock(&mutex);
}

int main(int argc, char* argv[])
{
    // It is possible to use conditions in pthread (pthread_cond)
    // Try to create examples with producer/consumer concepts - lesson
    
    int threadsNumber = atoi(argv[1]);
    pthread_t threads[threadsNumber];

    srand(time(NULL));

    for(int i = 0; i < threadsNumber; i++)
        matrix.push_back(std::vector<int>());

    pthread_mutex_init(&mutex, NULL);

    for(int i = 0; i < threadsNumber; i++)
        pthread_create(&threads[i], NULL, accessMatrix, (void*)(size_t)i);

    for(int i = 0; i < threadsNumber; i++)
        pthread_join(threads[i], NULL);

    printMatrix();
    // after using mutex variable, destroy it
    pthread_mutex_destroy(&mutex);

    return 0;
}