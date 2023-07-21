package api

import (
	"bytes"
	"encoding/json"
	"go-movies/openmdb"
	"io/ioutil"
	"net/http"
	"net/http/httptest"
	"testing"
)

func TestMyMoviesEmptySet(t *testing.T) {
	// Cria servidor http de teste
	server := httptest.NewServer(http.HandlerFunc(MyMovies))
	defer server.Close()

	// Faz a requisição para o servidor de teste
	resp, err := http.Get(server.URL)
	if err != nil {
		t.Fatalf("Falha ao enviar Get request: %s", err)
	}
	defer resp.Body.Close()

	// Verifica o status code da resposta
	if resp.StatusCode != http.StatusNoContent {
		t.Errorf("Status esperado %d, status obtido %d", http.StatusNoContent, resp.StatusCode)
	}

	// Validação de body
	expectedResponseBody := ""
	actualResponseBody := readResponseBody(resp)
	if actualResponseBody != expectedResponseBody {
		t.Errorf("Corpo esperado %q, corpo obtido %q", expectedResponseBody, actualResponseBody)
	}
}

func TestMyMoviesLoadedSet(t *testing.T) {

	// Criando body de teste
	requestBody := []byte(`{"title":"Barbie","director":"TestDirector", "imdbid": "123"}`)

	// Criando requisição POST
	req, err := http.NewRequest("POST", "/go-movies", bytes.NewBuffer(requestBody))
	if err != nil {
		t.Fatalf("Falha ao criar requisição: %s", err)
	}

	// Criando recorder para capturar resposta
	recorder := httptest.NewRecorder()

	// Chamando função alvo de teste
	CreateMovie(recorder, req)

	// Cria servidor http de teste
	server := httptest.NewServer(http.HandlerFunc(MyMovies))
	defer server.Close()
	defer recorder.Flush()
	// Faz a requisição para o servidor de teste
	resp, err := http.Get(server.URL)
	if err != nil {
		t.Fatalf("Falha ao enviar Get request: %s", err)
	}
	defer resp.Body.Close()

	// Verifica o status code da resposta
	if resp.StatusCode != http.StatusOK {
		t.Errorf("Status esperado %d, status obtido %d", http.StatusOK, resp.StatusCode)
	}

	// Validação de body
	expectedResponseBody := "[{\"id\":\"3\",\"imdbid\":\"123\",\"title\":\"Barbie\",\"year\":\"\",\"released\":\"\",\"genre\":\"\",\"director\":\"TestDirector\",\"plot\":\"\",\"poster\":\"\",\"rating_imdb\":\"\",\"type\":\"\",\"rating_tomatoes\":\"\",\"user_rating_tomatoes\":\"\",\"response\":\"\",\"error\":\"\"}]\n"
	actualResponseBody := readResponseBody(resp)
	if actualResponseBody != expectedResponseBody {
		t.Errorf("Corpo esperado %q, corpo obtido %q", expectedResponseBody, actualResponseBody)
	}
}

func readResponseBody(resp *http.Response) string {
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		return ""
	}

	// Retorna o body como string
	return string(body)
}

func TestCreateMovie(t *testing.T) {
	// Criando body de teste
	requestBody := []byte(`{"title":"Inception","director":"Christopher Nolan"}`)

	// Criando requisição POST
	req, err := http.NewRequest("POST", "/go-movies", bytes.NewBuffer(requestBody))
	if err != nil {
		t.Fatalf("Falha ao criar requisição: %s", err)
	}

	// Criando recorder para capturar resposta
	recorder := httptest.NewRecorder()

	// Chamando função alvo de teste
	CreateMovie(recorder, req)

	// Recuperando resposta da função
	resp := recorder.Result()

	// Verifica o status code da resposta
	if resp.StatusCode != http.StatusCreated {
		t.Errorf("Status esperado %d, status obtido %d", http.StatusCreated, resp.StatusCode)
	}

	// Verificando content-type
	expectedContentType := "application/json"
	if contentType := resp.Header.Get("Content-Type"); contentType != expectedContentType {
		t.Errorf("Content-type esperado %q, obtido %q", expectedContentType, contentType)
	}

	// Read the response body
	var responseBody openmdb.APIMovieResult
	err = json.NewDecoder(resp.Body).Decode(&responseBody)
	if err != nil {
		t.Fatalf("Falha ao ler body da resposta: %s", err)
	}
	// Example assertion: Verify the created movie details
	expectedMovie := openmdb.APIMovieResult{
		ID:       "4",
		Title:    "Inception",
		Director: "Christopher Nolan",
	}
	if responseBody != expectedMovie {
		t.Errorf("Filme esperado %+v, filme obtido %+v", expectedMovie, responseBody)
	}
}

