/* Arquivo responsável pelos testes de cálculos de volume definidos no pacote "volume" */

package volume

import "testing"

func TestPyramidVolume(t *testing.T) {
	var expectedVolume float32 = 5.3333333

	volume := Piramide(2, 4)

	if volume != expectedVolume {
		t.Errorf("[FALHA] Volume esperado: %.2f x Volume obtido: %.2f.\n", expectedVolume, volume)
	} else {
		t.Log("[SUCESSO] Volumes compatíveis: resultado calculado corretamente.")
	}
}

func TestNPyramidVolume(t *testing.T) {
	tests := []struct {
		base           float32
		height         float32
		expectedVolume float32
		expectedResult bool
	}{
		{2, 4, 5.3333333, true},
		{5, 4, 15.0, false},
		{3, 6, 3.89, false},
	}

	for _, test := range tests {
		volume := Piramide(test.base, test.height)

		if volume != test.expectedVolume {
			if test.expectedResult {
				t.Errorf("[FALHA] Volume esperado: %.2f, Volume obtido: %.2f", test.expectedVolume, volume)
			} else {
				t.Logf("[SUCESSO] Volumes divergentes: %.2f x %.2f, mas o resultado era esperado como falha", volume, test.expectedVolume)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Volume calculado corretamente: %.2f", volume)
			} else {
				t.Errorf("[FALHA] Volumes esperado: %.2f, Volume obtido: %.2f", test.expectedVolume, volume)
			}
		}
	}
}

func TestCubeVolume(t *testing.T) {
	var expectedVolume float32 = 8

	volume := Cubo(2)

	if volume != expectedVolume {
		t.Errorf("[FALHA] Volume esperado: %.2f x Volume obtido: %.2f.\n", expectedVolume, volume)
	} else {
		t.Log("[SUCESSO] Volumes compatíveis: resultado calculado corretamente.")
	}
}

func TestNCubeVolume(t *testing.T) {
	tests := []struct {
		side           float32
		expectedVolume float32
		expectedResult bool
	}{
		{2, 8, true},
		{5, 444, false},
		{3, 624, false},
	}

	for _, test := range tests {
		volume := Cubo(test.side)

		if volume != test.expectedVolume {
			if test.expectedResult {
				t.Errorf("[FALHA] Volume esperado: %.2f, Volume obtido: %.2f", test.expectedVolume, volume)
			} else {
				t.Logf("[SUCESSO] Volumes divergentes: %.2f x %.2f, mas o resultado era esperado como falha", volume, test.expectedVolume)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Volume calculado corretamente: %.2f", volume)
			} else {
				t.Errorf("[FALHA] Volumes esperado: %.2f, Volume obtido: %.2f", test.expectedVolume, volume)
			}
		}
	}
}

func TestParallelepipedVolume(t *testing.T) {
	var expectedVolume float32 = 48

	volume := Paralelepipedo(2, 4, 6)

	if volume != expectedVolume {
		t.Errorf("[FALHA] Volume esperado: %.2f x Volume obtido: %.2f.\n", expectedVolume, volume)
	} else {
		t.Log("[SUCESSO] Volumes compatíveis: resultado calculado corretamente.")
	}
}

func TestNParallelepipedVolume(t *testing.T) {
	tests := []struct {
		edge1          float32
		edge2          float32
		edge3          float32
		expectedVolume float32
		expectedResult bool
	}{
		{2, 4, 6, 48, true},
		{2, 2, 2, 46, false},
		{2, 42, 6, 38, false},
	}

	for _, test := range tests {
		volume := Paralelepipedo(test.edge1, test.edge2, test.edge3)

		if volume != test.expectedVolume {
			if test.expectedResult {
				t.Errorf("[FALHA] Volume esperado: %.2f, Volume obtido: %.2f", test.expectedVolume, volume)
			} else {
				t.Logf("[SUCESSO] Volumes divergentes: %.2f x %.2f, mas o resultado era esperado como falha", volume, test.expectedVolume)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Volume calculado corretamente: %.2f", volume)
			} else {
				t.Errorf("[FALHA] Volumes esperado: %.2f, Volume obtido: %.2f", test.expectedVolume, volume)
			}
		}
	}
}

func TestSphereVolume(t *testing.T) {
	var expectedVolume float32 = 33.510323

	volume := Esfera(2)

	if volume != expectedVolume {
		t.Errorf("[FALHA] Volume esperado: %.2f x Volume obtido: %.2f.\n", expectedVolume, volume)
	} else {
		t.Log("[SUCESSO] Volumes compatíveis: resultado calculado corretamente.")
	}
}

func TestNSphereVolume(t *testing.T) {
	tests := []struct {
		radius         float32
		expectedVolume float32
		expectedResult bool
	}{
		{2, 33.510323, true},
		{3, 35, false},
		{6, 31, false},
	}

	for _, test := range tests {
		volume := Esfera(test.radius)

		if volume != test.expectedVolume {
			if test.expectedResult {
				t.Errorf("[FALHA] Volume esperado: %.2f, Volume obtido: %.2f", test.expectedVolume, volume)
			} else {
				t.Logf("[SUCESSO] Volumes divergentes: %.2f x %.2f, mas o resultado era esperado como falha", volume, test.expectedVolume)
			}
		} else {
			if test.expectedResult {
				t.Logf("[SUCESSO] Volume calculado corretamente: %.2f", volume)
			} else {
				t.Errorf("[FALHA] Volumes esperado: %.2f, Volume obtido: %.2f", test.expectedVolume, volume)
			}
		}
	}
}
