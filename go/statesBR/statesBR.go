package main

import (
	"bufio"
	"encoding/csv"
	"fmt"
	"os"
	"strconv"
	"strings"
)

// Definindo struct de state para armazenar as informações lidas do csv
type State struct {
	Name            string
	Acronymn        string
	Region          string
	Capital         string
	PopulationCount int
}

func main() {
	// Criando mapa para comportar informações dos estados linkando nome para struct
	states := make(map[string]State)

	// Abrindo arquivo e validando se a abertura deu certo
	f, err := os.Open("./estados.csv")
	defer f.Close()

	if err != nil {
		fmt.Println("Não foi possível acessar os dados dos estados: " + err.Error())
	}

	// Lendo csv
	csvReader := csv.NewReader(f)
	data, err := csvReader.ReadAll()

	// Validando erros na leitura do csv
	if err != nil {
		fmt.Println("Não foi possível ler o arquivo de estados: " + err.Error())
	}

	// Mapeando dados do csv para dentro da minha estrutura
	mapStatesData(data, &states)

	// Iniciando loop infinito para coletar as perguntas
	fmt.Println("Faça sua pergunta relativa aos estados do Brasil!\nDigite \"sair\" para encerrar.")
	for {
		// Lendo pergunta do usuário, tentei fazer com fmt.Scanln(&question) mas so lia até o primeiro espaço em branco
		var question string
		fmt.Print(">> ")

		// Decidi usar bufio
		scanner := bufio.NewScanner(os.Stdin)
		scanner.Scan()
		question = scanner.Text()
		var state string

		// Separando fluxo de execução de acordo com a pergunta do usuário
		switch {
		case strings.Contains(question, "região"):
			state = extractState(question, true)
			fmt.Println("- ", states[state].Region)
			break
		case strings.Contains(question, "capital"):
			state = extractState(question, false)
			fmt.Println("- ", states[state].Capital)
			break
		case strings.Contains(question, "população"):
			state = extractState(question, false)
			fmt.Printf("- %d habitantes\n", states[state].PopulationCount)
			break
		case strings.Contains(question, "sigla"):
			state = extractState(question, false)
			fmt.Println("- ", states[state].Acronymn)
			break
		case strings.Contains(question, "sair"):
			os.Exit(0)
		default:
			fmt.Println("Pergunta fora do formato adequado, tente novamente.")
		}
	}
}

// Função criada para extrair o nome do estado e posteriormente usar o mesmo como chave do mapa
func extractState(question string, differentFormat bool) (state string) {

	if differentFormat {
		finalIndex := strings.Index(question, "?") - 17
		firstIndex := strings.Index(question, "região") + 8
		state = strings.TrimSpace(question[firstIndex:finalIndex])
	} else {
		finalIndex := strings.Index(question, "?")
		firstIndex := strings.Index(question, "de") + 3

		state = strings.TrimSpace(question[firstIndex:finalIndex])
	}

	return
}

// Função criada para mapear os dados do csv para minha estrutura de dados
func mapStatesData(data [][]string, states *map[string]State) {
	for index, row := range data {
		if index == 0 {
			continue
		}

		name := row[0]
		populationCount, _ := strconv.Atoi(row[4])

		state := State{
			Name:            name,
			Acronymn:        row[1],
			Region:          row[2],
			Capital:         row[3],
			PopulationCount: populationCount,
		}

		(*states)[name] = state
	}
}
