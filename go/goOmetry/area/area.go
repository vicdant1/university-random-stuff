package area

import "math"

/*
*	Figura fechada formada por três lados
*
*	Obs.: Para este trabalho, deverá ser
*	considerado um triângulo equilátero,
*	no qual os três lados são congruentes.
*
*	Área = (base * altura)/2
*	Altura = (base * √3)/2
 */

func Triangulo(base float32) float32 {
	altura := (base * float32(math.Sqrt(3))) / 2
	return (base * altura) / 2
}

/*
*	Figura fechada formada por quatro lados
*	que formam ângulos retos (90º)
*
*	Área = base * altura
 */
func Retangulo(base float32, altura float32) float32 {
	return base * altura
}

/*
*	Figura fechada formada por quatro lados
*	congruentes (isto é, de medidas iguais)
*	que formam ângulos retos
*
*	Área = lado²
 */
func Quadrado(lado float32) float32 {
	return lado * lado
}

/*
*	Figura fechada por uma linha curva
*	chamada circunferência
*
*	Área = 'pi' * raio²
 */
func Circulo(raio float32) float32 {
	return math.Pi * (raio * raio)
}

/*
*	Figura composta por uma base poligonal
*	(triangular, quadrangular, etc.) e um
*	vértice que une as faces laterais da
*	pirâmide.
*
*	Obs.: Para este trabalho, deverá ser
*	considerada uma pirâmide com base
*	quadrangular, ou seja, contendo uma
*	base formando um quadrado e quatro faces
*	laterais triangulares.
*
*	Obs.: A área lateral de uma pirâmide
*	é dada pela soma das áreas de todas
*	as faces laterais triangulares.
*
*	Obs.: Calculo de area de uma piramide reta,
*	ou seja, que a altura é perpendicular a base
*
*
*	Área = area_base + area_lateral
*	area_base = base²
*	area_lateral = 4 * area_face
*	area_face = (apótema * base) / 2
*	apótema = √[altura² + (aresta/2)²]
 */
func Piramide(base float32, altura float32) float32 {
	// 1 - calcular o apótema da piramide
	apotema := math.Sqrt(math.Pow(
		float64(altura), 2) + math.Pow(float64(base/2), 2))
	area_face := (base * float32(apotema)) / 2
	area_lateral := 4 * area_face
	area_base := base * base

	return area_base + area_lateral
}

/*
*	Figura composta por seis faces
*	quadrangulares
*
*	Área = 6 * aresta²
 */
func Cubo(aresta float32) float32 {
	return 6 * (aresta * aresta)
}

/*
*	Figura composta por seis faces,
*	tendo três pares de faces idênticas
*	e paralelas entre si
*
*	Área = (2*aresta1*aresta2)
*			+ (2*aresta1*aresta3)
*			+ (2*aresta2*aresta3)
 */
func Paralelepipedo(
	aresta1 float32,
	aresta2 float32,
	aresta3 float32) float32 {
	return (2 * aresta1 * aresta2) + (2 * aresta1 * aresta3) + (2 * aresta2 * aresta3)
}

/*
*	Figura resultante do conjunto de pontos
*	do espaço cuja distância ao centro é igual
*	ou menor que o raio
*
*	Área = 4 * 'pi' * raio²
 */
func Esfera(raio float32) float32 {
	return 4 * math.Pi * (raio * raio)
}
