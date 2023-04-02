package main

import "fmt"

// Inicialmente implementei com map[int]int, mas como a ordenação ao final faria diferença, alterei a solução.
func main() {
	// Criando recorte de elementos e resultados
	elements := [...]int{98, 76, 68, 76, 76, 48, 73, 16, 16, 99}
	result := []int{}

	// Iterando sobre elementos e validando o resultado já contem o elemento
	for _, v := range elements {
		if !contains(result, v) { // Caso o resultado ainda não tenha o elemento, inserir
			result = append(result, v)
		}
	}

	// Printando resultados finais
	fmt.Println(elements)
	fmt.Println(result)
}

// Checando se a lista ja contém o elemento
func contains(list []int, value int) (result bool) {
	result = false
	for _, v := range list {
		if v == value {
			result = true
		}
	}
	return
}
