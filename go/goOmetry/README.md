[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/StTlkHn5)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=11357728&assignment_repo_type=AssignmentRepo)
# Trabalho 2: Geometria Plana e Espacial

<sub>Última atualização: 18/06/2023</sub>

## Sumário

- [Objetivos](#objetivo)
- [Introdução](#introdução)
- [Tarefas](#tarefas)
  - [Tarefa 1: Implementação de pacotes](#tarefa-1-implementação-de-pacotes)
  - [Tarefa 2: Implementação de testes unitários](#tarefa-2-implementação-de-testes-unitários)
  - [Tarefa 3: Implementação do programa principal](#tarefa-3-implementação-do-programa-principal)
- [Requisitos](#requisitos)
- [Autoria e política de colaboração](#autoria-e-política-de-colaboração)
- [Entrega](#entrega)
- [Avaliação](#avaliação)
- [Dúvidas e informações](#dúvidas-e-informações)

## Objetivo

O objetivo deste trabalho é colocar em prática boas práticas de programação na linguagem Go, mais especificamente por meio de modularização e testes. São explorados os seguintes elementos da programação em Go, cujos conhecimentos são, portanto, ora necessários:

- Entrada e saída formatada via console
- Tipos estruturados (*structs*)
- Funções
- Pacotes e módulos
- Manipulação de erros
- *Framework* de testes

## Introdução

A *Geometria* (do grego &gamma;&epsilon;&omega;&mu;&epsilon;&tau;&rho;&iota;&alpha;; *geo*- = "terra", -*metron* = "medida") é um ramo da Matemática que estuda questões relacionadas à forma, tamanho e posição relativa de figuras e a propriedades do espaço. Essa ciência surgiu em diversas culturas da Antiguidade como um conjunto de conhecimentos práticos sobre comprimento, área e volume, partindo das necessidades e observações do ser humano para resolver problemas em agricultura, astronomia, arquitetura e engenharia. Com efeito, conhecimentos em Geometria são aplicados ainda hoje nos mais variados campos do conhecimento humano, tais como física, química, geologia, astronomia, engenharia, biologia, cartografia e computação.

Dentre as divisões da Geometria, encontram-se as chamadas *Geometria Plana* e *Geometria Espacial*. A Geometria Plana refere-se ao estudo das figuras geométricas definidas em um plano de duas dimensões, enquanto que a Geometria Espacial se encarrega do estudo das figuras geométricas (também chamadas de sólidos geométricos) definidas no espaço, ou seja, aquelas que possuem mais de duas dimensões e ocupam um lugar no espaço. As principais figuras geométricas planas são o triângulo, o quadrado, o retângulo e o círculo. Já as principais figuras geométricas espaciais são o cubo, a esfera, o cone, a pirâmide, o paralelepípedo e o cilindro.

Três conceitos são de suma importância para o entendimento das Geometrias Plana e Espacial, a saber, a área, o perímetro e o volume. A área de uma figura geométrica, seja ela plana ou espacial, expressa o tamanho de tal figura sobre uma superfície, de modo que quanto maior a superfície da figura, maior a sua área. O perímetro de uma figura geométrica é definido como a medida do contorno que delimita a figura, sendo resultante da soma das medidas de todos os seus lados. Por fim, o volume corresponde à medida do espaço ocupado por uma figura geométrica. Para encontrar os valores dessas medidas, é importante analisar o tipo da figura (se plana ou espacial) e a forma da figura, isto é, quantos e quais são os lados.

**Área, perímetro e volume de figuras geométricas planas e espaciais**

As tabelas abaixo apresentam a definição das principais figuras geométricas planas e espaciais, bem como as fórmulas utilizadas para calcular as medidas de área, perímetro e volume. É importante notar que, pelo fato de as figuras geométricas planas serem definidas em um plano de duas dimensões, elas não possuem volume.

| Figura | Definição | Área | Perímetro |
| ------ | --------- | ---- | --------- |
| Triângulo | Figura fechada formada por três lados | $`A = \frac{base\ \times\ altura}{2}`$ | $`P = lado1 + lado2 + lado3`$ |
| Retângulo | Figura fechada formada por quatro lados que formam ângulos retos (90º) | $`A = base\ \times\ altura`$ | $`P = 2\ \times\ (base + altura)`$ |
| Quadrado | Figura fechada formada por quatro lados congruentes (isto é, de medidas iguais) que formam ângulos retos | $`A = lado^2`$ | $`P = 4\ \times\ lado`$ |
| Círculo | Figura fechada por uma linha curva chamada circunferência | $`A = \pi\ \times\ r^2`$ | $`P = 2\ \times\ \pi\ \times\ r`$ |

<br/>

| Figura | Definição | Área | Volume    |
| ------ | --------- | ---- | --------- |
| Pirâmide | Figura composta por uma base poligonal (triangular, quadrangular, etc.) e um vértice que une as faces laterais da pirâmide | $`A = area\_base + area\_lateral`$ | $`V = \frac{1}{3}\ \times\  area\_base\ \times\ altura`$ |
| Cubo | Figura composta por seis faces quadrangulares | $`A = 6\ \times\ aresta^2`$ | $`V = aresta^3`$ |
| Paralelepípedo | Figura composta por seis faces, tendo três pares de faces idênticas e paralelas entre si | $`A = (2\ \times\ aresta1\ \times\ aresta2)\ +`$<br/>$`(2\ \times\ aresta1\ \times\ aresta3)\ +`$<br/>$`(2\ \times\ aresta2\ \times\ aresta3)`$ | $`V = aresta1\ \times\ aresta2\ \times\ aresta3`$ |
| Esfera | Figura resultante do conjunto de pontos do espaço cuja distância ao centro é igual ou menor que o raio | $`A = 4\ \times\ \pi\ \times\ r^2`$ | $`V = \frac{4}{3}\ \times\ \pi\ \times\ r^3`$ |

Observações:

- Para este trabalho, deverá ser considerado um triângulo equilátero, no qual os três lados são congruentes.
- O perímetro de um círculo é chamado de comprimento da circunferência e *r* é a medida do raio do círculo, isto é, a distância entre o centro e a extremidade do círculo.
- Para este trabalho, deverá ser considerada uma pirâmide com base quadrangular, ou seja, contendo uma base formando um quadrado e quatro faces laterais triangulares.
- A área lateral de uma pirâmide é dada pela soma das áreas de todas as faces laterais triangulares.

## Tarefas

A tarefa principal a ser realizada neste trabalho é a implementação, na linguagem de programação Go, um programa que calcula as medidas de diversas figuras geométricas planas e espaciais. O programa em execução deve apresentar ao usuário uma lista de opções referentes às figuras e, após a escolha de uma dessas opções, deve solicitar ao usuário que forneça os dados necessários aos cálculos das medidas. Como resultado, o programa deve exibir as respectivas medidas (área, perímetro, volume) da figura escolhida. Para figuras geométricas planas, o programa deve exibir apenas a área e o perímetro; para figuras geométricas espaciais, o programa deve exibir apenas a área e o volume da figura. Para calcular tais medidas, deverá se fazer uso das equações matemáticas apresentadas nas tabelas acima, além de conhecimentos matemáticos prévios na área de Geometria. Essa tarefa será desdobrada em três sub-tarefas, conforme descrito a seguir.

### Tarefa 1: Implementação de pacotes

Seguindo boas práticas de modularização, a implementação das funções que calculam as medidas de área, perímetro e volume deverá ser feita **em três pacotes distintos**. Assim sendo, o pacote `area` deverá conter a implementação das funções que calculam a área de figuras geométricas planas e espaciais, o pacote `perimetro` com as funções que calculam o perímetro de figuras geométricas planas e o pacote `volume` com as funções que calculam o volume de figuras geométricas espaciais.

### Tarefa 2: Implementação de testes unitários

Cada um dos pacotes deverá **obrigatoriamente** vir acompanhado de arquivos fonte contendo a implementação de funções que realizam testes unitários sobre as funções de cálculo das medidas de área, perímetro e volume de figuras geométricas espaciais. A implementação desses testes deverá ser feita em conformidade com o *framework* de testes da linguagem de programção Go, representado pelo pacote [`testing`](https://pkg.go.dev/testing), juntamente com a ferramenta `go test` para executar os casos de teste. Os testes deverão prever tanto casos de sucesso quanto de falha nos testes, em que deverão ser exibidas mensagens representativas ao usuário sobre a ocorrência de erros. Além disso, os testes unitários poderão tanto ser básicos (isto é, testando um par específico entrada-resultado esperado) quanto tableados (isto é, testando múltiplos pares entrada-resultado esperado). Finalmente, a implementação e execução dos casos de teste deverá ainda garantir **cobertura completa** (100%) dos testes unitários.

### Tarefa 3: Implementação do programa principal

Além da implementação dos pacotes com suas respectivas funções, deverá ser implementado o programa principal que calcula as medidas de área, perímetro e volume chamando as respectivas funções implementadas. O arquivo fonte correspondente a esse programa principal deverá fazer parte de um **módulo** que contenha o arquivo fonte correspondente ao programa principal e que importe os pacotes anteriormente implementados (e devidamente testados) como dependências.

O programa em execução deve primeiramente apresentar ao usuário uma lista com nove opções, numeradas de 0 a 8, referentes às figuras geométricas planas e espaciais das quais deseja-se obter as medidas. Quando o usuário digitar `0` como opção, o programa deverá ter sua execução finalizada. Caso seja digitada uma opção diferente das disponíveis, o programa deverá emitir uma mensagem de erro (utilizando os tipos e funções para manipulação de erros definidos pela linguagem de programação Go) informando da entrada inválida e solicitando que o usuário digite uma nova opção. Um exemplo de execução inicial do programa seria:

```bash
$ ./geometria
Calculadora de Geometria Plana e Espacial
(1) Triângulo equilatero
(2) Retângulo
(3) Quadrado
(4) Círculo
(5) Pirâmide com base quadrangular
(6) Cubo
(7) Paralelepípedo
(8) Esfera
(0) Sair
Digite a sua opção:
```

Após o usuário digitar a opção escolhida, o programa deverá solicitar os dados necessários para o cálculo das medidas de acordo com a figura em questão. Por exemplo, supondo que o usuário tenha escolhido a opção `2` para cálculo das medidas referentes a um retângulo. (uma figura geométrica plana), serão calculados apenas a sua área e o seu perímetro, de modo que é necessário informar o tamanho da base e da altura do retângulo, como no exemplo a seguir:

```bash
Digite a sua opção: 2
Digite o tamanho da base do retângulo: 5
Digite o tamanho da altura do retângulo: 3
```

Uma vez que o usuário tenha informado os dados necessários aos cálculos, o programa deverá chamar as respectivas funções de cálculos das medidas de acordo com a figura geométrica em questão e exibir os resultados correspondentes. Caso seja fornecido algum dado inválido, o programa deverá informar ao usuário a ocorrência de erro. Dessa forma, ainda considerando o exemplo anterior das medidas referentes a um retângulo, o programa exibirá as medidas da área e do perímetro do retângulo, como segue:

```bash
Área do retângulo: 15
Perímetro do retângulo: 16
```

Após a exibição dos resultados das medidas de uma figura geométrica, o programa deverá exibir novamente a lista com as nove opções do menu inicial.

## Requisitos

A implementação deste trabalho requer os seguintes elementos instalados no ambiente de desenvolvimento:

- [Git](https://git-scm.com), como sistema de controle de versões
- [Go](https://go.dev), incluindo compilador, ambiente de execução e outras ferramentas associadas à linguagem de programação Go

## Autoria e política de colaboração

Este trabalho deverá necessariamente ser realizado em equipe composta de **até dois estudantes**, sendo importante, dentro do possível, dividir as tarefas igualmente entre os integrantes da equipe. Após a implementação das soluções para os problemas propostos, o arquivo [`author.md`](author.md) presente no repositório deverá ser editado preenchendo as informações de identificação dos integrantes da equipe, na seção [Informações de Autoria](author.md#identificação-de-autoria).

O trabalho em cooperação entre estudantes da turma é estimulado, sendo admissível a discussão de ideias e estratégias. Contudo, tal interação não deve ser entendida como permissão para utilização de (parte de) código fonte de colegas, o que pode caracterizar situação de plágio. **Trabalhos copiados no todo ou em parte de outros colegas ou da Internet serão anulados e receberão nota zero.**

## Entrega

O sistema de controle de versões [Git](https://git-scm.com) e o serviço de hospedagem de repositórios [GitHub](https://git-scm.com) serão utilizados para possibilitar a entrega da implementação realizadas. Para possibilitar a associação de repositórios Git para cada equipe e reuni-los sob uma mesma infraestrutura, foi criada uma atividade (*assignment*) no GitHub Classroom. Cada integrante de equipe deverá acessar este [*link*](https://classroom.github.com/a/StTlkHn5), aceitar o convite para ingressar no GitHub Classroom e finalmente seguir as instruções em tela para acessar a atividade e ingressar em uma equipe existente ou criar outra. Este [vídeo](https://youtu.be/ObaFRGp_Eko) demonstra como ocorre esse processo.

No momento de criação de uma equipe, o GitHub Classroom cria um repositório Git privado acessível unicamente pelos integrantes da equipe e pelo docente, sob a organização [`ufrn-golang`](https://github.com/ufrn-golang). A fim de garantir a boa manutenção do repositório, deve-se ainda configurar corretamente o arquivo `.gitignore` para desconsiderar arquivos que não devam ser versionados, a exemplo do arquivo executável gerado a partir da compilação do código fonte.

A implementação do programa objeto deste trabalho deverá ser realizada **até as 11:00 do dia 26 de junho de 2023** no respectivo repositório Git da equipe. Para fins de registro, o endereço do repositório também deverá ser **obrigatoriamente** enviado através da opção *Tarefas* na Turma Virtual do SIGAA, devendo **um único membro da equipe** realizar esse envio. Além disso, **não serão aceitos envios por outros meios ou repositórios que não sejam os descritos nesta especificação.**

## Avaliação

A avaliação do programa implementado contabilizará nota de até 10,0 pontos. O programa implementado será avaliado de acordo com os seguintes critérios:

- utilização correta dos recursos providos pela linguagem de programação Go;
- corretude da execução do programa implementado, que deve apresentar saída em conformidade com a especificação;
- aplicação de boas práticas de programação, incluindo legibilidade, organização e documentação de código fonte, e;
- correta utilização do repositório Git, no qual deverá ser registrado todo o histórico da implementação por meio de *commits*.

O não cumprimento de algum dos critérios de avaliação especificados poderá resultar nos seguintes decréscimos, aplicados sobre a nota obtida até então na avaliação:

| Falta | Decréscimo |
| :--- | ---: |
| Falta de comentários no código fonte | -10% |
| Uso inadequado de controle de versão com Git | -20% |
| Falta de especificação ou especificação incorreta da autoria do trabalho (arquivo [`author.md`](author.md)) | -20% |
| Código fonte com legibilidade prejudicada (por exemplo, com identação ou nomenclatura inadequada) | -30% |
| Implementação realizada em desacordo com as especificações postas para o trabalho | -50% |
| Programa apresenta erros de compilação, não executa ou apresenta saída incorreta | -70% |
| Percentual de cobertura de testes inferior a 100% | -40% |
| Erro na execução de testes unitários | -60% |
| Ausência ou incompletude de arquivos de teste | -70% |
| Plagiarismo | -100% |

## Dúvidas e informações

Caso haja qualquer dúvida, questionamento ou necessidade de informação adicional, é possível:

- enviar *e-mail* para o endereço <everton.cavalcante@ufrn.br>;
- enviar mensagem privada diretamente ao docente, utilizando o servidor Discord;
- enviar mensagem no canal de texto `#duvidas` no servidor Discord, ou;
- agendar encontros síncronos pelo canal de áudio `Fale com Prof. Everton` no servidor Discord.
