package main

import (
	"fmt"
	"os"
	"strconv"
)

// Declarando constantes do programa
const minScore = 501
const goodScoreTaxRate = 0.15
const badScoreTaxRate = 0.20

func main() {

	// Declarando variáveis para leitura
	var score int
	var income float32
	var loanValue float32
	var monthsNumber int

	// Realizando leitura das variáveis
	readAndValidateUserInput(&score, &income, &loanValue, &monthsNumber)

	// Analisando situação do empréstimo
	err := analyzeLoanSituation(score, income, loanValue, monthsNumber)

	// Validando se houve algum erro durante a execução da análise e informando ao usuário
	if err != nil {
		fmt.Printf("Não foi possível realizar o cálculo, motivo: " + err.Error())
	}
}

// Função que lê e valida o input do usuário
func readAndValidateUserInput(score *int, income *float32, loanValue *float32, monthsNumber *int) {
	fmt.Println("=========== Calculadora de Empréstimos ===========")
	fmt.Print("Score de crédito: ")
	_, err := fmt.Scanf("%d\n", score)
	if err != nil {
		logError((err))
	}

	fmt.Print("Renda: ")
	_, err = fmt.Scanf("%f\n", income)
	if err != nil {
		logError(err)
	}

	fmt.Print("Valor desejado: ")
	_, err = fmt.Scanf("%f\n", loanValue)
	if err != nil {
		logError(err)
	}

	fmt.Print("Tempo do empréstimo: ")
	_, err = fmt.Scanf("%d\n", monthsNumber)
	if err != nil {
		logError(err)
	}

	// Fazendo validação da regra de negócio especificada
	if *monthsNumber%12 != 0 {
		logError(fmt.Errorf("Quantidade de meses inválida, informe um número divisível por 12."))
	}
}

func analyzeLoanSituation(score int, income float32, loanValue float32, monthsNumber int) error {

	var userLoanTax float32

	// Validando score de acordo com a regra de negócio
	if score >= 501 { // Tem score bom
		userLoanTax = goodScoreTaxRate
	} else { // Não tem score bom
		userLoanTax = badScoreTaxRate
	}

	// Calculando valores de parcela e custo efetivo
	monthlyPayment := calcMonthlyPayment(loanValue, userLoanTax, monthsNumber)
	effectiveCost := calcEffectiveCost(monthlyPayment, loanValue, monthsNumber)

	// Validando se o empréstimo foi aprovado
	aprovedLoan := checkLoanRequestStatus(income, monthlyPayment, score)

	// Mostrando resultado da análise ao usuário
	displayLoanAnalysisResult(score, income, loanValue, monthsNumber, monthlyPayment, userLoanTax, effectiveCost, aprovedLoan)

	return nil
}

func displayLoanAnalysisResult(score int, income, loanValue float32, monthsNumber int, monthlyPayment, userLoanTax, effectiveCost float32, aprovedLoan bool) {

	var loanSituation string

	// Personalizando mensagem de acordo com a situação da análise
	if aprovedLoan {
		loanSituation = "APROVADO"
	} else {
		loanSituation = "RECUSADO"
	}

	fmt.Println("----------------------------------")
	fmt.Println("Análise de crédito para empréstimo")
	fmt.Println("----------------------------------")

	// Criando saída formatada para o usuário
	outputFormat := "%-30s%s\n"
	fmt.Printf(outputFormat, "Score de crédito: ", strconv.Itoa(score))
	fmt.Printf(outputFormat, "Renda: ", fmt.Sprintf("%.2f", income))
	fmt.Printf(outputFormat, "Valor do empréstimo: ", fmt.Sprintf("%.2f", loanValue))
	fmt.Printf(outputFormat, "Tempo do empréstimo: ", strconv.Itoa(monthsNumber))
	fmt.Printf(outputFormat, "Valor mensal de parcela: ", fmt.Sprintf("%.2f", monthlyPayment))
	fmt.Printf(outputFormat, "Taxa de juros: ", fmt.Sprintf("%.0f%%", userLoanTax*100))
	fmt.Printf(outputFormat, "Custo efetivo: ", fmt.Sprintf("%.2f", effectiveCost))
	fmt.Printf(outputFormat, "Situação do empréstimo: ", loanSituation)
}

func checkLoanRequestStatus(income, monthlyPayment float32, score int) (aprovedLoan bool) {
	// Validando de acordo com a regra de negócio
	aprovedLoan = false
	if income > monthlyPayment && score >= 501 && income*0.20 >= monthlyPayment {
		aprovedLoan = true
	}

	return
}

func calcEffectiveCost(monthlyPayment, loanValue float32, monthsNumber int) (effectiveCost float32) {
	effectiveCost = 0
	effectiveCost = (monthlyPayment * float32(monthsNumber)) - loanValue

	return
}

func calcMonthlyPayment(loanValue, userLoanTax float32, monthsNumber int) (montlyPayment float32) {
	// Calculando de acordo com a regra de negócio
	montlyPayment = 0
	montlyPayment = ((loanValue * userLoanTax) / float32(monthsNumber)) + (loanValue / float32(monthsNumber))

	return
}

// Função criada para evitar repetição desnecessária de código
func logError(err error) {
	fmt.Println("Falha na execução: " + err.Error())
	os.Exit(0)
}
