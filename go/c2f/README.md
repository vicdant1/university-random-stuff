# `c2f`

<sup>Última atualização: 28/03/2022</sup>

Escreva um programa em Go que exibe, na saída padrão, uma tabela de conversão de temperaturas entre as escalas termométricas de [grau Celsius](https://pt.wikipedia.org/wiki/Grau_Celsius) e [grau Fahrenheit](https://pt.wikipedia.org/wiki/Grau_Fahrenheit). O programa deve conter a implementação de uma função chamada `celsiusToFahrenheit` que converte um valor de temperatura em graus Celsius para o valor correspondente em graus Fahrenheit.

A tabela a ser exibida como saída do programa deverá ter duas colunas, a primeira para valores de temperatura em graus Celsius e a segunda para os valores convertidos para graus Fahrenheit. As linhas da tabela deverão iniciar em -40°C e seguir até 100°C, com um *step* de 5°C, e mostrar, na segunda coluna, o resultado da função `celsiusToFahrenheit` para o valor correspondente na primeira coluna.

O traçado das bordas (as quais **necessariamente** utilizam os caracteres `=` e `|`) e espaçamentos nas células da tabela pode constituir um trecho de código passível de reuso para exibir quaisquer dados em uma tabela de duas colunas. Nessa perspectiva, o programa deverá ainda contemplar uma função `drawTable` para separar o código responsável pela exibição da tabela do código que realiza a conversão dos valores de temperatura em cada linha.

## Exemplo de Saída

```bash
=================
|    ºC |    ºF |
=================
| -40.0 | -40.0 |
| -35.0 | -31.0 |
| ...   | ...   |
| 100.0 | 212.0 |
=================
```

## Conhecimentos Necessários

- Estrutura de repetição (*loop*)
- Funções
- Saída formatada