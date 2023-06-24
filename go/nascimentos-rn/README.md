# Trabalho 1: Estatísticas de Nascidos Vivos no Rio Grande do Norte

<sub>Última atualização: 26/04/2023</sub>

## Sumário

- [Visão geral e objetivos](#visão-geral-e-objetivos)  
- [Tarefas](#tarefas)
  - [Tarefa 1](#tarefa-1)
  - [Tarefa 2](#tarefa-2)
  - [Tarefa 3](#tarefa-3)

## Visão geral e objetivos

O objetivo deste trabalho é colocar em prática as operações de leitura e escrita em arquivos na linguagem de programação Go. O programa a ser implementado utiliza como fonte de dados um arquivo [CSV (*Comma-Separated Values*)](https://en.wikipedia.org/wiki/Comma-separated_values) contendo o número de nascidos vivos em cada um dos 167 municípios do Estado do Rio Grande do Norte entre os  anos de 1994 e 2020. Os dados são provenientes do Sistema de Informações sobre Nascidos Vivos (SINASC) do Departamento de Informática do Sistema Único de Saúde (DATASUS), vinculado ao Ministério da Saúde do Brasil, e estão disponíveis neste [link](http://tabnet.datasus.gov.br/cgi/deftohtm.exe?sinasc/cnv/nvbr.def).

Este trabalho explora os seguintes elementos da programação em Go, cujos conhecimentos são, portanto, ora necessários:

- Entrada e saída formatada via console
- Entrada e saída via arquivos
- Tipos estruturados (*structs*)
- Funções
- *Arrays* e *slices*
- Mapas

## Tarefas

### Tarefa 1

A primeira tarefa deste trabalho consiste em implementar um programa chamado `nascimentos` que recebe como entrada, via linha de comando, o arquivo de texto [`Nascimentos_RN.csv`](Nascimentos_RN.csv). Esse arquivo, no formato CSV, contém os números de nascidos vivos em cada município para cada ano contabilizado. Cada linha do arquivo refere-se a um município e os números de nascimentos em cada ano são separados por vírgulas. Enquanto o arquivo de entrada foi lido, os dados de cada município foi armazenados em memória. 
Ao abrir o arquivo CSV de entrada em um editor de texto ou editor de planilhas, é possível observar que a primeira linha do arquivo diz respeito a um cabeçalho para a tabela de dados e que a primeira coluna contém o nome do município antecedido por um código numérico que o identifica, de forma aglutinada. Durante a leitura do arquivo, o programa separa o código numérico do nome do município. A última linha e a última coluna do arquivo CSV de entrada apresentam, respectivamente, o total de nascimentos em cada ano e o total de nascimentos em cada município somados os 27 anos da série 1994-2020. 

Após a leitura do arquivo, o programa computou as seguintes estatísticas que resumem o conjunto de dados em questão na série histórica:

1. o *maior* número de nascimentos em cada ano;
2. o *menor* número de nascimentos em cada ano;
3. a *média* do número de nascimentos em cada ano;
4. o *desvio padrão* do número de nascimentos em cada ano, e;
5. o número *total* de nascimentos em cada ano.

Para calcular o desvio padrão $\sigma$ do número de nascimentos em um determinado ano, foi utilizada a seguinte equação:

$$ \sigma = \sqrt{\frac{1}{M} \sum_{i=1}^{M} \(n_i - MD\)^2} $$

em que $M$ é o número de municípios, $n_i$ é o número de nascimentos do $i$-ésimo município no ano em questão e $MD$ é a média do número de nascimentos nesse ano. Um baixo desvio padrão indica que os pontos dos dados tendem a estar próximos da médiado, enquanto que um alto desvio padrão indica que os pontos dos dados estão espalhados por uma ampla gama de valores.

Como saída, o programa gerou automaticamente dois arquivos:

1. um arquivo de texto no formato CSV chamado `estatisticas.csv`, no qual cada linha corresponde a um ano e suas respectivas estatísticas acerca do número de nascimentos, cada valor sendo separado por vírgulas, e:

![estatisticas1](https://user-images.githubusercontent.com/96318894/236652201-48bd2dfa-62e9-4255-86da-43dff62ac970.png)
![estatisticas2](https://user-images.githubusercontent.com/96318894/236652242-086ef512-25d0-4719-89dd-9b4ae605acf3.png)


2. um arquivo de texto chamado `totais.dat` contendo **apenas** o ano e o respectivo número total de nascimentos nesse ano, separados por **espaço**:

![total](https://user-images.githubusercontent.com/96318894/236652290-1ba3ae49-22d0-41a5-bb81-dc1aa95ebc3a.png)

Após o arquivo `totais.dat` ser gerado como saída da execução do programa implementado, foi gerado automaticamente um [**histograma**] que mostra a evolução do número de nascimentos entre os anos de 1994 e 2020. 
sendo `totais.dat` é o arquivo anteriormente gerado e que contém os dados a serem plotados no histograma e o arquivo [`histograma.gnuplot`](histograma.gnuplot) é um *script* de configuração para instrução do quando da geração do gráfico.

Por padrão, esse *script* gerou um gráfico na forma de um arquivo de imagem no formato PNG: 

![histograma](https://user-images.githubusercontent.com/96318894/236651133-25eddaab-47b7-47a6-bac6-58a240d1dbcc.png)

## Tarefa 2

A segunda tarefa deste trabalho consiste em estender o programa implementado até a realização da Tarefa 1 para gerar automaticamente um [**gráfico de linha**], mostrando a evolução do número de nascimentos para um determinado conjunto de municípios (em número indefinido) em toda a série histórica. Tais municípios alvo foram informados de forma configurável ao programa através de um arquivo de entrada chamado `alvos.dat`.

A geração automática do gráfico de linha fazendo uso do `gnuplot` ou de outro programa ou biblioteca seguiu a mesma ideia desenvolvida na Tarefa 1 em termos de utilizar um arquivo de entrada (no caso o arquivo `nascimentos-alvos.dat`) contendo os dados a serem plotados no gráfico.

Gráfico de linha gerado pelo programa:

![linechart](https://user-images.githubusercontent.com/96318894/236651325-15aa328f-3348-4af1-9886-2b6406e6502d.png)

## Tarefa 3 

A terceira e última tarefa deste trabalho consiste em estender o programa implementado até a realização da Tarefa 2 para que ele seja capaz de fornecer, na saída padrão, quais municípios apresentaram a maior e a menor *taxa de crescimento* no número de nascimentos nos últimos cinco anos da série histórica. A taxa de crescimento relativa $TC$ de um município $M$ que foi calculada através da seguinte equação:

$$ TC(M) = \frac{N_{2020}(M)}{N_{2016}(M)} $$

em que $N_{2020}$ e $N_{2016}$ são respectivamente os números de nascidos vivos nos anos de 2020 e 2016. Para o caso em que o valor de $N_{2016}$ ou de $N_{2020}$ esteja faltante (o que implicaria em uma operação de divisão inválida), o município deverá ser desconsiderado em favor do próximo que apresentar número positivo de nascimentos tanto em 2016 quanto em 2020. Os municípios com menor e maior valores de taxa de crescimento deverão ser apresentados na saída padrão. 

A porcentagem de crescimento (ou queda) $P$ apresentada na saída do programa, considera estritamente duas casas decimais, foi calculada através da seguinte equação:

$$ P = 100 \times (TC - 1) $$

Note-se que, caso o percentual seja negativo, apresenta a taxa de crescimento como uma **taxa de queda** na saída padrão.

O programa:
  1- A `func calculateCitiesGrowTax` foi criada para o calculo da maior e menor taxa de crescimento, para isso primeiro recuperou quais os anos seriam utilizados, pegando os 5 últimos anos (2016-2020)
![calculo](https://user-images.githubusercontent.com/96318894/236679553-b6fd5f95-055b-4b8e-96e6-edae927f4257.png)
  2- Após isso foi criado um for para percorrer cada cidade e outro para percorrer os anos de cada cidade, afim de buscar o ano inicial e final
![calculo2](https://user-images.githubusercontent.com/96318894/236679643-f6da0e7d-4df0-4859-9d99-bb810160f390.png)
  3- Por fim, foi feita a validação dos anos, afim de saber se algum é igual a zero e realizou-se o cálculo da taxa, determinando a meior e menor taxa.
![calculo3](https://user-images.githubusercontent.com/96318894/236679698-c9263d61-53e3-4293-aa0a-4b32f4e5457d.png)








