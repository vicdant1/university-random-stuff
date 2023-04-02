package main

import (
	"fmt"
	"sort"
)

func main() {
	// Criando estrutura para armazenar temperaturas °C - °F
	convertedValues := make(map[int]float32)

	// Alimentado a estrutura no range informado pela atividade
	for i := -40; i <= 100; i += 5 {
		convertedValues[i] = celsiusToFahrenheit(i)
	}

	drawTable(convertedValues, "ºC", "ºF")
}

func drawTable(convertedValues map[int]float32, firstColumn, secondColumn string) {
	// Pegando o maior valor da tabela
	var biggestConvertedValue float32 = 0
	for _, v := range convertedValues {
		if v > biggestConvertedValue {
			biggestConvertedValue = v
		}
	}

	// Determinando quantidade máxima de caracteres através do maior valor encontrado
	maxTableWidth := (len(fmt.Sprintf("%.1f", biggestConvertedValue))+3)*2 + 1

	// Determinando formatação da tabela
	fmtString := fmt.Sprintf("|%%%ds|%%%ds|\n", int((maxTableWidth-2)/2), int((maxTableWidth-2)/2))

	// Printando cabeçalho da tabela
	drawRow(maxTableWidth)
	fmt.Printf(fmtString, firstColumn, secondColumn)
	drawRow(maxTableWidth)

	// Ordenando chaves (mapas não são ordenados por natureza)
	keys := make([]int, 0, len(convertedValues))
	for index := range convertedValues {
		keys = append(keys, index)
	}
	sort.Ints(keys)

	// Formatando e printando resultados obtidos
	for _, index := range keys {
		formatedCelValue := fmt.Sprintf("%.1f", float32(index))
		formatedFahrValue := fmt.Sprintf("%.1f", convertedValues[index])
		fmt.Printf(fmtString, formatedCelValue, formatedFahrValue)
	}

	drawRow(maxTableWidth)
}

// Função criada para evitar repetição desnecessária de código
func drawRow(rowSize int) {
	for i := 0; i < rowSize; i++ {
		fmt.Print("=")
	}
	fmt.Println()
}

// Função com retorno nomeado para converter de °C para °F
func celsiusToFahrenheit(celsius int) (fahrenheit float32) {
	fahrenheit = (float32(celsius) * 1.8) + 32
	return
}
