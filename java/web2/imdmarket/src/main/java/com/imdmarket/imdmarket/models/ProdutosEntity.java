package com.imdmarket.imdmarket.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name = "produtos")
public class ProdutosEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;

    @Column(name = "nome_produto")
    @NotBlank(message = "Informe o nome do produto!")
    public String NomeProduto;

    @Column(name = "descricao_produto")
    @NotBlank(message = "Informe a descrição do produto!")
    public String DescricaoProduto;

    @Column(name = "preco_produto")
    @Min(value = 0, message = "Não pode existir preço menor que 0!")
    public float PrecoProduto;

    @Column(name = "data_validade")
    public String DataValidade;

    @Column(name = "estoque")
    @Min(value = 0, message = "Não pode existir estoque menor que 0!")
    public int Estoque;

    @Column(name = "fornecedor")
    public String Fornecedor;
    @Column(name = "ativo")
    public boolean Ativo;
}
