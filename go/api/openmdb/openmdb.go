package openmdb

import (
	"encoding/json"
	"errors"
	"fmt"
	"net/http"
	"net/url"
	"strconv"
)

/* =====================================================
*	Structs
*  =====================================================
 */
const openmdbURL = "http://www.omdbapi.com/"
const plot string = "short"

/* =====================================================
*	Structs - Estruturas
*  =====================================================
 */

// Tipo para os resultados da busca
type APIResult struct {
	Title  string `json:"title"`  // Titulo do resultado
	Year   string `json:"year"`   // Ano de lançamento
	ImdbID string `json:"imdbid"` // Imdb ID do resultado
	Type   string `json:"type"`   // Tipo do resultado: filme, série ou episodio
	Poster string `json:"poster"` // Poster do filme
}

// Tipo da resposta na busca
type APIResponse struct {
	Search       []APIResult `json:"search"`
	Response     string      `json:"response"`
	TotalResults string      `json:"totalResult"`
	Error        string      `json:"error"`
}

// Tipo para a busca de um filme especifico
type APIMovieResult struct {
	ID               string `json:"id"`
	ImdbID           string `json:"imdbid"`
	Title            string `json:"title"`
	Year             string `json:"year"`
	Released         string `json:"released"`
	Genre            string `json:"genre"`
	Director         string `json:"director"`
	Plot             string `json:"plot"`
	Poster           string `json:"poster"`
	ImdbRating       string `json:"rating_imdb"`
	Type             string `json:"type"`
	TomatoRating     string `json:"rating_tomatoes"`
	TomatoUserRating string `json:"user_rating_tomatoes"`
	Response         string `json:"response"`
	Error            string `json:"error"`
}

/* =====================================================
*	Funções
*  =====================================================
 */

/*
*	Função principal que fará as requisições para a api baseado nos
*	parâmetros passado para ela.
*		- search = se != "" então retorna uma lista de resultados baseado no titulo passado
*		- imdbID = se != "" retorna o filme que possui imdbID especificado
*		- title = se != "" retorna o filme que possui o title especificado
*		- year = parâmetro opcional que pode ser usado junto aos parâmetros 'search' ou 'title'
*
 */
func OpenmdbAPI(search, imdbID, title, year string) (resp *http.Response, err error) {
	if _, err := strconv.Atoi(year); err != nil {
		return nil, err
	}

	var URL *url.URL
	URL, err = url.Parse(openmdbURL)
	if err != nil {
		return nil, err
	}
	parameters := url.Values{}
	parameters.Add("apikey", "57c1a9b4") //57c1a9b4
	// Verificação de quais parâmetros foram passado para a função
	if len(search) > 0 {
		parameters.Add("s", search)
		parameters.Add("y", year) // Ano - Parâmetro opcional
	} else if len(imdbID) > 0 {
		parameters.Add("i", imdbID)
		parameters.Add("plot", plot)       //Adiciona o resumo do filme
		parameters.Add("tomatoes", "true") //Avaliações do Rotten Tomatoes
	} else if len(title) > 0 {
		parameters.Add("t", title)
		parameters.Add("plot", plot)       //Adiciona o resumo do filme
		parameters.Add("tomatoes", "true") //Avaliações do Rotten Tomatoes
		parameters.Add("y", year)          //Parâmetro opcional
	} else {
		return nil, fmt.Errorf("%v", "Invalid Request")
	}
	URL.RawQuery = parameters.Encode()
	res, _ := http.Get(URL.String())

	/*Verificação do status code*/
	err = checkErrorStatus(res.StatusCode)

	if err != nil {
		return nil, err
	}

	return res, nil

}

// Função private para verificar o statusCode retornado
func checkErrorStatus(status int) error {
	if status != 200 {
		return fmt.Errorf("%d", status)
	}
	return nil
}

/*
*	Função para busca de filmes baseado no parâmetro 'search'.
*	Obs: parâmetro year é opcional
 */
func MoviesSearch(search, year string) (*APIResponse, error) {
	res, err := OpenmdbAPI(search, "", "", year)
	if err != nil {
		return nil, err
	}

	defer res.Body.Close()
	response := new(APIResponse)
	err = json.NewDecoder(res.Body).Decode(response)

	if err != nil {
		return nil, err
	}

	if response.Response == "False" {
		return response, errors.New(response.Error)
	}
	return response, nil
}

/*
*	Função para busca um filme especifico de uma dado titulo.
*	Obs: parâmetro year é opcional
 */

func MovieByTitle(title, year string) (*APIMovieResult, error) {
	res, err := OpenmdbAPI("", "", title, year)
	if err != nil {
		fmt.Println(err)
		return nil, err
	}
	defer res.Body.Close()

	response := new(APIMovieResult)
	err = json.NewDecoder(res.Body).Decode(response)

	if err != nil {
		return nil, err
	}

	if response.Response == "False" {
		return response, errors.New(response.Error)
	}

	return response, nil
}

/*
*	Função para busca um filme especifico de uma dado imdb ID.
 */

func MovieByImdbID(imdbID string) (*APIMovieResult, error) {
	res, err := OpenmdbAPI("", imdbID, "", "")
	if err != nil {
		return nil, err
	}

	defer res.Body.Close()

	response := new(APIMovieResult)
	err = json.NewDecoder(res.Body).Decode(response)

	if err != nil {
		return nil, err
	}

	if response.Response == "False" {
		return response, errors.New(response.Error)
	}

	return response, nil
}
