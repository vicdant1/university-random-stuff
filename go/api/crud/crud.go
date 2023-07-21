package crud

import (
	"go-movies/openmdb"
	"net/http"
	"strconv"
)

/*Criação de uma variável global para salvar os filmes localmente - sem persistência*/

var movies []openmdb.APIMovieResult
var id = 3

func init() {
	movies = []openmdb.APIMovieResult{}
}

/*
*	Listar todos os filmes salvos no array
 */
func GetMovies() ([]openmdb.APIMovieResult, int) {
	if len(movies) == 0 {
		return movies, http.StatusNoContent
	}
	return movies, http.StatusOK
}

/*
*	Retorna o filme pelo id
 */
func GetMovie(id string) (openmdb.APIMovieResult, int) {
	for _, m := range movies {
		if m.ID == id {
			return m, http.StatusFound
		}
	}
	var movie openmdb.APIMovieResult
	return movie, http.StatusNotFound
}

/*
*	Adicionar novo filme
 */
func CreateMovie(newMovie openmdb.APIMovieResult) (openmdb.APIMovieResult, int) {
	//Verificação se já existe um filme com o mesmo imdb salvo
	for _, movie := range movies {
		if newMovie.ImdbID == movie.ImdbID {
			return movie, http.StatusConflict
		}
	}
	newMovie.ID = strconv.Itoa(id)
	id++
	movies = append(movies, newMovie)
	return newMovie, http.StatusCreated

}

/*
*	Apagar filme da lista pelo id
 */
func DeleteMovie(id string) int {
	for i, movie := range movies {
		if movie.ID == id {
			movies = append(movies[:i], movies[i+1:]...)
			return http.StatusOK
		}
	}
	return http.StatusNotFound
}

/*
*	Atualizar filme
 */
func UpdateMovie(id string, updatedMovie openmdb.APIMovieResult) int {
	updatedMovie.ID = id
	for i, movie := range movies {
		if movie.ID == id {
			movies[i] = updatedMovie
			return http.StatusAccepted
		}
	}
	return http.StatusNotFound
}
