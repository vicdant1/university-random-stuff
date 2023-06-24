package volume

import "math"

/*
*	Figura composta por uma base poligonal
*	(triangular, quadrangular, etc.) e um
*	vértice que une as faces laterais da
*	pirâmide
*
*	Obs.: Para este trabalho, deverá ser
*	considerada uma pirâmide com base
*	quadrangular, ou seja, contendo uma
*	base formando um quadrado e quatro
*	faces laterais triangulares.
*
*	Obs.: A área lateral de uma pirâmide
*	é dada pela soma das áreas de todas
*	as faces laterais triangulares.
*
*	Volume = (1/3) * area_base * altura
*	area_base = base²
 */
func Piramide(base float32, altura float32) float32 {
	area_base := base * base
	return (area_base * altura) / 3
}

/*
*	Figura composta por seis faces
*	quadrangulares
*
*	Volume = aresta³
 */
func Cubo(aresta float32) float32 {
	return (aresta * aresta * aresta)
}

/*
*	Figura composta por seis faces,
*	tendo três pares de faces idênticas
*	e paralelas entre si
*
*	Volume = aresta1 * aresta2 * aresta3
 */
func Paralelepipedo(
	aresta1 float32,
	aresta2 float32,
	aresta3 float32) float32 {
	return aresta1 * aresta2 * aresta3
}

/*
*	Figura resultante do conjunto de pontos
*	do espaço cuja distância ao centro é igual
*	ou menor que o raio
*
*	Volume = (4/3) * 'pi' * raio³
 */
func Esfera(raio float32) float32 {
	return ((raio * raio * raio) * math.Pi * 4) / 3
}
