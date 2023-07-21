
# Trabalho 3: API REST - Go Movies

Implementação de uma API REST desenvolvida em Golang.

A API consiste em um CRUD para filmes e também realiza consultas
na API externa da [OMDB](http://www.omdbapi.com/)
## Autores

- Matricula: 20210096853 - [Douglas Alexandre dos Santos](https://www.github.com/Douglas08Santos) (santosdouglas0809@gmail.com)
- Matricula: 20210054361 - [João Victor Dantas](https://github.com/vicdant1) (victor.dantas.707@ufrn.edu.br)


## Documentação

A seguir temos a estrutura dos diretorios da aplicação

├── api  
│   ├── api.go  
│   └── api_test.go  
│── client  
│   ├── main.go  
│   └── principal  
│       ├── models.go  
│       └── principal.go  
│── crud  
│   └── crud.go  
│── openmdb  
│   └── openmdb.go  
│── go.mod  
│── go-movies.postman_collection.json  
│── go.sum  
│── LICENSE  
│── README.md  
│── server.go  

### Diretório - api
Contém o arquivo api.go que possui as operações que usam tanto as funções do arquivo crud.go quanto as do arquivo openmdb.go. Essas operações são chamadas da rotas que foram criadas que serão explicada na seção "Documentação da API". As funções presente no arquivo api.go são:

    - MyMovies(writer, req)
        Busca todos os filmes salvo localmente
        200 = OK - Retorna a lista de filmes salva localmente em formato json
        204 = Not Content - Retorno o erro 204 indicando que a não possui filmes salvos
    
    - MyMoviebyID(writer, req)
        Busca um filme salvo pelo id
        200 = OK - Retorna o filme salvo com o id correspondente
        404 = Not Found - Retorna o erro 404 indicando que o filme com o id passado não foi encontrado
    
    - CreateMovie(writer, req)
        Salva o novo filme que é passado pelo body da requisição
        201 = Created - Retorna o filme salvo
        400 = Bad request - o body passado é invalido para ser salvo
        409 = Conflict - o filme que está sendo salvo já foi salvo anteriomente
    
    - UpdateMovie(writer, req)
        Atualiza informações, que é passado pelo body da requisição, de um filme salvo 
        202 = Accepted - Retorna o filme salvo
        400 = Bad request - Retorna o erro 400 indicando que o body passado é invalido para ser salvo anteriomente
        404 = Not Found - Retorna o erro 404 indicando que o id não pertence a um filme salvo localmente
    
    - DeleteMovie(writer, req)
        Deleta o filme salvo localmente pelo id
        200 = OK - Retorna o filme salvo
        404 = Not Found - Retorna o erro 404 indicando que o id não pertence a um filme salvo localmente
    
    - GetMovieOpenMbd(writer, req)
        Pesquisa um filme especifico baseado no seu titulo e ano
        200 = OK - Retorna o filme salvo
        404 = Not Found - Retorna o erro 404 indicando que o filme foi encontrado na pesquisa
    

### Diretório - client
Contém o arquivo main.go que é responsavel por criar uma interface no terminal para o usuário.

### Diretório - crud
    
Contém o arquivo crud.go que possui as operações de CRUD [Create, Read, Update e Delete] para os filmes dentro de um slice local, sem persistência. Possui as funções que retorna junto seus respectivos http status code:

    - GetMovies() 
        Lista de filmes salvo localmente.
        200 = OK - retorna uma lista não vazia
        204 = No Content - retorna uma lista vazia

    - GetMovie(id)
        Busca de filme pelo id.
        302 = Found - retorna o filme salvo localmente
        404 = Not Found - retorna um filme vazio
    
    - CreateMovie(newMovie)
        Salva um novo filme localmente.
        201 = Created - Retorna o filme salvo 
        409 = Conflict - Retorna o filme que já está salvo com o mesmo imdb id
    
    - DeleteMovie(id)
        Apaga filme da lista pelo id
        200 = OK - retorna o status 200 quando tenha apagado com sucesso
        404 = Not Found - retorna o status 404 quando o id passado não exista
    
    - UpdateMovie(id, updatedMovie)
        Atualizar filme de acordo com id passado
        202 = Accepted - as mudanças foram realizadas no filme do id passado
        404 = Not Found - o id passado não foi encontrado salvo localmente
    
### Diretório - openmdb

Contém o arquivo openmdb.go que possui as funções responsavel por realizar a consulta na api externa [OMDB](http://www.omdbapi.com/). As operações presente são:

    - OpenmdbAPI(search, imdbID, title, year)
        Função principal que fará as requisições para a api baseado nos parâmetros passado para ela.  
		+ search = se != "" então retorna uma lista de resultados baseado no titulo passado
		+ imdbID = se != "" retorna o filme que possui imdbID especificado
		+ title = se != "" retorna o filme que possui o title especificado
		+ year = parâmetro opcional que pode ser usado junto aos parâmetros 'search' ou 'title'
    
    - MoviesSearch(search, year)
        Função para busca de filmes baseado no parâmetro 'search'. Chama a função OpenmdbAPI da seguinte forma: OpenmdbAPI(search, "", "", year)
        Obs: parâmetro year é opcional
    
    - MovieByTitle(title, year)
        Função para busca um filme especifico de uma dado titulo. Chama a função OpenmdbAPI da seguinte forma: OpenmdbAPI("", "", title, year)
        Obs: parâmetro year é opcional
    
    - MovieByImdbID(imdbID)
        Função para busca um filme especifico de uma dado imdb ID. Chama a função OpenmdbAPI da seguinte forma: OpenmdbAPI("", imdbID, "", "")





## Documentação API

#### GET - Todos os filmes salvos

```golang
router.HandleFunc("/go-movies", api.MyMovies).Methods("GET")
```
    exemplo url: GET http://localhost:8000/go-movies

| Code   | Status       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| 200  | OK | Retorna uma lista, não-vazia, todos os filmes salvos localmente|
| 204 | No Content | Mensagem 204 |



#### GET - Filme pelo id

```golang
router.HandleFunc("/go-movies/{id}", api.MyMoviebyID).Methods("GET")
```
    exemplo: GET http://localhost:8000/go-movies/4

| Code   | Status       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| 200  | OK | Retorna o filme salvo pelo id|
| 404 | Not Found | Mensagem 404 |


#### POST - Salva novo filme

```golang
router.HandleFunc("/go-movies", api.CreateMovie).Methods("POST")
```
    exemplo: POST http://localhost:8000/go-movies

| Code   | Status       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| 201  | Created | Retorna o filme salvo pelo id|
| 409 | Conflict | Mensagem 409 |

#### PUT - Atualizar dados de algum filme pelo id

```golang
router.HandleFunc("/go-movies/{id}", api.UpdateMovie).Methods("PUT")
```
    exemplo: PUT http://localhost:8000/go-movies/3

| Code   | Status       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| 202  | Accepted | Retorna o filme alterado|
| 400 | Bad Request | Mensagem 400 |
| 404 | Not Found | Mensagem 404 - Filme não encontrado para ser alterado |

#### DELETE - Apagar um filme pelo id
```golang
router.HandleFunc("/go-movies/{id}", api.DeleteMovie).Methods("DELETE")
```
    exemplo: DELETE http://localhost:8000/go-movies/3

| Code   | Status       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| 200  | OK | Filme removido|
| 404 | Not Found | Mensagem 404 |

#### GET - Pesquisar filme pela api externa
```golang
router.HandleFunc("/go-movies/", api.GetMovieOpenMbd).Methods("GET").Queries("title", "", "year", "{year:[0-9]*}")
```

    exemplo: GET http://localhost:8000/go-movies/?title=barbie&year=2023



| Code   | Status       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| 200  | OK | Retorna o filme que foi achado pela pesquisa|
| 404 | Not Found | Mensagem 404 |


## Execução

#### Para executar o servidor.
Na pasta raiz do projeto, executar o comando:

```bash
 go run server.go
```

#### Para executar o cliente.
Na pasta raiz do projeto, executar o comando:

```bash
 go run client/main.go
```

### Obs:

Junto ao projeto possui um arquivo `go-movies.postman_collection.json` que pode ser importado dentro do [Postman]( https://www.postman.com/), que terá as rotas que podem ser usadas para teste.
