# `loan_calculator`

<sup>Última atualização: 28/03/2022</sup>

Escreva um programa em Go que implementa uma calculadora de empréstimos. Tal calculadora possui as seguintes regras:

1. Um [*score* de crédito](https://www.serasa.com.br/score/blog/o-que-e-score-de-credito/) considerado bom possui valor igual ou superior a 501.
2. A taxa de juros cobrada para um aplicante que possua  *score* de crédito considerado bom é 15%
3. A taxa de juros cobrada para um aplicante que não possua *score* de crédito considerado bom é 20%.
4. O valor da parcela a ser pago mensalmente por um aplicante que possua *score* de crédito considerado não deve ser superior a 20% de sua renda mensal.
5. O valor da parcela a ser pago mensalmente por um aplicante que não possua *score* de crédito considerado bom não deve ser superior a 10% de sua renda mensal.
6. Se o período em meses do empréstimo requisitado não for divisível por 12, deverá ser exibida uma mensagem de erro.

O *score* mínimo de crédito e as taxas de juros deverão ser declaradas como constantes no programa. Por questões de modularidade, implemente uma função para verificar os detalhes do empréstimo considerando o *score* de crédito do aplicante, sua renda mensal, o valor requisitado para o empréstimo e o tempo do empréstimo (em meses). O programa deverá exibir na saída padrão uma mensagem de erro caso sejam fornecidos valores considerados inválidos para essas informações.

O valor da parcela a ser pago mensalmente pelo aplicante deve ser calculado como:

```math
valorParcela = \frac{valorEmprestimo * taxaJuros}{tempoEmprestimo} + \frac{valorEmprestimo}{tempoEmprestimo}
```

O custo efetivo do empréstimo é calculado multiplicando-se o valor mensal de cada parcela pelo tempo do empréstimo e subtraindo-o do valor requisitado pelo aplicante:

```math
custoEfetivo = (valorParcela * tempoEmprestimo) - valorEmprestimo
```

O empréstimo é aprovado se o aplicante (1) possui renda maior que o valor mensal da parcela, (2) possui *score* de crédito considerado bom e (3) possui percentual de sua renda a ser comprometido compatível com o limite definido pelo *score* de crédito.

Por questões de modularidade, implemente múltiplas funções correspondendo às informações a serem exibidas pelo programa.

## Exemplo de Saída

```bash
Análise de crédito para empréstimo
----------------------------------
Score de crédito:           501
Renda:                      1000
Valor do empréstimo:        1000
Tempo do empréstimo:        24
Valor mensal de parcela:    47.92
Taxa de juros:              15%
Custo efetivo:              150
Situação do empréstimo:     APROVADO

Análise de crédito para empréstimo
----------------------------------
Score de crédito:           350
Renda:                      1000
Valor do empréstimo:        10000
Tempo do empréstimo:        12
Valor mensal de parcela:    1000
Taxa de juros:              20%
Custo efetivo:              2000
Situação do empréstimo:     RECUSADO
```

## Conhecimentos Necessários

- Funções
- Estruturas de controle de fluxo
- Estruturas condicionais
- Saída formatada