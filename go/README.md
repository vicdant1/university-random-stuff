[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=10681626&assignment_repo_type=AssignmentRepo)
# Lista 1: Elementos fundamentais de programação em Go
<sub>Última atualização: 28/03/2023</sub>

## Sumário
- [Visão geral e objetivos](#visão-geral-e-objetivos)  
- [Tarefas](#tarefas)
- [Requisitos](#requisitos)
- [Orientações gerais](#orientações-gerais)
- [Autoria e política de colaboração](#autoria-e-política-de-colaboração)
- [Entrega](#entrega)
- [Avaliação](#avaliação)
- [Dúvidas e informações](#dúvidas-e-informações)

## Visão geral e objetivos
O objetivo desta lista de exercícios é colocar em prática as habilidades de **interpretar especificações de problemas** e projetar e implementar soluções na forma de programas na linguagem de programação Go. Para tanto, esta lista explora elementos fundamentais da programação em Go, como tipos, variáveis, funções, estruturas de controle de fluxo, estruturas de dados básicas (*arrays*, *slices* e mapas), escrita de informações na saída padrão, dentre outros.

## Tarefas
As tarefas a serem realizadas neste trabalho consistem em projetar e implementar, em Go, programas para cada um dos cinco seguintes problemas:

1. [break_infinite](https://github.com/ufrn-golang/lista1/tree/master/break_infinite)
2. [c2f](https://github.com/ufrn-golang/lista1/tree/master/c2f)
3. [loan_calculator](https://github.com/ufrn-golang/lista1/tree/master/loan_calculator)
4. [statesBR](https://github.com/ufrn-golang/lista1/tree/master/statesBR)
5. [unique](https://github.com/ufrn-golang/lista1/tree/master/unique)

A descrição de cada um desses problemas está em seu respectivo diretório, juntamente com exemplos de saídas esperadas para o programa e uma relação dos recursos da linguagem de programação Go necessários à implementação da solução. Cada um desses diretórios possui um código fonte base que poderá ser utilizado como ponto de partida para a implementação das soluções. Dessa forma, o código fonte das soluções implementadas deverá constar nos respectivos diretórios.

## Requisitos
Para que seja possível compilar e executar os testes preparados para este trabalho, é necessário que os seguintes elementos estejam instalados no ambiente de desenvolvimento:

- [Git](https://git-scm.com), como sistema de controle de versões
- [Go](https://go.dev), incluindo compilador, ambiente de execução e outras ferramentas associadas à linguagem de programação Go

## Orientações gerais
Boas práticas de programação deverão ser constantemente aplicadas no desenvolvimento das soluções aos problemas propostos, Assim, os programas deverão ser codificados de forma legível (com indentação de código fonte, nomes consistentes, etc.) e documentados adequadamente na forma de comentários.

As soluções deverão ainda ser desenvolvidas com qualidade, garantindo que o programa funcione de forma correta e eficiente. Deve-se também pensar nas possíveis entradas que poderão ser utilizadas para testar apropriadamente cada programa, além de serem tratadas adequadamente possíveis entradas consideradas inválidas.

## Autoria e política de colaboração
Este trabalho deverá necessariamente ser realizado em equipe composta de **até dois estudantes**, sendo importante, dentro do possível, dividir as tarefas igualmente entre os integrantes da equipe. Após a implementação das soluções para os problemas propostos, o arquivo [`author.md`](https://github.com/ufrn-golang/lista1/tree/master/author.md) presente no repositório deverá ser editado preenchendo as informações de identificação dos integrantes da equipe, na seção [Informações de Autoria](https://github.com/ufrn-golang/lista1/tree/master/author.md#identificação-de-autoria) e informando-se quais dos problemas foram solucionados com sucesso, na seção [Soluções Implementadas](https://github.com/ufrn-golang/lista1/tree/master/author.md#soluções-implementadas). 

O trabalho em cooperação entre estudantes da turma é estimulado, sendo admissível a discussão de ideias e estratégias. Contudo, tal interação não deve ser entendida como permissão para utilização de (parte de) código fonte de colegas, o que pode caracterizar situação de plágio. Trabalhos copiados no todo ou em parte de outros colegas ou da Internet serão anulados e receberão nota zero.

## Entrega
O sistema de controle de versões [Git](https://git-scm.com) e o serviço de hospedagem de repositórios [GitHub](https://git-scm.com) serão utilizados para possibilitar a entrega das implementações realizadas. Para possibilitar a associação de repositórios Git para cada equipe e reuni-los sob uma mesma infraestrutura, foi criada uma atividade (*assignment*) no GitHub Classroom. Cada integrante de equipe deverá acessar este [*link*](https://classroom.github.com/a/8HCMJQOQ), aceitar o convite para ingressar no GitHub Classroom e finalmente seguir as instruções em tela para acessar a atividade e ingressar em uma equipe existente ou criar outra. Este [vídeo](https://youtu.be/ObaFRGp_Eko) demonstra como ocorre esse processo.

No momento de criação de uma equipe, o GitHub Classroom cria um repositório Git privado acessível unicamente pelos integrantes da equipe e pelo docente, sob a organização [`ufrn-golang`](https://github.com/ufrn-golang). Esse repositório segue a mesma estrutura de diretórios presentes neste repositório, o qual serve de *template*. Todos os arquivos deverão constar no repositório obedecendo **estritamente** a divisão em diretórios, ou seja, os códigos fonte referentes às soluções implementadas deverão estar nos respectivos diretórios de cada problema. A fim de garantir a boa manutenção do repositório, deve-se ainda configurar corretamente o arquivo `.gitignore` para desconsiderar arquivos que não devam ser versionados, a exemplo do arquivo executável gerado a partir da compilação do código fonte.

A implementação das soluções para os problemas propostos neste trabalho deverá ser realizada **até as 11:00 do dia 3 de abril de 2023** no respectivo repositório Git da equipe. Para fins de registro, o endereço do repositório também deverá ser **obrigatoriamente** enviado através da opção *Tarefas* na Turma Virtual do SIGAA, devendo **um único membro da equipe** realizar esse envio. Além disso, **não serão aceitos envios por outros meios ou repositórios que não sejam os descritos nesta especificação.**

## Avaliação
A avaliação de cada uma das soluções para os cinco problemas propostos contabilizará nota de até 2,0 pontos cada, totalizando 10,0 pontos. As soluções implementadas serão avaliadas de acordo com os seguintes critérios: 

- utilização correta dos recursos providos pela linguagem de programação Go;
- corretude da execução dos programas implementados, que devem apresentar saída em conformidade com a especificação;
- aplicação de boas práticas de programação, incluindo legibilidade, organização e documentação de código fonte, e;
- correta utilização do repositório Git, no qual deverá ser registrado todo o histórico da implementação por meio de *commits*. 

O não cumprimento de algum dos critérios de avaliação especificados poderá resultar nos seguintes decréscimos, aplicados sobre a nota obtida até então na avaliação de cada solução:

| Falta | Decréscimo |
| :--- | ---: |
| Falta de comentários no código fonte | -10% |
| Uso inadequado de controle de versão com Git | -20% |
| Falta de especificação ou especificação incorreta da autoria do trabalho (arquivo [`author.md`](https://github.com/ufrn-golang/lista1/tree/master/author.md)) | -20% |
| Código fonte com legibilidade prejudicada (por exemplo, com identação ou nomenclatura inadequada) | -50% |
| Programa apresenta erros de compilação, não executa ou apresenta saída incorreta | -70% |
| Plagiarismo | -100% |

## Dúvidas e informações
Caso haja qualquer dúvida, questionamento ou necessidade de informação adicional, é possível:
- enviar *e-mail* para o endereço everton.cavalcante@ufrn.br;
- enviar mensagem privada diretamente ao docente, utilizando o servidor Discord;
- enviar mensagem no canal de texto `#duvidas` no servidor Discord, ou;
- agendar encontros síncronos pelo canal de áudio `Fale com Prof. Everton` no servidor Discord.
