
# **Trabalho 2: Geometria Plana e Espacial - Volume**

Pacote com funções responsável por calcular o volume de figuras geométricas planas, como: triângulo, retângulo, quadrado e circulo; e espaciais, como: pirâmide, cubo, paralelepípedo e esfera.

## **Autores**

- [@Douglas08Santos](https://www.github.com/Douglas08Santos)
- [João Victor]


## **Documentação**

#### Retorna o volume de uma pirâmide com base quadrangular

```golang
func Piramide(base float32, altura float32) float32 {
	//
}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `base` | `float32` | Tamanho da base da pirâmide |
| `altura` | `float32` | Altura da pirâmide|

---

#### Retorna o volume de um cubo

```golang
func Cubo(aresta float32) float32 {
	//
}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `aresta`  | `float32` | Tamanho da aresta do cubo|
---
#### Retorna o volume de um paralelepípedo

```golang
func Paralelepipedo(
	aresta1 float32,
	aresta2 float32,
	aresta3 float32) float32 {
	//
}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `aresta1` | `float32` | Tamanho da aresta1 (ou base) do paralelepípedo |
| `aresta2` | `float32` | Tamanho da aresta2 (ou altura) do paralelepípedo |
| `aresta3` | `float32` | Tamanho da aresta3 (ou comprimento) do paralelepípedo |
---
#### Retorna o volume de uma esfera

```golang
func Esfera(raio float32) float32 {
	//
}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `raio` | `float32` | A distância entre o centro e a extremidade da esfera. |
---

