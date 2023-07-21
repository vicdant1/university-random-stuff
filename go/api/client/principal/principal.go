package principal

import (
	"bufio"
	"encoding/json"
	"fmt"
	"io"
	"net/http"
	"os"
	"strconv"
	"strings"
)

const BASE_URL = "http://localhost:8000/go-movies"

// Função para listar os filmes salvos no serviço
func ListSavedMovies() {
	// Faz uma requisição GET para a URL base do serviço
	if res, err := http.Get(BASE_URL); err != nil {
		fmt.Printf("Ocorreu um erro na requisição: %s\n", err.Error())
	} else {
		// Verifica o código de status da resposta
		if res.StatusCode == 204 {
			fmt.Println("Nenhum filme cadastrado.")
		} else {
			// Lê o conteúdo da resposta e fecha o corpo da requisição
			contents, _ := io.ReadAll(res.Body)
			defer res.Body.Close()

			// Decodifica o conteúdo da resposta em uma lista de MovieDto
			var movies []MovieDto
			err := json.Unmarshal(contents, &movies)
			if err != nil {
				fmt.Println("Ocorreu um erro ao receber a resposta da aplicação:", err)
				return
			}

			// Exibe as informações de cada filme
			if len(movies) > 0 {
				fmt.Println("Meus filmes:")
				for _, movie := range movies {
					fmt.Println("----------------------------------------------------------------------------")

					fmt.Println("ID: " + movie.ID)
					fmt.Print("Título: " + movie.Title)
					fmt.Print("Diretor: " + movie.Director)
					fmt.Print("Ano: " + movie.Year)
					fmt.Print("Gênero: " + movie.Genre)
					fmt.Print("Identificador Imdb: " + movie.ImdbID)
					fmt.Print("Plot: " + movie.Plot)
					fmt.Print("Tipo: " + movie.Type)

					fmt.Println("----------------------------------------------------------------------------")
				}
			}
		}
	}
}

// Função para obter um filme pelo seu ID
func GetMovieById() {
	var choose int
	fmt.Print("Digite o ID do filme: ")
	fmt.Scanf("%d\n", &choose)

	if choose < 0 {
		fmt.Println("Id inválido, por favor tente novamente")
		return
	}

	endpoint := BASE_URL + "/" + strconv.Itoa(choose)

	if res, err := http.Get(endpoint); err != nil {
		fmt.Printf("Ocorreu um erro na requisição: %s\n", err.Error())
	} else {
		switch {
		case res.StatusCode == 200:
			contents, _ := io.ReadAll(res.Body)
			defer res.Body.Close()

			// Decodifica o conteúdo da resposta em um MovieDto
			var movie MovieDto
			err := json.Unmarshal(contents, &movie)
			if err != nil {
				fmt.Println("Ocorreu um erro ao receber a resposta da aplicação:", err)
				return
			}

			fmt.Println("----------------------------------------------------------------------------")

			fmt.Println("ID: " + movie.ID)
			fmt.Print("Título: " + movie.Title)
			fmt.Print("Diretor: " + movie.Director)
			fmt.Print("Ano: " + movie.Year)
			fmt.Print("Gênero: " + movie.Genre)
			fmt.Print("Identificador Imdb: " + movie.ImdbID)
			fmt.Print("Plot: " + movie.Plot)
			fmt.Print("Tipo: " + movie.Type)

			fmt.Println("----------------------------------------------------------------------------")

			break
		case res.StatusCode == 404:
			fmt.Println("Filme não encontrado na base, valide o Id e tente novamente.")
			break
		}
	}
}

// Função para criar um novo filme
func CreateMovie() {
	// Solicita informações sobre o novo filme ao usuário e cria um objeto MovieDto
	movie := seedMovieObject()
	movieJson, err := json.Marshal(movie)

	if err != nil {
		fmt.Println("Não foi possível criar o filme, valide as informações e tente novamente")
		return
	}

	// Cria um objeto strings.Reader com o JSON do filme
	data := strings.NewReader(string(movieJson))
	// Faz uma requisição POST para criar o filme no serviço
	if res, err := http.Post(BASE_URL, "application/json", data); err != nil {
		fmt.Println("Não foi possível criar o filme, valide as informações e tente novamente")
	} else {
		switch {
		case res.StatusCode == 201:
			fmt.Println("Filme criado com sucesso")
		case res.StatusCode == 400:
			fmt.Println("Não foi possível criar o filme, valide as informações e tente novamente")
		case res.StatusCode == 409:
			fmt.Println("Ocorreu conflito na criação do filme, valide as informações e tente novamente")
		}
	}
}

