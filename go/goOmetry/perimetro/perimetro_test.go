/* Arquivo responsável pelos testes de cálculos de perímetro definidos no pacote "perimetro" */

package perimetro

import "testing"

func TestTrianglePerimeter(t *testing.T) {
	var expectedPerimeter float32 = 12

	perimeter := Triangulo(4)

	if perimeter != expectedPerimeter {
		t.Errorf("[FALHA] Perímetro esperado: %.2f x Perímetro obtido: %.2f.\n", expectedPerimeter, perimeter)
	} else {
		t.Log("[SUCESSO] Perímetros compatíveis: resultado calculado corretamente.")
	}
}

func TestNTrianglePerimeter(t *testing.T) {
	tests := []struct {
		base              float32
		expectedPerimeter float32
		expectedResult    bool
	}{
		{4, 12.0, true},
		{5, 15.0, true},
		{3, 3.89, false},
	}

	for _, test := range tests {
		perimeter := Triangulo(test.base)

		if perimeter != test.expectedPerimeter {
			if test.expectedResult {
				t.Errorf("[FALHA] Perímetro esperado: %.2f, Perímetro obtido: %.2f", test.expectedPerimeter, perimeter)
			} else {
				t.Logf("[SUCESSO] Perímetros divergentes: %.2f x %.2f, mas o resultado era esperado como falha", perimeter, test.expectedPerimeter)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Perímetro calculado corretamente: %.2f", perimeter)
			} else {
				t.Errorf("[FALHA] Perímetros esperado: %.2f, Perímetro obtido: %.2f", test.expectedPerimeter, perimeter)
			}
		}
	}
}

func TestRectanglePerimeter(t *testing.T) {
	var expectedPerimeter float32 = 12

	perimeter := Retangulo(2, 4)

	if perimeter != expectedPerimeter {
		t.Errorf("[FALHA] Perímetro esperado: %.2f x Perímetro obtido: %.2f.\n", expectedPerimeter, perimeter)
	} else {
		t.Log("[SUCESSO] Perímetros compatíveis: resultado calculado corretamente.")
	}
}

func TestNRectanglePerimeter(t *testing.T) {
	tests := []struct {
		base              float32
		height            float32
		expectedPerimeter float32
		expectedResult    bool
	}{
		{4, 2, 12.0, true},
		{5, 4, 18.0, true},
		{3, 5, 3.89, false},
	}

	for _, test := range tests {
		perimeter := Retangulo(test.base, test.height)

		if perimeter != test.expectedPerimeter {
			if test.expectedResult {
				t.Errorf("[FALHA] Perímetro esperado: %.2f, Perímetro obtido: %.2f", test.expectedPerimeter, perimeter)
			} else {
				t.Logf("[SUCESSO] Perímetros divergentes: %.2f x %.2f, mas o resultado era esperado como falha", perimeter, test.expectedPerimeter)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Perímetro calculado corretamente: %.2f", perimeter)
			} else {
				t.Errorf("[FALHA] Perímetros esperado: %.2f, Perímetro obtido: %.2f", test.expectedPerimeter, perimeter)
			}
		}
	}
}

func TestSquarePerimeter(t *testing.T) {
	var expectedPerimeter float32 = 12

	perimeter := Quadrado(3)

	if perimeter != expectedPerimeter {
		t.Errorf("[FALHA] Perímetro esperado: %.2f x Perímetro obtido: %.2f.\n", expectedPerimeter, perimeter)
	} else {
		t.Log("[SUCESSO] Perímetros compatíveis: resultado calculado corretamente.")
	}
}

func TestNSquarePerimeter(t *testing.T) {
	tests := []struct {
		side              float32
		expectedPerimeter float32
		expectedResult    bool
	}{
		{4, 16.0, true},
		{5, 20.0, true},
		{3, 8.0, false},
	}

	for _, test := range tests {
		perimeter := Quadrado(test.side)

		if perimeter != test.expectedPerimeter {
			if test.expectedResult {
				t.Errorf("[FALHA] Perímetro esperado: %.2f, Perímetro obtido: %.2f", test.expectedPerimeter, perimeter)
			} else {
				t.Logf("[SUCESSO] Perímetros divergentes: %.2f x %.2f, mas o resultado era esperado como falha", perimeter, test.expectedPerimeter)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Perímetro calculado corretamente: %.2f", perimeter)
			} else {
				t.Errorf("[FALHA] Perímetros esperado: %.2f, Perímetro obtido: %.2f", test.expectedPerimeter, perimeter)
			}
		}
	}
}

func TestCircunferenceLength(t *testing.T) {
	var CircunferenceLength float32 = 18.849556

	circunferenceLength := Circulo(3)

	if circunferenceLength != CircunferenceLength {
		t.Errorf("[FALHA] Perímetro esperado: %.2f x Perímetro obtido: %.2f.\n", CircunferenceLength, circunferenceLength)
	} else {
		t.Log("[SUCESSO] Perímetros compatíveis: resultado calculado corretamente.")
	}
}

func TestNCircunferenceLength(t *testing.T) {
	tests := []struct {
		side                float32
		CircunferenceLength float32
		expectedResult      bool
	}{
		{3, 18.849556, true},
		{5, 20.0, false},
		{3, 8.0, false},
	}

	for _, test := range tests {
		circunferenceLength := Circulo(test.side)

		if circunferenceLength != test.CircunferenceLength {
			if test.expectedResult {
				t.Errorf("[FALHA] Comprimento de Circunferência esperado: %.2f, Comprimento de Circunferência obtido: %.2f", test.CircunferenceLength, circunferenceLength)
			} else {
				t.Logf("[SUCESSO] Comprimentos de Circunferência divergentes: %.2f x %.2f, mas o resultado era esperado como falha", circunferenceLength, test.CircunferenceLength)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Comprimento de Circunferência calculado corretamente: %.2f", circunferenceLength)
			} else {
				t.Errorf("[FALHA] Comprimento de Circunferência esperado: %.2f, Comprimento de Circunferência obtido: %.2f", test.CircunferenceLength, circunferenceLength)
			}
		}
	}
}
