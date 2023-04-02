package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {
	rand.Seed(time.Now().UnixNano()) // Usando seed com nanosegundos de agora (garante unicidade)

	var generatedNumbers []int // Criando estrutura para guardar numeros gerados
	for {
		randomNumber := rand.Int()
		generatedNumbers = append(generatedNumbers, randomNumber)

		if randomNumber%42 == 0 { // Validando divisibilidade do numero gerado
			break
		}
	}

	for _, v := range generatedNumbers { // Lendo números coletados e usando o blank identifier
		fmt.Println(v)
	}

	fmt.Printf("Fim após %d iterações", len(generatedNumbers))
}
