# `statesBR`

<sup>Última atualização: 28/03/2022</sup>

Escreva um programa em Go que recupera informações acerca das unidades federativas do Brasil (Estados e o Distrito Federal). O programa internamente gerencia uma estrutura de dados do tipo mapa que indexa o nome do Estado para um objeto de tipo estruturado que agrega nome, sigla, capital, população e região do Estado. O programa deve preencher o mapa com **alguns** Estados brasileiros e responder perguntas buscando informações nele armazenadas.

## Exemplo de Saída

```bash
Qual a capital de Paraná?
- Curitiba

Qual a população de São Paulo?
- 46649132 habitantes

Qual a sigla de Roraima?
- RR

Em que região Rio Grande do Norte está localizado?
- Região Nordeste
```

<ins>Dica:</ins> Os nomes dos Estados que aparecem nos enunciados das perguntas não devem ser estáticos, i.e., eles necessitam ser fornecidos como parâmetros à função responsável por recuperar a respectiva informação.

## Conhecimentos Necessários

- Tipos estruturados (*structs*)
- Funções
- Mapas
- Saída formatada