func TestCreateMovieError(t *testing.T) {
	// Criando body de teste
	requestBody := []byte(`asdfasdf`)

	// Criando requisição POST
	req, err := http.NewRequest("POST", "/go-movies", bytes.NewBuffer(requestBody))
	if err != nil {
		t.Fatalf("Falha ao criar requisição: %s", err)
	}

	// Criando recorder para capturar resposta
	recorder := httptest.NewRecorder()

	// Chamando função alvo de teste
	CreateMovie(recorder, req)

	// Recuperando resposta da função
	resp := recorder.Result()

	// Verifica o status code da resposta
	if resp.StatusCode != http.StatusBadRequest {
		t.Errorf("Status esperado %d, status obtido %d", http.StatusBadRequest, resp.StatusCode)
	}

}

func TestCreateMovieConflict(t *testing.T) {
	// Criando body de teste
	requestBody := []byte(`{"title":"Inception","director":"Christopher Nolan"}`)

	// Criando requisição POST
	req, err := http.NewRequest("POST", "/go-movies", bytes.NewBuffer(requestBody))
	if err != nil {
		t.Fatalf("Falha ao criar requisição: %s", err)
	}

	// Criando recorder para capturar resposta
	recorder := httptest.NewRecorder()

	// Chamando função alvo de teste
	CreateMovie(recorder, req)

	// Recuperando resposta da função
	resp := recorder.Result()

	// Verifica o status code da resposta
	if resp.StatusCode != http.StatusConflict {
		t.Errorf("Status esperado %d, status obtido %d", http.StatusConflict, resp.StatusCode)
	}

}

func TestMyMoviebyIDLoadedSet(t *testing.T) {

	server := httptest.NewServer(http.HandlerFunc(MyMoviebyID))
	defer server.Close()

	// Faz a requisição para o servidor de teste
	resp, err := http.Get(server.URL + "/0")

	if err != nil {
		t.Fatalf("Falha ao enviar Get request: %s", err)
	}
	defer resp.Body.Close()

	// Verifica o status code da resposta
	if resp.StatusCode != http.StatusNotFound {
		t.Errorf("Status esperado %d, status obtido %d", http.StatusNotFound, resp.StatusCode)
	}

	// Validação de body
	expectedResponseBody := "Not Found\n"
	actualResponseBody := readResponseBody(resp)
	if actualResponseBody != expectedResponseBody {
		t.Errorf("Corpo esperado %q, corpo obtido %q", expectedResponseBody, actualResponseBody)
	}
}

func TestMyMoviebyIDEmptySet(t *testing.T) {
	// Cria servidor http de teste
	server := httptest.NewServer(http.HandlerFunc(MyMoviebyID))
	defer server.Close()

	// Faz a requisição para o servidor de teste
	resp, err := http.Get(server.URL + "/55")
	if err != nil {
		t.Fatalf("Falha ao enviar Get request: %s", err)
	}
	defer resp.Body.Close()

	// Verifica o status code da resposta
	if resp.StatusCode != http.StatusNotFound {
		t.Errorf("Status esperado %d, status obtido %d", http.StatusNotFound, resp.StatusCode)
	}

	// Validação de body
	expectedResponseBody := "Not Found\n"
	actualResponseBody := readResponseBody(resp)
	if actualResponseBody != expectedResponseBody {
		t.Errorf("Corpo esperado %q, corpo obtido %q", expectedResponseBody, actualResponseBody)
	}
}

func TestUpdateMovie(t *testing.T) {
	// Criar um mock do corpo da requisição
	// Neste exemplo, estamos apenas atualizando o título do filme
	requestBody := []byte(`{"title":"Novo Título"}`)

	// Criar um novo pedido PUT com o corpo da requisição
	req, err := http.NewRequest("PUT", "/go-movies/3", bytes.NewBuffer(requestBody))
	if err != nil {
		t.Fatalf("Falha ao criar o pedido: %s", err)
	}

	// Criar um registro de resposta para capturar a resposta
	recorder := httptest.NewRecorder()

	// Chamar a função handler UpdateMovie com o registro de resposta e o pedido
	UpdateMovie(recorder, req)

	// Obter a resposta do registro
	resp := recorder.Result()

	// Não há filmes no contexto de teste, então foi avaliado o cenário onde o NotFound era aceitável
	// Verificar o código de status da resposta
	if resp.StatusCode != http.StatusNotFound {
		t.Errorf("Status esperado %d, obtido %d", http.StatusNotFound, resp.StatusCode)
	}

}

func TestUpdateMovieError(t *testing.T) {
	// Criar um mock do corpo da requisição
	// Neste exemplo, estamos apenas atualizando o título do filme
	requestBody := []byte(``)

	// Criar um novo pedido PUT com o corpo da requisição
	req, err := http.NewRequest("PUT", "/go-movies/0", bytes.NewBuffer(requestBody))
	if err != nil {
		t.Fatalf("Falha ao criar o pedido: %s", err)
	}

	// Criar um registro de resposta para capturar a resposta
	recorder := httptest.NewRecorder()

	// Chamar a função handler UpdateMovie com o registro de resposta e o pedido
	UpdateMovie(recorder, req)

	// Obter a resposta do registro
	resp := recorder.Result()

	// Não há filmes no contexto de teste, então foi avaliado o cenário onde o NotFound era aceitável
	// Verificar o código de status da resposta
	if resp.StatusCode != http.StatusBadRequest {
		t.Errorf("Status esperado %d, obtido %d", http.StatusBadRequest, resp.StatusCode)
	}

}

