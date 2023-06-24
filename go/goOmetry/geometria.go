package main

import (
	"errors"
	"fmt"
	"geometria/area"
	"geometria/perimetro"
	"geometria/volume"
	"os"
)

func main() {
	fmt.Println("Calculadora de Geometria Plana e Espacial")

	// Mantendo execução em loop para possibilitar múltiplos cálculos
	for {
		// Exibindo as opções de cálculo
		displayCalcOptions()
		// Capturando a resposta do usuário sobre o que calcular
		choose := getUserInput()
		// Direcionando a execução do programa de acordo com a resposta do usuário
		switchUserChoose(choose)
	}
}

// Função que direciona a execução do programa de acordo com a resposta do usuário para o cálculo desejado
func switchUserChoose(choose int) {
	switch choose {
	// Caso especial: finalização de programa através de os.Exit()
	case 0:
		fmt.Println("Finalizando execução")
		os.Exit(0)
		break
	case 1:
		getTriangleInfo()
		break
	case 2:
		getRectangleInfo()
		break
	case 3:
		getSquareInfo()
		break
	case 4:
		getCircleInfo()
		break
	case 5:
		getPyramidInfo()
		break
	case 6:
		getCubeInfo()
		break
	case 7:
		getParallelepipedInfo()
		break
	case 8:
		getBallInfo()
		break
	}

	fmt.Println()
}

// Função responsável por capturar os dados necessários para os cálculos da Esfera e mostrar essa informação ao usuário
func getBallInfo() {
	var radius float32

	fmt.Print("Digite o tamanho do raio da esfera: ")
	fmt.Scanf("%f\n", &radius)

	area := area.Esfera(radius)
	volume := volume.Esfera(radius)

	fmt.Printf("Área da esfera: %.2f\n", area)
	fmt.Printf("Volume da esfera: %.2f\n", volume)
}

// Função responsável por capturar os dados necessários para os cálculos do Paralelepipedo e mostrar essa informação ao usuário
func getParallelepipedInfo() {
	var edge1 float32
	var edge2 float32
	var edge3 float32

	fmt.Print("Digite o tamanho da primeira aresta: ")
	fmt.Scanf("%f\n", &edge1)

	fmt.Print("Digite o tamanho da segunda aresta: ")
	fmt.Scanf("%f\n", &edge2)

	fmt.Print("Digite o tamanho da terceira aresta: ")
	fmt.Scanf("%f\n", &edge3)

	area := area.Paralelepipedo(edge1, edge2, edge3)
	volume := volume.Paralelepipedo(edge1, edge2, edge3)

	fmt.Printf("Área do paralelepípedo: %.2f\n", area)
	fmt.Printf("Volume do paralelepípedo: %.2f\n", volume)
}

// Função responsável por capturar os dados necessários para os cálculos do Cubo e mostrar essa informação ao usuário
func getCubeInfo() {
	var edge float32

	fmt.Print("Digite o tamanho da aresta do cubo: ")
	fmt.Scanf("%f\n", &edge)

	area := area.Cubo(edge)
	volume := volume.Cubo(edge)

	fmt.Printf("Área do cubo: %.2f\n", area)
	fmt.Printf("Volume do cubo: %.2f\n", volume)
}

// Função responsável por capturar os dados necessários para os cálculos de Pirâmides e mostrar essa informação ao usuário
func getPyramidInfo() {
	var base float32
	var height float32

	fmt.Print("Digite o tamanho da base da pirâmide: ")
	fmt.Scanf("%f\n", &base)

	fmt.Print("Digite o tamanho da altura da pirâmide: ")
	fmt.Scanf("%f\n", &height)

	area := area.Piramide(base, height)
	volume := volume.Piramide(base, height)

	fmt.Printf("Área da pirâmide: %.2f\n", area)
	fmt.Printf("Volume da pirâmide: %.2f\n", volume)
}

// Função responsável por capturar os dados necessários para os cálculos de Círculos e mostrar essa informação ao usuário
func getCircleInfo() {
	var radius float32

	fmt.Print("Digite o tamanho do raio do círculo: ")
	fmt.Scanf("%f\n", &radius)

	area := area.Circulo(radius)
	circLength := perimetro.Circulo(radius)

	fmt.Printf("Área do círculo: %.2f\n", area)
	fmt.Printf("Comprimento de circunferência: %.2f\n", circLength)
}

// Função responsável por capturar os dados necessários para os cálculos de Quadrados e mostrar essa informação ao usuário
func getSquareInfo() {
	var side float32

	fmt.Print("Digite o tamanho do lado do quadrado: ")
	fmt.Scanf("%f\n", &side)

	area := area.Quadrado(side)
	perimeter := perimetro.Quadrado(side)

	fmt.Printf("Área do quadrado: %.2f\n", area)
	fmt.Printf("Perímetro do quadrado: %.2f\n", perimeter)
}

// Função responsável por capturar os dados necessários para os cálculos de Triângulos e mostrar essa informação ao usuário
func getTriangleInfo() {
	var base float32

	fmt.Print("Digite o tamanho da base do triângulo: ")
	fmt.Scanf("%f\n", &base)

	area := area.Triangulo(base)
	perimeter := perimetro.Triangulo(base)

	fmt.Printf("Área do triângulo: %.2f\n", area)
	fmt.Printf("Perímetro do triângulo: %.2f\n", perimeter)
}

// Função responsável por capturar os dados necessários para os cálculos de Retângulos e mostrar essa informação ao usuário
func getRectangleInfo() {
	var base float32
	var height float32

	fmt.Print("Digite o tamanho da base do retângulo: ")
	fmt.Scanf("%f\n", &base)

	fmt.Print("Digite o tamanho da altura do retângulo: ")
	fmt.Scanf("%f\n", &height)

	area := area.Retangulo(base, height)
	perimeter := perimetro.Retangulo(base, height)

	fmt.Printf("Área do retângulo: %.2f\n", area)
	fmt.Printf("Perímetro do retângulo: %.2f\n", perimeter)

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

// Função responsável por capturar a resposta do usuário
func getUserChoose() (choose int, err error) {
	fmt.Print("Digite a sua opção: ")
	fmt.Scanf("%d\n", &choose)

	// Validação das alternativas (entre 0 e 8)
	if choose < 0 || choose > 8 {
		// Retornando novo erro para validação na pilha de chamada
		return -1, errors.New("Informe uma opção válida [0-8]")
	}

	return choose, nil
}

// Função responsável pela disposição da informação sobre as operações disponíveis
func displayCalcOptions() {
	fmt.Println("(1) Triângulo equilatero")
	fmt.Println("(2) Retângulo")
	fmt.Println("(3) Quadrado")
	fmt.Println("(4) Círculo")
	fmt.Println("(5) Pirâmide com base quadrangular")
	fmt.Println("(6) Cubo")
	fmt.Println("(7) Paralelepípedo")
	fmt.Println("(8) Esfera")
	fmt.Println("(0) Sair")
}
