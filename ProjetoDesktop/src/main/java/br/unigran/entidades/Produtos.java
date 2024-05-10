package br.unigran.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produtos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="Codigo do produto")
    double codProd;
    @Column (name="Fornecedor")
    String fornecedor;
    @Column(name="Categoria")
    String categoria;
    @Column(name="Valor da venda")
    double valorVenda;
    @Column(name="Valor de compra")
    double valorCompra;
    @Column(name="Quantidade")
    double quantidade;
    @Column(name="Quantidade minima")
    int minQuantidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCodProd() {
        return codProd;
    }

    public void setCodProd(double codProd) {
        this.codProd = codProd;
    }


    public void setCodProd(Integer codProd) {
        this.codProd = codProd;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public int getMinQuantidade() {
        return minQuantidade;
    }

    public void setMinQuantidade(int minQuantidade) {
        this.minQuantidade = minQuantidade;
    }
    
}
