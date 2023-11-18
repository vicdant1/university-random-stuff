package com.imdmarket.imdmarket.dtos;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class EditProdutoDto {
    @NotNull(message = "É necessário informar o ID!")
    @Min(value = 1, message = "Informe um ID Válido")
    public int Id;
    public String NomeProduto;
    public String DescricaoProduto;
    public float PrecoProduto;
    public String DataValidade;
    public int Estoque;
    public String Fornecedor;
    public boolean Ativo;
}
