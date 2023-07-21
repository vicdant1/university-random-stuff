package main

import (
	"go-movies/api"
	"log"
	"net/http"

	"github.com/gorilla/mux"
)

func main() {
	router := mux.NewRouter()
	router.HandleFunc("/go-movies", api.MyMovies).Methods("GET")
	router.HandleFunc("/go-movies/{id}", api.MyMoviebyID).Methods("GET")
	router.HandleFunc("/go-movies", api.CreateMovie).Methods("POST")
	router.HandleFunc("/go-movies/{id}", api.UpdateMovie).Methods("PUT")
	router.HandleFunc("/go-movies/{id}", api.DeleteMovie).Methods("DELETE")

	/*API externa*/
	router.HandleFunc("/go-movies/", api.GetMovieOpenMbd).Methods("GET").Queries("title", "", "year", "{year:[0-9]*}")

	log.Println("Starting server at port 8000")
	log.Fatal(http.ListenAndServe(":8000", router))
}
