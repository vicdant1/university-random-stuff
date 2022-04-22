#include <iostream>
#include <stdlib.h>

using namespace std;

int main()
{
    int n = 0;
    cin >> n;

    int horario;
    float t1;
    float t2;

    float diferenca;
    float diferencaAnterior;
    int horarioMaiorDiferenca;
    for (int i = 0; i < n; i++)
    {
        cin >> horario;
        cin >> t1;
        cin >> t2;

        diferenca = abs(t1 - t2);

        if(i == 0)
        {
            diferencaAnterior = diferenca;
            horarioMaiorDiferenca = horario;
            continue;
        }

        if(diferenca > diferencaAnterior)
        {
            horarioMaiorDiferenca = horario;
            diferencaAnterior = diferenca;
        }
    }

    cout << horarioMaiorDiferenca << endl;

    return 0;
}