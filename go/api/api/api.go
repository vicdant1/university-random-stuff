package api

import (
	"encoding/json"
	"go-movies/crud"
	"go-movies/openmdb"
	"net/http"

	"github.com/gorilla/mux"
)

/*
*	Retorna os filmes salvo localmente
 */
func MyMovies(writer http.ResponseWriter, req *http.Request) {
	writer.Header().Set("Content-Type", "application/json")
	movies, err := crud.GetMovies()
	if err != http.StatusOK {
		http.Error(writer, http.StatusText(http.StatusNoContent), http.StatusNoContent)
		return
	}
	writer.WriteHeader(http.StatusOK)
	json.NewEncoder(writer).Encode(movies)
}

/*
*	Retorna o filme salvo localmente baseado no ID
 */
func MyMoviebyID(writer http.ResponseWriter, req *http.Request) {
	writer.Header().Set("Content-Type", "application/json")
	id := mux.Vars(req)["id"]
	movies, _ := crud.GetMovies()
	for _, movie := range movies {
		if movie.ID == id {

			writer.WriteHeader(http.StatusOK)
			json.NewEncoder(writer).Encode(movie)
			return
		}
	}
	http.Error(writer, http.StatusText(http.StatusNotFound), http.StatusNotFound)
}

/*
*	Salvo o novo filme, que é passado pelo body
 */
func CreateMovie(writer http.ResponseWriter, req *http.Request) {
	writer.Header().Set("Content-Type", "application/json")
	var movie openmdb.APIMovieResult
	err := json.NewDecoder(req.Body).Decode(&movie)
	if err != nil {
		http.Error(writer, err.Error(), http.StatusBadRequest)
		return
	}
	new_movie, status := crud.CreateMovie(movie)
	if status != http.StatusCreated {
		http.Error(writer, http.StatusText(http.StatusConflict), http.StatusConflict)
		return
	}
	writer.WriteHeader(http.StatusCreated)
	json.NewEncoder(writer).Encode(new_movie)
}

/*
*	Atualizar informações do filme de acordo com o id passado
 */
func UpdateMovie(writer http.ResponseWriter, req *http.Request) {
	writer.Header().Set("Content-Type", "application/json")
	id := mux.Vars(req)["id"]
	var updatedMovie openmdb.APIMovieResult
	err := json.NewDecoder(req.Body).Decode(&updatedMovie)
	if err != nil {
		http.Error(writer, http.StatusText(http.StatusBadRequest), http.StatusBadRequest)
		return
	}

	status := crud.UpdateMovie(id, updatedMovie)
	if status != http.StatusAccepted {
		http.Error(writer, http.StatusText(http.StatusNotFound), http.StatusNotFound)
		return
	}
	writer.WriteHeader(http.StatusAccepted)
	json.NewEncoder(writer).Encode(updatedMovie)
}

/*
*	Deleta o filme pelo id
 */
func DeleteMovie(writer http.ResponseWriter, req *http.Request) {
	writer.Header().Set("Content-Type", "application/json")
	id := mux.Vars(req)["id"]
	status := crud.DeleteMovie(id)
	if status != http.StatusOK {
		http.Error(writer, http.StatusText(http.StatusNotFound), http.StatusNotFound)
		return
	}
	writer.WriteHeader(http.StatusOK)
}

/* =====================================================
*	Consulta a API externa
*  =====================================================
 */

/*
* Pesquisa um filme especifico baseado no seu titulo e ano
 */
func GetMovieOpenMbd(writer http.ResponseWriter, req *http.Request) {
	writer.Header().Set("Content-Type", "application/json")
	title := req.URL.Query().Get("title")
	year := ""
	if req.URL.Query().Get("year") != "" {
		year = req.URL.Query().Get("year")
	}
	movie, err := openmdb.MovieByTitle(title, year)
	if err != nil {
		http.Error(writer, http.StatusText(http.StatusNotFound), http.StatusNotFound)
		return
	}
	writer.WriteHeader(http.StatusOK)
	json.NewEncoder(writer).Encode(movie)
}
