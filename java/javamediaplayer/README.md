# MP3 Player
![Badge em Concluído](http://img.shields.io/static/v1?label=STATUS&message=%20CONCLUÍDO&color=GREEN&style=for-the-badge)

## Índice

* [Índice](#índice)
* [Descrição do Projeto](#descrição-do-projeto)
* [Funcionalidades](#funcionalidades)
* [Compilação](#compilação)
* [Utilizando o sistema com o usuário padrão](#utilizando-o-sistema-com-o-usuário-padrão)
* [Tecnologias utilizadas](#tecnologias-utilizadas)
* [Pessoas Desenvolvedoras do Projeto](#pessoas-desenvolvedoras-do-projeto)
* [Conclusão](#conclusão)

## Descrição do Projeto
O MP3 Player é um projeto que consiste em um tocador de MP3 desenvolvido em Java. 
O objetivo é criar um aplicativo capaz de reproduzir arquivos de áudio em formato MP3. Além disso, o projeto utiliza conceitos de 
programação orientada a objetos, como organização de pacotes, interface gráfica, utilização de 
bibliotecas externas, documentação JavaDOC e 
tratamento de exceções. O aplicativo também implementa recursos de controle 
de acesso, permitindo diferentes níveis de usuário.

## Funcionalidades

As principais funcionalidades do MP3 Player são:

- Reprodução de músicas em formato MP3.
- Login de usuários com diferentes níveis de acesso.
- Usuários comuns podem reproduzir músicas selecionadas de uma diretório.
- Usuários "VIP" podem criar playlists personalizadas e cadastrar usuários para acesso ao player.
- Recuperação automática da lista de músicas ao fazer login.
  
## Compilação
- Para a compilação é necessario ter intalado o [JavaFX(versão 20)](https://gluonhq.com/products/javafx/) no [Eclipse](https://www.eclipse.org/downloads/packages/installer), e ter o [JDK](https://www.oracle.com/br/java/technologies/downloads/#jdk20-windows), em qualquer versão a partir da 19, instalado no seu computador.
- Ao importar o projeto no Eclipse, primeiro verifique se já estão presentes as bibliotecas necessárias, o JRE System Library(JDK em qualquer versão acima da 18) e o JavaFX(Versão 20). Caso as bibliotecas já estejam presentes ao importar o projeto, remova-as e adicione-as novamente, para assim evitar erros de não reconhecimento do código.
- Verifique os arquivos .txt no pacote *data*. Caso encontre caminhos nos arquivos diretorios.txt e musicas.txt que não correspondam ao seu computador, remova-os, deixando apenas uma linha em branco. Se encontrar playlists que não foram criadas por você, por favor, remova-as.
- Com tudo isso verificado o projeto está pronto para ser compilado, basta selecionar o *MainApp.java* e pressionar ctrl + F11 ou clicar do ícone  ![image](https://github.com/JoelFnandes/mediaplayer/assets/60944861/42f51828-86e4-430d-a014-ae050f1ed437)
 do Eclipse.

## Utilizando o sistema com o usuário padrão

- Para utilizar o sistema pela primeira vez, será necessário usar o usuário "admin", cuja senha também é "admin":


  ![image](https://github.com/JoelFnandes/mediaplayer/assets/69057084/e6e52eb7-d544-45a8-8e98-90354fa91bcf)

- Quando autenticado, esse usuário possui poderes plenos sobre a aplicação:


  ![image](https://github.com/JoelFnandes/mediaplayer/assets/69057084/1fa6822d-4644-48a3-b3dd-4f12e66a0eaa)


## Tecnologias utilizadas

- ``Java``
- ``JavaFX``
- ``Scene Builder``
- ``InteliJ IDEA``
- ``Eclipse``

## Conclusão
O MP3 Player é um projeto concluído que demonstra o desenvolvimento de um tocador de MP3 em Java, aplicando conceitos de programação orientada a objetos e fornecendo recursos de controle de acesso. Com as funcionalidades implementadas, o aplicativo permite que os usuários reproduzam músicas, criem playlists personalizadas e adicionem novos usuários com diferentes níveis de acesso. O projeto utiliza tecnologias como Java, JavaFX e as IDEs IntelliJ IDEA e Eclipse para o desenvolvimento.

## Pessoas Desenvolvedoras do Projeto

| [<img src="https://avatars.githubusercontent.com/u/60944861?v=4" width=115><br><sub>Joel Fernandes</sub>](https://github.com/JoelFnandes) | [<img src="https://avatars.githubusercontent.com/u/69057084?v=4" width=115><br><sub>João Victor Dantas</sub>](https://github.com/vicdant1) |
| :---: | :---: |
