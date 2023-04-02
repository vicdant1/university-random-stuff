# `break_infinite`

<sup>Última atualização: 28/03/2022</sup>

Escreva um programa em Go que inicia um *loop* infinito, gera números aleatórios e encerra o *loop* quando o número gerado for divisível por 42. O programa deve ainda exibir na saída padrão quantas iterações foram realizadas até o *loop* ser encerrado.

## Exemplo de Saída

```bash
1458
3816
2413
1179
594
1562
93
2911
1131
3008
2235
3910
2928
1470
Fim após 14 iterações.
```

<ins>Dica:</ins> Utilize os pacotes [``math/rand``](https://pkg.go.dev/math/rand) e [``time``](https://pkg.go.dev/time) da biblioteca padrão de Go para gerar números verdadeiramente aleatórios com uma semente iniciar o algoritmo gerador.

## Conhecimentos Necessários

- Biblioteca padrão de Go
- Estruturas condicionais
- Estrutura de repetição (*loop*)
- Saída formatada