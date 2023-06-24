/* Arquivo responsável pelos testes de cálculos de áreas definidos no pacote "area" */

package area

import (
	"math"
	"testing"
)

func TestTriangleArea(t *testing.T) {
	var expectedArea float32 = 5

	area := Triangulo(4)

	if area != expectedArea {
		t.Errorf("[FALHA] Área esperada: %.2f x Área obtida: %.2f.\n", expectedArea, area)
	} else {
		t.Log("[SUCESSO] Áreas compatíveis: resultado calculado corretamente.")
	}
}

func TestNTriangleArea(t *testing.T) {
	tests := []struct {
		base           float32
		expectedArea   float32
		expectedResult bool
	}{
		{4, 6.8, true},
		{5, 10.0, false},
		{3, 3.89, true},
	}

	for _, test := range tests {
		area := Triangulo(test.base)

		if area != test.expectedArea {
			if test.expectedResult {
				t.Errorf("[FALHA] Área esperada: %.2f, Área obtida: %.2f", test.expectedArea, area)
			} else {
				t.Logf("[SUCESSO] Área divergentes: %.2f x %.2f, mas o resultado era esperado como falha", area, test.expectedArea)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Área calculada corretamente: %.2f", area)
			} else {
				t.Errorf("[FALHA] Área esperada: %.2f, Área obtida: %.2f", test.expectedArea, area)
			}
		}
	}
}

func TestRectangleArea(t *testing.T) {
	var expectedArea float32 = 50.0
	area := Retangulo(5, 10)

	if area != expectedArea {
		t.Errorf("[FALHA] Área esperada: %.2f x Área obtida: %.2f.\n", expectedArea, area)
	} else {
		t.Log("[SUCESSO] Áreas compatíveis: resultado calculado corretamente.")
	}
}

func TestNRectangleArea(t *testing.T) {
	tests := []struct {
		base           float32
		height         float32
		expectedArea   float32
		expectedResult bool
	}{
		{5, 10, 50.0, true},
		{3, 7, 22.0, false},
		{2, 8, 16.0, true},
	}

	for _, test := range tests {
		area := Retangulo(test.base, test.height)

		if area != test.expectedArea {
			if test.expectedResult {
				t.Errorf("[FALHA] Área esperada: %.2f, Área obtida: %.2f", test.expectedArea, area)
			} else {
				t.Logf("[SUCESSO] Área divergentes: %.2f x %.2f, mas o resultado era esperado como falha", area, test.expectedArea)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Área calculada corretamente: %.2f", area)
			} else {
				t.Errorf("[FALHA] Área esperada: %.2f, Área obtida: %.2f", test.expectedArea, area)
			}
		}
	}
}

func TestSquareArea(t *testing.T) {
	var expectedArea float32 = 25.0
	area := Quadrado(5)

	if area != expectedArea {
		t.Errorf("[FALHA] Área esperada: %.2f x Área obtida: %.2f.\n", expectedArea, area)
	} else {
		t.Log("[SUCESSO] Áreas compatíveis: resultado calculado corretamente.")
	}
}

func TestNSquareArea(t *testing.T) {
	tests := []struct {
		side           float32
		expectedArea   float32
		expectedResult bool
	}{
		{5, 25.0, true},
		{3, 9.0, true},
		{2, 4.5, false},
	}

	for _, test := range tests {
		area := Quadrado(test.side)

		if area != test.expectedArea {
			if test.expectedResult {
				t.Errorf("[FALHA] Área esperada: %.2f, Área obtida: %.2f", test.expectedArea, area)
			} else {
				t.Logf("[SUCESSO] Áreas divergentes: %.2f x %.2f, mas o resultado era esperado como falha", area, test.expectedArea)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Área calculada corretamente: %.2f", area)
			} else {
				t.Errorf("[FALHA] Área esperada: %.2f, Área obtida: %.2f", test.expectedArea, area)
			}
		}
	}
}

func TestCircleArea(t *testing.T) {
	var expectedArea float32 = math.Pi * 3 * 3

	area := Circulo(3)

	if area != expectedArea {
		t.Errorf("[FALHA] Área esperada: %.2f x Área obtida: %.2f.\n", expectedArea, area)
	} else {
		t.Log("[SUCESSO] Áreas compatíveis: resultado calculado corretamente.")
	}
}

func TestNCircleArea(t *testing.T) {
	tests := []struct {
		radius         float32
		expectedArea   float32
		expectedResult bool
	}{
		{3, math.Pi * 3 * 3, true},
		{4, 50.24, false},
		{2, 12.56, true},
	}

	for _, test := range tests {
		area := Circulo(test.radius)

		if area != test.expectedArea {

			if test.expectedResult {
				t.Errorf("[FALHA] Área esperada: %.2f, Área obtida: %.2f", test.expectedArea, area)
			} else {
				t.Logf("[SUCESSO] Área divergentes: %.2f x %.2f, mas o resultado era esperado como falha", area, test.expectedArea)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Área calculada corretamente: %.2f", area)
			} else {
				t.Errorf("[FALHA] Área esperada: %.2f, Área obtida: %.2f", test.expectedArea, area)
			}
		}
	}
}

