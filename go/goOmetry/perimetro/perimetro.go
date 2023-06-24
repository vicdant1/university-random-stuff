package perimetro

import "math"

/*
*	Figura fechada formada por três lados
*	Obs.: Para este trabalho, deverá ser
*	considerado um triângulo equilátero,
*	no qual os três lados são congruentes.
*
*	Perímetro = lado1 + lado2 + lado3 = 3*lado
 */
func Triangulo(lado float32) float32 {
	return 3 * lado
}

/*
*	Figura fechada formada por quatro lados
*	que formam ângulos retos (90º)
*
*	Perímetro = 2 * (base + altura)
 */
func Retangulo(base float32, altura float32) float32 {
	return 2 * (base + altura)
}

/*
*	Figura fechada formada por quatro lados
*	congruentes (isto é, de medidas iguais)
*	que formam ângulos retos
*
*	Perímetro = 4 * lado
 */
func Quadrado(lado float32) float32 {
	return 4 * lado
}

/*
*	Figura fechada por uma linha curva
*	chamada circunferência
*
*	Obs.: O perímetro de um círculo é
*	chamado de comprimento da circunferência
*	e r é a medida do raio do círculo, isto é,
*	a distância entre o centro e a extremidade
*	do círculo.
*
*	Perímetro = 2 * 'pi' * raio
 */
func Circulo(raio float32) float32 {
	return 2 * math.Pi * raio
}