func TestDeleteMovieError(t *testing.T) {
	// Criar um pedido DELETE com um parâmetro de ID de exemplo
	req, err := http.NewRequest("DELETE", "/go-movies/3", nil)
	if err != nil {
		t.Fatalf("Falha ao criar o pedido: %s", err)
	}

	// Criar um registro de resposta para capturar a resposta
	recorder := httptest.NewRecorder()

	// Chamar a função handler DeleteMovie com o registro de resposta e o pedido
	DeleteMovie(recorder, req)

	// Obter a resposta do registro
	resp := recorder.Result()

	// Não há filmes no contexto de teste, então foi avaliado o cenário onde o NotFound era aceitável
	// Verificar o código de status da resposta
	if resp.StatusCode != http.StatusNotFound {
		t.Errorf("Status esperado %d, obtido %d", http.StatusNotFound, resp.StatusCode)
	}
}

func TestDeleteMovie(t *testing.T) {
	// Criar um pedido DELETE com um parâmetro de ID de exemplo
	req, err := http.NewRequest("DELETE", "/go-movies/0", nil)
	if err != nil {
		t.Fatalf("Falha ao criar o pedido: %s", err)
	}

	// Criar um registro de resposta para capturar a resposta
	recorder := httptest.NewRecorder()

	// Chamar a função handler DeleteMovie com o registro de resposta e o pedido
	DeleteMovie(recorder, req)

	// Obter a resposta do registro
	resp := recorder.Result()

	// Não há filmes no contexto de teste, então foi avaliado o cenário onde o NotFound era aceitável
	// Verificar o código de status da resposta
	if resp.StatusCode != http.StatusNotFound {
		t.Errorf("Status esperado %d, obtido %d", http.StatusNotFound, resp.StatusCode)
	}
}

func TestGetMovieOpenMbd(t *testing.T) {
	// Criar um pedido GET com os parâmetros de exemplo (título e ano)
	req, err := http.NewRequest("GET", "/go-movies/?title=Barbie&year=2023", nil)
	if err != nil {
		t.Fatalf("Falha ao criar o pedido: %s", err)
	}

	// Criar um registro de resposta para capturar a resposta
	recorder := httptest.NewRecorder()

	// Chamar a função handler GetMovieOpenMbd com o registro de resposta e o pedido
	GetMovieOpenMbd(recorder, req)

	// Obter a resposta do registro
	resp := recorder.Result()

	// Verificar o código de status da resposta
	if resp.StatusCode != http.StatusOK {
		t.Errorf("Status esperado %d, obtido %d", http.StatusOK, resp.StatusCode)
	}

	// Verificar o cabeçalho de tipo de conteúdo da resposta
	expectedContentType := "application/json"
	if contentType := resp.Header.Get("Content-Type"); contentType != expectedContentType {
		t.Errorf("Tipo de conteúdo esperado %q, obtido %q", expectedContentType, contentType)
	}

	// Ler o corpo da resposta
	var responseBody openmdb.APIMovieResult
	err = json.NewDecoder(resp.Body).Decode(&responseBody)
	if err != nil {
		t.Fatalf("Falha ao decodificar o corpo da resposta: %s", err)
	}

	if responseBody.Title != "Barbie" {
		t.Errorf("Título esperado %q, obtido %q", "Barbie", responseBody.Title)
	}

	if responseBody.Year != "2023" {
		t.Errorf("Título esperado %q, obtido %q", "2023", responseBody.Year)
	}

	if responseBody.Director != "Greta Gerwig" {
		t.Errorf("Título esperado %q, obtido %q", "Greta Gerwig", responseBody.Director)
	}
}

func TestGetMovieOpenMbdError(t *testing.T) {
	// Criar um pedido GET com os parâmetros de exemplo (título e ano)
	req, err := http.NewRequest("GET", "/go-movies/?title=Barbie&year=-123", nil)
	if err != nil {
		t.Fatalf("Falha ao criar o pedido: %s", err)
	}
	// Criar um registro de resposta para capturar a resposta
	recorder := httptest.NewRecorder()

	// Chamar a função handler GetMovieOpenMbd com o registro de resposta e o pedido
	GetMovieOpenMbd(recorder, req)

	// Obter a resposta do registro
	resp := recorder.Result()

	// Verificar o código de status da resposta
	if resp.StatusCode != http.StatusNotFound {
		t.Errorf("Status esperado %d, obtido %d", http.StatusNotFound, resp.StatusCode)
	}

}