func TestPyramidArea(t *testing.T) {
	var expectedArea float32 = 72.169907
	area := Piramide(5, 4)

	if area != expectedArea {
		t.Errorf("[FALHA] Área esperada: %.2f x Área obtida: %.2f.\n", expectedArea, area)
	} else {
		t.Log("[SUCESSO] Áreas compatíveis: resultado calculado corretamente.")
	}
}

func TestNPyramidArea(t *testing.T) {
	tests := []struct {
		baseLength     float32
		height         float32
		expectedArea   float32
		expectedResult bool
	}{
		{5, 10, 128.077637, true},
		{3, 7, 42.0, false},
		{2, 8, 48.0, false},
	}

	for _, test := range tests {
		area := Piramide(test.baseLength, test.height)

		if area != test.expectedArea {
			if test.expectedResult {
				t.Errorf("[FALHA] Área esperada: %.2f, Área obtida: %.2f", test.expectedArea, area)
			} else {
				t.Logf("[SUCESSO] Áreas divergentes: %.2f x %.2f, mas o resultado era esperado como falha", area, test.expectedArea)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Área calculada corretamente: %.2f", area)
			} else {
				t.Errorf("[FALHA] Área esperada: %.2f, Área obtida: %.2f", test.expectedArea, area)
			}
		}
	}
}

func TestCubeArea(t *testing.T) {
	var expectedArea float32 = 54.0
	area := Cubo(3)

	if area != expectedArea {
		t.Errorf("[FALHA] Área esperada: %.2f x Área obtida: %.2f.\n", expectedArea, area)
	} else {
		t.Log("[SUCESSO] Áreas compatíveis: resultado calculado corretamente.")
	}
}

func TestNCubeArea(t *testing.T) {
	tests := []struct {
		edge           float32
		expectedArea   float32
		expectedResult bool
	}{
		{3, 54.0, true},
		{4, 95.0, false},
		{5, 153.0, false},
	}

	for _, test := range tests {
		area := Cubo(test.edge)

		if area != test.expectedArea {
			if test.expectedResult {
				t.Errorf("[FALHA] Área esperada: %.2f, Área obtida: %.2f", test.expectedArea, area)
			} else {
				t.Logf("[SUCESSO] Áreas divergentes: %.2f x %.2f, mas o resultado era esperado como falha", area, test.expectedArea)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Área calculada corretamente: %.2f", area)
			} else {
				t.Errorf("[FALHA] Área esperada: %.2f, Área obtida: %.2f", test.expectedArea, area)
			}
		}
	}
}

func TestParallelepipedArea(t *testing.T) {
	var expectedArea float32 = 94.0
	area := Paralelepipedo(3, 4, 5)

	if area != expectedArea {
		t.Errorf("[FALHA] Área esperada: %.2f x Área obtida: %.2f.\n", expectedArea, area)
	} else {
		t.Log("[SUCESSO] Áreas compatíveis: resultado calculado corretamente.")
	}
}

func TestNParallelepipedArea(t *testing.T) {
	tests := []struct {
		length         float32
		width          float32
		height         float32
		expectedArea   float32
		expectedResult bool
	}{
		{3, 4, 5, 94.0, true},
		{2, 3, 4, 52.0, true},
		{4, 5, 6, 149.0, false},
	}

	for _, test := range tests {
		area := Paralelepipedo(test.length, test.width, test.height)

		if area != test.expectedArea {
			if test.expectedResult {
				t.Errorf("[FALHA] Área esperada: %.2f, Área obtida: %.2f", test.expectedArea, area)
			} else {
				t.Logf("[SUCESSO] Áreas divergentes: %.2f x %.2f, mas o resultado era esperado como falha", area, test.expectedArea)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Área calculada corretamente: %.2f", area)
			} else {
				t.Errorf("[FALHA] Área esperada: %.2f, Área obtida: %.2f", test.expectedArea, area)
			}
		}
	}
}

func TestSphereArea(t *testing.T) {
	var expectedArea float32 = 314.15927
	area := Esfera(5)

	if area != expectedArea {
		t.Errorf("[FALHA] Área esperada: %.2f x Área obtida: %.2f.\n", expectedArea, area)
	} else {
		t.Log("[SUCESSO] Áreas compatíveis: resultado calculado corretamente.")
	}
}

func TestNSphereArea(t *testing.T) {
	tests := []struct {
		radius         float32
		expectedArea   float32
		expectedResult bool
	}{
		{3, 153.09734, false},
		{4, 211.06193, false},
		{5, 314.15927, true},
	}

	for _, test := range tests {
		area := Esfera(test.radius)

		if area != test.expectedArea {
			if test.expectedResult {
				t.Errorf("[FALHA] Área esperada: %.5f, Área obtida: %.5f", test.expectedArea, area)
			} else {
				t.Logf("[SUCESSO] Áreas divergentes: %.5f x %.5f, mas o resultado era esperado como falha", area, test.expectedArea)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Área calculada corretamente: %.5f", area)
			} else {
				t.Errorf("[FALHA] Área esperada: %.5f, Área obtida: %.5f", test.expectedArea, area)
			}
		}
	}
}
