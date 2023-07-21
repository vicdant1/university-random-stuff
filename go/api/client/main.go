package main

import (
	"errors"
	"fmt"
	"go-movies/client/principal"
	"os"
)

func main() {
	fmt.Println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=* GO MOVIES =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*")

	// Mantendo execução em loop para possibilitar múltiplos cálculos
	for {
		// Exibindo as opções de operação
		displayOperationList()

		// Capturando a resposta do usuário sobre o que fazer
		choose := getUserInput()

		// Direcionando a execução do programa de acordo com a resposta do usuário
		switchUserChoose(choose)
	}
}

// Função responsável pela disposição da informação sobre as operações disponíveis
func displayOperationList() {
	fmt.Println("Operações disponíveis:")
	fmt.Println("1 - Listar filmes salvos")
	fmt.Println("2 - Localizar filme (por ID)")
	fmt.Println("3 - Criar novo filme")
	fmt.Println("4 - Atualizar filme")
	fmt.Println("5 - Deletar filme")
	fmt.Println("6 - Pesquisar único filme no OpenMbd")
	fmt.Println("0 - Sair")
}

// Função responsável por forçar a resposta válida do usuário
func getUserInput() int {
	choose := -1 // Atribuição padrão - nenhuma das alternativas se encaixa como -1
	for {
		var err error
		choose, err = getUserChoose()

		// Validação de erro emitido pela função de captura
		if err != nil {
			fmt.Println(err.Error())
		} else {
			break
		}
	}
	return choose
}

func getUserChoose() (choose int, err error) {
	fmt.Print("Digite a sua opção: ")
	fmt.Scanf("%d\n", &choose)

	// Validação das alternativas (entre 0 e 6)
	if choose < 0 || choose > 6 {
		// Retornando novo erro para validação na pilha de chamada
		return -1, errors.New("Informe uma opção válida [0-6]")
	}

	return choose, nil
}

/*
*	Função que direciona a execução do programa
*	de acordo com a resposta do usuário para a operação
*	desejada
 */
func switchUserChoose(choose int) {
	switch choose {
	// Caso especial: finalização de programa através de os.Exit()
	case 0:
		fmt.Println("Finalizando execução")
		os.Exit(0)
	case 1:
		principal.ListSavedMovies()
	case 2:
		principal.GetMovieById()
	case 3:
		principal.CreateMovie()
	case 4:
		principal.UpdateMovie()
	case 5:
		principal.DeleteMovie()
	case 6:
		principal.GetMovieOpenMbd()
	}

	fmt.Println()
}
