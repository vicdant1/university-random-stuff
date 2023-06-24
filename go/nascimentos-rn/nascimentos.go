package main

import (
	"bufio"
	"encoding/csv"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

// Definição dos tipos utilizados pela aplicação
type Year struct {
	Year  int // Ano do registro
	Borns int // Quantidade de nascimentos no ano
}

type City struct {
	Code  string // Código da cidade
	Name  string // Nome da cidade
	Years []Year // Lista de anos com a quantidade de nascimentos
	Total int    // Total de nascimentos registrados na cidade
}

type Statistics struct {
	Cities      []City // Lista de cidades com seus dados
	TotalBorns  int    // Total de nascimentos registrados no arquivo
	BornsByYear []Year // Lista com a quantidade de nascimentos por ano
}

func main() {
	// Leitura do arquivo de dados
	data := readFile()

	// Interpretação dos dados e conversão para uma estrutura de estatísticas
	statistics := interpretData(data)

	// Verifica a integridade do arquivo (se a soma dos dados bate com o total)
	validateFileIntegrity(statistics)

	// Cálculo do número de nascimentos mais comum por ano
	mostBornNumberByYear := getMostBornNumberByYear(statistics)

	// Cálculo do número de nascimentos menos comum por ano
	lessBornNumberByYear := getLessNumberByYear(statistics)

	// Cálculo da taxa de natalidade por ano
	bornRateByYear := getBornRateByYear(statistics)

	// Cálculo do desvio padrão da quantidade de nascimentos por ano
	deviation := getStandartDeviationByYear(statistics)

	// Criação e preenchimento do arquivo CSV de saída
	createAndSeedCsvFile(statistics, mostBornNumberByYear, lessBornNumberByYear, bornRateByYear, deviation)

	// Criação e preenchimento do arquivo DAT de saída
	createAndSeedDatFile(statistics)

	// Criação e preenchimento do arquivo TXT de saída
	createAndGenerateTargetBornsFile(statistics)

	// Cálculo da taxa de crescimento das cidades
	calculateCitiesGrowTax(statistics)
}

func readFile() [][]string {

	// Valida se arquivo foi passado na linha de comando
	if len(os.Args) == 1 {
		fmt.Println("É necessário informar o arquivo alvo de processamento.")
		os.Exit(1)
	}

	// Abre o arquivo
	filename := os.Args[1]
	file, err := os.Open(filename)
	defer file.Close()

	if err != nil {
		fmt.Println("Error opening file")
		os.Exit(1)
	}

	// Realiza leitura do arquivo
	csvReader := csv.NewReader(file)
	data, err := csvReader.ReadAll()

	// Valida erro da leitura
	if err != nil {
		fmt.Println("Error reading file")
		os.Exit(1)
	}

	return data
}

func interpretData(data [][]string) Statistics {

	var cities []City
	totalBorns := 0
	var bornsByYear []Year

	totalYears := 0
	var headerData []string

	// Percorre as linhas do csv para armazenar as informações
	for _, row := range data {

		// Skipando header
		if totalYears == 0 {
			headerData = row          // Armazenando conteúdo do header para utilização posterior
			totalYears = len(row) - 2 // Armazenando quantidade de anos da série
			continue
		}

		// Validando se a linha lida é a totalizadora
		isTotalRow := strings.ToLower(row[0]) == "total"
		var cityCode string
		var cityName string

		// Preenchendo informações de nome e código da cidade
		if !isTotalRow {
			cityCode = strings.Split(row[0], " ")[0]
			cityName = strings.TrimSpace(strings.ReplaceAll(row[0], cityCode, ""))
		}

		// Preenchendo informações dos anos de cada cidade
		var years []Year
		for i := 1; i <= totalYears; i++ {
			year, _ := strconv.Atoi(headerData[i])
			borns, _ := strconv.Atoi(row[i])

			years = append(years, Year{Year: year, Borns: borns})
		}

		totalYearBorns, _ := strconv.Atoi(row[totalYears+1])

		// Armazenando total de nascimentos geral
		if isTotalRow {
			totalBorns = totalYearBorns
			bornsByYear = years
			continue
		}

		// Criando registro da cidade lida
		cityRegister := City{
			Code:  cityCode,
			Name:  cityName,
			Years: years,
			Total: totalYearBorns,
		}

		// Inserindo registro da cidade lida nas cidades
		cities = append(cities, cityRegister)
	}

	// Criando Statistics (estrutura para armazenar os dados de modo geral)
	statistics := Statistics{
		Cities:      cities,
		TotalBorns:  totalBorns,
		BornsByYear: bornsByYear,
	}

	return statistics
}

func validateFileIntegrity(statistics Statistics) {
	var totalBorns int

	// Criando mapa para dados de comparação
	contrastData := make(map[int]int)
	for _, city := range statistics.Cities {
		// Incrementando o total de nascimentos de cada cidade
		totalBorns += city.Total

		// Alimentando o mapa para dados de comparação
		for _, year := range city.Years {
			contrastData[year.Year] += year.Borns
		}
	}

	// Passando no total de nascidos por ano armazenados inicialmente e validando se bate com o que foi lido agora
	for _, year := range statistics.BornsByYear {
		if contrastData[year.Year] != year.Borns {
			fmt.Printf("Inconsistência na leitura: %d nascidos em %d de acordo com o arquivo e %d de acordo com a leitura.\n", year.Borns, year.Year, contrastData[year.Year])
		}
	}

	// Batendo total de nascidos lidos agora com total de nascidos lidos inicialmente
	if totalBorns != statistics.TotalBorns {
		fmt.Printf("Inconsistência na leitura: %d nascidos de acordo com o arquivo e %d de acordo com a leitura.\n", statistics.TotalBorns, totalBorns)
	}
}

func getMostBornNumberByYear(statistics Statistics) map[int]int {
	// Criando estrutura para armazenar ano => maior número de nascidos
	mostBornNumberByYear := make(map[int]int)

	// Varrendo cidades armazenadas
	for _, city := range statistics.Cities {
		// Varrendo anos das cidades armazenadas
		for _, year := range city.Years {
			// Validando se o total de nascidos é menor que o total desse ano corrente
			if mostBornNumberByYear[year.Year] < year.Borns {
				mostBornNumberByYear[year.Year] = year.Borns // Atribuindo numero de nascidos ao ano
			}
		}
	}

	return mostBornNumberByYear
}

func getLessNumberByYear(statistics Statistics) map[int]int {
	// Criando estrutura para armazenar ano => menor número de nascidos
	lessBornNumberByYear := make(map[int]int)
	// Varrendo cidades armazenadas
	for _, city := range statistics.Cities {
		// Varrendo anos das cidades armazenadas
		for _, year := range city.Years {
			// Validando se o total de nascidos é maior que o total desse ano corrente
			if year.Borns != 0 && lessBornNumberByYear[year.Year] >= year.Borns || lessBornNumberByYear[year.Year] == 0 {
				lessBornNumberByYear[year.Year] = year.Borns // Atribuindo numero de nascidos ao ano
			}
		}
	}

	return lessBornNumberByYear
}

func getBornRateByYear(statistics Statistics) map[int]float64 {
	// Criando estrutura para armazenar ano => média de nascimentos
	bornRateByYear := make(map[int]float64)
	totalCities := len(statistics.Cities)

	// Percorrendo anos
	for _, year := range statistics.BornsByYear {
		bornRateByYear[year.Year] = float64(year.Borns) / float64(totalCities) // calculando média
	}

	return bornRateByYear
}

// OBS.: A maneira como estruturei os dados não me ajudou nada nesse método.
// A integridade dos resultados não foi prejudicada, entretanto a complexidade do código ficou alta devido aos aninhamentos
func getStandartDeviationByYear(statistics Statistics) map[int]float64 {
	// Criando estrutura para comportar ano => desvio padrão
	standartDeviationByYear := make(map[int]float64)

	// Obtendo o número total de cidades a partir da estrutura de dados
	totalCities := len(statistics.Cities)

	// Obtendo a taxa de nascimentos por ano
	bornRate := getBornRateByYear(statistics)

	// Criando um slice para armazenar todos os anos registrados na estrutura de dados
	years := make([]int, 0, len(statistics.BornsByYear))
	for _, key := range statistics.BornsByYear {
		years = append(years, key.Year)
	}

	var accumulate float64
	// Loop pelos anos registrados na estrutura de dados
	for _, year := range years {
		// Loop por cada cidade
		for _, city := range statistics.Cities {
			// Loop por cada ano registrado na cidade
			for _, cityYear := range city.Years {
				// Verificando se o ano atual corresponde ao ano da cidade
				if year == cityYear.Year {
					// Adicionando ao acumulador a medida calculada de acordo com o especificado no github
					accumulate += math.Pow(float64(cityYear.Borns)-bornRate[year], 2)
					break
				}
			}
		}
		// Calculando o desvio padrão para o ano atual e adicionando ao mapa de resultados
		accumulate = math.Sqrt(accumulate / float64(totalCities))
		standartDeviationByYear[year] = accumulate

		// Reiniciando o acumulador para o próximo ano
		accumulate = 0
	}

	// Retornando o mapa de resultados
	return standartDeviationByYear
}

func createAndSeedCsvFile(statistics Statistics, mostBornNumberByYear map[int]int, lessBornNumberByYear map[int]int, bornRateByYear map[int]float64, deviation map[int]float64) {
	// Criando arquivo
	csvFile, err := os.Create("estatisticas.csv")
	defer csvFile.Close()
	defer fmt.Println("> Arquivo estatisticas.csv gerado")

	// Validando possíveis erros na criação do arquivo
	if err != nil {
		fmt.Println("Falha ao criar arquivo .CSV")
		os.Exit(1)
	}

	csvWritter := csv.NewWriter(csvFile)
	defer csvWritter.Flush()

	// Escrevendo cabeçalho do arquivo
	csvWritter.Write([]string{"ano", "maior_numero_nascidos", "menor_numero_nascidos", "media_de_nascimentos", "desvio_padrao", "total_de_nascimentos"})
	// Escrevendo dados correspondentes a cada ano dentro do arquivo
	for _, year := range statistics.BornsByYear {
		csvWritter.Write([]string{strconv.Itoa(year.Year), strconv.Itoa(mostBornNumberByYear[year.Year]), strconv.Itoa(lessBornNumberByYear[year.Year]), fmt.Sprintf("%.f", bornRateByYear[year.Year]), fmt.Sprintf("%.f", deviation[year.Year]), strconv.Itoa(year.Borns)})
	}
}

func createAndSeedDatFile(statistics Statistics) {

	// Criando arquivo
	file, err := os.Create("totais.dat")
	defer file.Close()
	defer fmt.Println("> Arquivo totais.dat gerado")
	// Validando possíveis erros na criação do arquivo
	if err != nil {
		fmt.Println(err)
		return
	}

	data := ""
	// Lendo informações de nascidos por ano e ajustando o formato para inserir no arquivo (acumulando em uma variável)
	for _, v := range statistics.BornsByYear {
		data += fmt.Sprintf("%d %d\n", v.Year, v.Borns)
	}

	// Escrevendo no arquivo
	_, err = file.Write([]byte(data))

	// Validando possíveis erros de escrita no arquivo
	if err != nil {
		fmt.Println("Falha ao criar arquivo .dat")
		os.Exit(1)
	}
}

func createAndGenerateTargetBornsFile(statistics Statistics) {
	fmt.Println("\n> Lendo arquivo alvos.dat")

	// Abrindo arquivos de cidades alvos
	file, err := os.Open("alvos.dat")
	defer file.Close()

	// Validando falhas de leitura no arquivo
	if err != nil {
		fmt.Println("Falha ao ler arquivo alvos.dat")
		os.Exit(1)
	}

	scanner := bufio.NewScanner(file)

	// Criando estrutura para acumular as cidades alvos
	var targetCities []City
	// Varrendo valores dentro do arquivo
	for scanner.Scan() {
		targetCityCode := scanner.Text()
		// Percorrendo todas as cidades
		for _, city := range statistics.Cities {
			if city.Code == targetCityCode {
				targetCities = append(targetCities, city) // Inserindo na estrutura de dados os structs de cada cidade
				break
			}
		}
	}

	// Printando informações dos municípios alvo
	fmt.Printf("Municípios definidos como alvo (%d):\n", len(targetCities))
	for _, city := range targetCities {
		fmt.Println(city.Name)
	}

	// Criando arquivo
	targetFile, err := os.Create("nascimentos-alvos.dat")
	defer targetFile.Close()

	// Validando possíveis erros na criação do arquivo
	defer fmt.Println("\n> Arquivo nascimentos-alvos.dat gerado")
	if err != nil {
		fmt.Println(err)
		return
	}

	// Calculando o total de nascidos para cada município
	outputData := ""
	for _, v := range statistics.BornsByYear {
		totalBornsByYear := 0
		for _, targetCity := range targetCities {
			for _, taragetCityYear := range targetCity.Years {
				if taragetCityYear.Year == v.Year {
					totalBornsByYear += taragetCityYear.Borns
					break
				}
			}
		}

		// Formatando saída para cada registro
		outputData += fmt.Sprintf("%d %d\n", v.Year, totalBornsByYear)
	}

	// Escrevendo no arquivo de saída
	_, err = targetFile.Write([]byte(outputData))

	// Validando possíveis erros nos arquivos de saída
	if err != nil {
		fmt.Println("Falha ao criar arquivo nascimentos-alvos.dat", err.Error())
		os.Exit(1)
	}
}

func calculateCitiesGrowTax(statistics Statistics) {
	// Recuperando quais são os cinco ultimos anos da série
	years := statistics.BornsByYear[len(statistics.BornsByYear)-5:]
	initialYear := years[0].Year // Recuperando ano inicial
	finalYear := years[4].Year   // Recuperando ano final

	greatTax := 0.0
	lowerTax := 0.0

	var greatTaxCity City
	var lowerTaxCity City

	// Percorrendo cidades
	for _, city := range statistics.Cities {
		initialYearBorns := 0
		finalYearBorns := 0

		// Percorrendo anos de cada cidade
		for _, year := range city.Years {
			// Validando se ano é o mesmo do inicial ou final, caso contrário pulando para o próximo
			if year.Year != initialYear && year.Year != finalYear {
				continue
			}
			if year.Year == initialYear {
				initialYearBorns = year.Borns
			}
			if year.Year == finalYear {
				finalYearBorns = year.Borns
			}
		}

		// Validando se algum dos anos é zero
		if finalYearBorns == 0 || initialYearBorns == 0 {
			continue
		}

		// Calculando taxa
		localBornTax := float64(finalYearBorns) / float64(initialYearBorns)

		// Determinando maior e menor taxa
		if localBornTax > greatTax {
			greatTax = localBornTax
			greatTaxCity = city
		}

		if localBornTax < lowerTax || lowerTax == 0.0 {
			lowerTax = localBornTax
			lowerTaxCity = city
		}
	}

	// Ajustando o display text de cada taxa de acordo com a porcentagem
	greaterDisplayText := "crescimento"
	greaterTaxPercentage := 100 * (greatTax - 1) // Calculando porcentagem
	if greaterTaxPercentage < 0 {
		greaterDisplayText = "queda"
	}

	// Mostrando informação ao usuário
	fmt.Println()
	fmt.Printf("Município com maior taxa de %s %d-%d: %s (%.2f%%)\n", greaterDisplayText, initialYear, finalYear, greatTaxCity.Name, greaterTaxPercentage)

	lower := "crescimento"
	lowerTaxPercentage := 100 * (lowerTax - 1) // Calculando porcentagem
	if lowerTaxPercentage < 0 {
		lower = "queda"
	}

	// Mostrando informação ao usuário
	fmt.Printf("Município com maior taxa de %s %d-%d: %s (%.2f%%)\n", lower, initialYear, finalYear, lowerTaxCity.Name, lowerTaxPercentage)
}