// Função para atualizar um filme existente
func UpdateMovie() {
	var choose int
	fmt.Print("Digite o ID do filme: ")
	fmt.Scanf("%d\n", &choose)

	if choose < 0 {
		fmt.Println("Id inválido, por favor tente novamente")
		return
	}

	endpoint := BASE_URL + "/" + strconv.Itoa(choose)
	// Solicita informações atualizadas sobre o filme ao usuário e cria um objeto MovieDto
	movie := seedMovieObject()

	movieJson, err := json.Marshal(movie)

	if err != nil {
		fmt.Println("Não foi possível editar o filme, valide as informações e tente novamente")
		return
	}

	// Cria um objeto strings.Reader com o JSON atualizado do filme
	data := strings.NewReader(string(movieJson))
	// Cria uma requisição PUT para atualizar o filme no serviço
	req, _ := http.NewRequest(http.MethodPut, endpoint, data)
	if res, err := http.DefaultClient.Do(req); err != nil {
		fmt.Println("Não foi possível editar o filme, valide as informações e tente novamente")
	} else {
		switch {
		case res.StatusCode == 202:
			fmt.Println("Filme editado com sucesso")
		case res.StatusCode == 400:
			fmt.Println("Não foi possível editar o filme, valide as informações e tente novamente")
		case res.StatusCode == 404:
			fmt.Println("Filme não encontrado na base")
		}
	}
}

// Função para deletar um filme pelo ID
func DeleteMovie() {
	var choose int
	fmt.Print("Digite o ID do filme: ")
	fmt.Scanf("%d\n", &choose)

	if choose < 0 {
		fmt.Println("Id inválido, por favor tente novamente")
		return
	}

	// Constrói o endpoint com o ID do filme a ser deletado
	endpoint := BASE_URL + "/" + strconv.Itoa(choose)

	// Cria uma requisição HTTP do tipo DELETE
	req, _ := http.NewRequest(http.MethodDelete, endpoint, nil)
	if res, err := http.DefaultClient.Do(req); err != nil {
		fmt.Println("Não foi possível deletar o filme, valide as informações e tente novamente")
	} else {
		switch {
		case res.StatusCode == 200:
			fmt.Println("Filme deletado com sucesso")
		case res.StatusCode == 400:
			fmt.Println("Não foi possível deletar o filme, valide as informações e tente novamente")
		case res.StatusCode == 404:
			fmt.Println("Filme não encontrado na base")
		}
	}
}

// Função para solicitar ao usuário informações sobre um novo filme
func seedMovieObject() (movie CreateMovieDto) {
	movie = CreateMovieDto{}

	reader := bufio.NewReader(os.Stdin)

	fmt.Print("Identificador IMDb: ")
	movie.ImdbID, _ = reader.ReadString('\n')

	fmt.Print("Título: ")
	movie.Title, _ = reader.ReadString('\n')

	fmt.Print("Ano: ")
	movie.Year, _ = reader.ReadString('\n')

	fmt.Print("Lançamento: ")
	movie.Released, _ = reader.ReadString('\n')

	fmt.Print("Gênero: ")
	movie.Genre, _ = reader.ReadString('\n')

	fmt.Print("Diretor(a): ")
	movie.Director, _ = reader.ReadString('\n')

	fmt.Print("Plot: ")
	movie.Plot, _ = reader.ReadString('\n')

	fmt.Print("Avaliação IMDb: ")
	movie.ImdbRating, _ = reader.ReadString('\n')

	fmt.Print("Tipo: ")
	movie.Type, _ = reader.ReadString('\n')

	fmt.Print("Avaliação Tomato: ")
	movie.TomatoRating, _ = reader.ReadString('\n')

	fmt.Print("Avaliação Usuários Tomato: ")
	movie.TomatoUserRating, _ = reader.ReadString('\n')

	return
}

// Função para buscar informações de um filme usando a API OpenMbd
func GetMovieOpenMbd() {
	scanner := bufio.NewScanner(os.Stdin)
	fmt.Print("Título: ")
	scanner.Scan()
	title := scanner.Text()

	var year int
	fmt.Print("Digite o ano do filme: ")
	fmt.Scanf("%d\n", &year)

	if year < 0 || year > 2023 {
		fmt.Println("Ano inválido, por favor tente novamente")
		return
	}

	// Constrói a queryString com o título e o ano do filme
	queryString := BASE_URL + "/?title=" + title + "&year=" + strconv.Itoa(year)

	if res, err := http.Get(queryString); err != nil {
		fmt.Printf("Ocorreu um erro na requisição: %s\n", err.Error())
	} else {
		// Lê o conteúdo da resposta e fecha o corpo da requisição
		contents, _ := io.ReadAll(res.Body)
		defer res.Body.Close()

		// Decodifica o conteúdo da resposta em um objeto MovieDto
		var movie MovieDto
		err := json.Unmarshal(contents, &movie)
		if err != nil {
			fmt.Println("Ocorreu um erro ao receber a resposta da aplicação:", err)
			return
		}

		fmt.Println("----------------------------------------------------------------------------")
		fmt.Println("Título: " + movie.Title)
		fmt.Println("Ano: " + movie.Year)
		fmt.Println("Lançamento: " + movie.Released)
		fmt.Println("Gênero: " + movie.Genre)
		fmt.Println("Diretor(a): " + movie.Director)
		fmt.Println("Plot: " + movie.Plot)
		fmt.Println("ID Imdb: " + movie.ImdbID)
		fmt.Println("----------------------------------------------------------------------------")
	}
}
