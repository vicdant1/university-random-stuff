package com.imdmarket.imdmarket.controllers;

import com.imdmarket.imdmarket.dtos.EditProdutoDto;
import com.imdmarket.imdmarket.models.ProdutosEntity;
import com.imdmarket.imdmarket.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
    @Autowired
    ProdutoRepository _produtoRepository;

    @GetMapping("/getAll")
    public List<ProdutosEntity> getAll(){
        return _produtoRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public ProdutosEntity getById(@PathVariable(value = "id") int id){
        return _produtoRepository.findById(id);
    }

    @PostMapping("/postProduct")
    public ProdutosEntity postProduct(@Valid @RequestBody ProdutosEntity produto){

        return _produtoRepository.save(produto);
    }

    @PutMapping("/putProduct")
    public ResponseEntity<ProdutosEntity> putProduct(@Valid @RequestBody EditProdutoDto produto){
        ProdutosEntity productInDatabase = _produtoRepository.findById(produto.Id);

        if(productInDatabase == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        productInDatabase.Ativo = produto.Ativo;
        productInDatabase.DescricaoProduto = produto.DescricaoProduto;
        productInDatabase.DataValidade = produto.DataValidade;
        productInDatabase.Fornecedor = produto.Fornecedor;
        productInDatabase.Estoque = produto.Estoque;
        productInDatabase.NomeProduto = produto.NomeProduto;
        productInDatabase.PrecoProduto = produto.PrecoProduto;
        _produtoRepository.save(productInDatabase);


        return new ResponseEntity<>(productInDatabase, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") int id){
        ProdutosEntity productInDatabase = _produtoRepository.findById(id);
        if(productInDatabase == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        _produtoRepository.delete(productInDatabase);

        return new ResponseEntity<>(productInDatabase, HttpStatus.OK);
    }

    @PostMapping("/deleteLogic/{id}")
    public ResponseEntity<ProdutosEntity> deleteLogic(@PathVariable(value = "id") int id){
        ProdutosEntity productInDatabase = _produtoRepository.findById(id);
        if(productInDatabase == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        productInDatabase.Ativo = false;
        _produtoRepository.save(productInDatabase);

        return new ResponseEntity<>(productInDatabase, HttpStatus.OK);
    }
}
